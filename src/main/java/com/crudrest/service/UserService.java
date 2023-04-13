package com.crudrest.service;

import java.util.List;

import com.crudrest.dto.UserDto;

public interface UserService {

	public UserDto createUser(UserDto userDto);

	public UserDto getUserById(Long userId);

	public List<UserDto> getAllUsers();

	public UserDto updateUser(Long userId, UserDto user);
	
	public void deleteUser(Long userId);
}
