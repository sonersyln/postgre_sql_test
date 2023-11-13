package com.example.users.service;

import com.example.users.model.User;
import com.example.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceImple implements UserService{

    @Autowired
    private final UserRepository USER_REPOSITORY;


    @Override
    public List<User> getAll() {
        return this.USER_REPOSITORY.findAll();
    }

    @Override
    public void addUser(User user) {
        this.USER_REPOSITORY.save(user);
    }

    @Override
    public void removeUser(int id) {
        this.USER_REPOSITORY.deleteById(id);
    }

    @Override
    public void update(int id, User user) throws Exception{
        User user1 = this.USER_REPOSITORY.findById(id).orElseThrow(() -> new Exception ("User not found"));
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setCountry(user.getCountry());
        user1.setGender(user.getGender());
        user1.setBirthday(user.getBirthday());
        this.USER_REPOSITORY.save(user1);
    }

    @Override
    public User getUserById(int id){
        return this.USER_REPOSITORY.findById(id).orElseThrow();
    }
}
