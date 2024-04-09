package com.meiradev.userdept.controllers;

import com.meiradev.userdept.entities.User;
import com.meiradev.userdept.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    //Listar todos os usuários
    @GetMapping
    public List<User> findAll() {
        List<User> result = repository.findAll();
        return result;
    }

    //Listar usuário por id
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        User result = repository.findById(id).get();
        return result;
    }

    //Inserir novo usuário
    @PostMapping
    public User insert(@RequestBody User user) {
        User result = repository.save(user);
        return result;
    }
}
