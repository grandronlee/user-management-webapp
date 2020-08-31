package com.hive6.um.webapp.core.user;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<UserEntity> getUsers();
    public Optional<UserEntity> getUsers(Long id);
    public UserEntity addUser(UserEntity userEntity);
}