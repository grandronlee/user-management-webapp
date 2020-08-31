package com.hive6.um.webapp;

import java.util.Optional;

import com.hive6.um.webapp.core.user.UserEntity;
import com.hive6.um.webapp.core.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public @ResponseBody Optional<UserEntity> getUser(@PathVariable Long id) {
        return userService.getUsers(id);
    }

    @GetMapping("/users")
	public @ResponseBody Iterable<UserEntity> getAllUsers() {
        return userService.getUsers();
    }
    
    @PostMapping("/user")
    public @ResponseBody UserEntity newUser(@RequestBody UserRequestBody newUser) {
        UserEntity user = new UserEntity();
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
		return userService.addUser(user);
    }
}