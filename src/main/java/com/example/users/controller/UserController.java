package com.example.users.controller;

import com.example.users.model.User;
import com.example.users.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/getall")
    public List<User> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/get")
    public User getUserByid(@RequestParam(value = "id") int id) {
        return this.userService.getUserById(id);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        this.userService.addUser(user);
    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user) throws Exception {
        this.userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        this.userService.removeUser(id);
    }



}
