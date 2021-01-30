package com.example.simpleproject.controllers;


import com.example.simpleproject.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/users")
public class MainController {

    private List<User> userList = Stream.of(
            new User(1L, "Ivan", "Ivanov"),
            new User(2L, "Ivan2", "Ivanov2"),
            new User(3L, "Ivan3", "Ivanov3"),
            new User(4L, "Ivan4", "Ivanov4")
    ).collect(Collectors.toList());

    @GetMapping
    public List<User> getAll(){
        return userList;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userList.stream().filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public User userAdd(@RequestBody User user) {
        this.userList.add(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        this.userList.removeIf(user -> user.getId().equals(id));
    }
}
