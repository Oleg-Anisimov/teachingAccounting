package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.User;
import me.anisimov.teachingAccounting.dto.UserDto;
import me.anisimov.teachingAccounting.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "UserController", tags = {"Методы для работы с пользователем"})
public class UserController {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @PostMapping("/create")
    public UserDto create(@RequestBody UserDto userDto) {
        return userDetailsServiceImpl.createUser(userDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        userDetailsServiceImpl.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody User user) {
        userDetailsServiceImpl.updateUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public User getById(Long id) {
        return userDetailsServiceImpl.getById(id);
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userDetailsServiceImpl.getAll();
    }

    @GetMapping("/bylogin")
    public User getByLogin(String login) {
        return userDetailsServiceImpl.findByLogin(login);
    }


}
