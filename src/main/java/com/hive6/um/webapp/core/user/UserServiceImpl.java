package com.hive6.um.webapp.core.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserStorage userStorage;

    @Autowired
    public UserServiceImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public List<UserEntity> getUsers() {
        return userStorage.getUsers();
    }

    @Override
    public Optional<UserEntity> getUsers(Long id) {
        return userStorage.getUser(id);
    }

    @Override
    public UserEntity addUser(UserEntity userEntity) {
        //TODO add user - check user exist
        return userStorage.addUser(userEntity);
    }
    
}