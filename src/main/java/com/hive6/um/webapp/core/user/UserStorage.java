package com.hive6.um.webapp.core.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserStorage {
    @Autowired private UserRepository userRepository;
    
    public List<UserEntity> getUsers() {        
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUser(Long id) {
        return userRepository.findById(id);
    }

    public UserEntity addUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public Optional<UserEntity> updateUser(UserEntity userEntity) {
        return userRepository.findById(userEntity.getId())
        .map(UserEntity -> {
          userEntity.setName(userEntity.getName());
          return userRepository.save(userEntity);
        });
    }
}