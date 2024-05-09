package net.javaguides.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguides.springboot.validator.Password;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Email
    @NotEmpty(message = "Email should not be empty")
    private String email;
//    @Length(min = 6, message = "Password must be at least 6 characters")
//    @NotBlank(message = "Password should not be empty")
//    @Password(message = "Password must be at least 6 characters")
    @Password
    private String password;
}
