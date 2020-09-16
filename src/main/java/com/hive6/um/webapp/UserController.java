package com.hive6.um.webapp;

import java.util.List;
import java.util.Optional;

import com.hive6.um.webapp.core.user.UserEntity;
import com.hive6.um.webapp.core.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Long id) {
        Optional<UserEntity> user = userService.getUsers(id);
        if (!user.isPresent()) {
            //log.error("Id " + id + " is not existed");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserEntity());
        }
        return ResponseEntity.ok(user.get());
    }

    @GetMapping("/users")
	public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
    
    @PostMapping("/user")
    public @ResponseBody UserEntity newUser(@RequestBody UserRequestBody newUser) {
        UserEntity user = new UserEntity();
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
		return userService.addUser(user);
    }

    @PutMapping("/user")
    public @ResponseBody UserEntity updateUser(@RequestBody UserRequestBody updateUser) {
        UserEntity user = new UserEntity();
        user.setId(updateUser.getId());
        user.setEmail(updateUser.getEmail());
        user.setName(updateUser.getName());
		return userService.addUser(user);
    }
}