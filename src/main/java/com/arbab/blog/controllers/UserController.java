package com.arbab.blog.controllers;

import com.arbab.blog.payloads.ApiResponse;
import com.arbab.blog.payloads.UserDto;
import com.arbab.blog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Post
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
       UserDto createdUser= this.userService.createUser(userDto);
       return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    //Put
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer uid){
        UserDto updateUser = this.userService.updateUser(userDto,uid);
        return ResponseEntity.ok(updateUser);
    }
    //Delete
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
        return new ResponseEntity(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);
    }

    //Get all user
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> allUser = this.userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
        UserDto userById = this.userService.getUserById(userId);

        return ResponseEntity.ok(userById);
    }


}
