package com.crudrest.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudrest.dto.UserDto;
import com.crudrest.entity.User;
import com.crudrest.exception.EmailAlreadyExistsException;
import com.crudrest.exception.ResourceNotFoundException;
import com.crudrest.repository.UserRepository;
import com.crudrest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
//		User user = UserMapper.mapToUser(userDto);
		Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
		if (optionalUser.isPresent()) {
			throw new EmailAlreadyExistsException("Email already exists for a user");
		}

		User user = modelMapper.map(userDto, User.class);
		User savedUser = userRepository.save(user);
//		return UserMapper.mapToUserDto(savedUser);
		return modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto getUserById(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//		return UserMapper.mapToUserDto(user.get());
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
//		return userRepository.findAll().stream().map(UserMapper::mapToUserDto).toList();
		return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).toList();
	}

	@Override
	public UserDto updateUser(Long userId, UserDto userDto) {
		Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
		if (optionalUser.isPresent()) {
			throw new EmailAlreadyExistsException("Email already exists for a user");
		}

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		user.setEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
//		return UserMapper.mapToUserDto(userRepository.save(user));
		return modelMapper.map(userRepository.save(user), UserDto.class);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

}
