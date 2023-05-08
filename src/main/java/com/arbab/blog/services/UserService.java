package com.arbab.blog.services;

import com.arbab.blog.payloads.UserDto;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface UserService {

    UserDto registerNewUser(UserDto userDto);
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto userDto,  Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUser();
    void deleteUser(Integer userId);


}
