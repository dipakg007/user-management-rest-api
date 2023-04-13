package com.crudrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudrest.dto.UserDto;
import com.crudrest.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "CRUD REST API's for user resource", description = "CRUD Rest APIS - Create User, Update User, Get User, Get All User, Delete Users")
@RestController
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Build create User Rest API
	@Operation(summary = "Create User REST API", description = "Create User REST API is used to save user in a database")
	@ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	// Build get user by id REST API
	@Operation(summary = "Get User by ID REST API", description = "Get User by ID REST API is used to get a single user from the database")
	@ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
		UserDto userDto = userService.getUserById(userId);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	// Build get all users REST API
	@Operation(summary = "Get All Users REST API", description = "Get All Users REST API is used to get all user from the database")
	@ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
	@GetMapping()
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	// Build update user by id
	@Operation(summary = "Update Users REST API", description = "Update Users REST API is used to update a particular user in the database")
	@ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @Valid @RequestBody UserDto user) {
		UserDto updatedUser = userService.updateUser(userId, user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@Operation(summary = "Delete User REST API", description = "Delete User by ID REST API is used to delete a user by its ID from the database")
	@ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>("User sucessfully deleted", HttpStatus.OK);
	}
}
