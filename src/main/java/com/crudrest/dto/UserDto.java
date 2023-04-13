package com.crudrest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "UserDto Model Information")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Long id;

	@Schema(description = "User first name")
	@NotEmpty(message = "User first name sould not be null or empty")
	private String firstName;

	@Schema(description = "User last name")
	@NotEmpty(message = "User last name sould not be null or empty")
	private String lastName;

	@Schema(description = "User email address")
	@Email(message = "User email address sould be valid")
	@NotEmpty(message = "User email address sould not be null or empty")
	private String email;
}
