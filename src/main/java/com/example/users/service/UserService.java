package com.example.users.service;

import com.example.users.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void addUser(User user);

    void update(int id, User user) throws Exception;

    void removeUser(int id);

    User getUserById (int id);

}
