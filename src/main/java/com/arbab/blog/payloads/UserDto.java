package com.arbab.blog.payloads;

import com.arbab.blog.entities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;
    @NotEmpty
    @Size(min = 4,message = "Username must be min 4 character")
    private String name;
    @Email(message = "Email address is not valid !!")
    private String email;
    @NotEmpty
    @Size(min = 3,max = 10,message = "password must be min 3 chars and max of 10 chars !!")
    private String password;
    @NotEmpty
    private String about;

    private Set<RoleDto> roles= new HashSet<>();

}
