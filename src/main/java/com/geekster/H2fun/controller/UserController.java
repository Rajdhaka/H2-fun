package com.geekster.H2fun.controller;

import com.geekster.H2fun.model.Users;
import com.geekster.H2fun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(value = "/users")
    public Iterable<Users> getUsers(){
        return userService.getAllUsers();
    }
    @GetMapping(value = "/user/{id}")
    public Optional<Users> getUserById(@PathVariable String id){
        return userService.findUserById(id);
    }
    @GetMapping(value = "/user/name/{name}")
    public Users getUserByName(@PathVariable String name){
        return userService.fetchUserByName(name);
    }

    @GetMapping(value = "/user/age/{age}")
    public List<Users>getUserByAge(@PathVariable Integer age){
        return userService.fetchUserByAge(age);
    }

    //custom query
    @GetMapping(value = "/userSort")
    public List<Users>getSortedUsers(){
        return userService.fetchSortedUsers();
    }

    @GetMapping(value = "/userWhere/{age}")
    public List<Users>getUsersWhereAge(@PathVariable Integer age){
        return userService.getAllUsersWhereAge(age);
    }




    @PostMapping( value = "/users")
    public String insertUsers(@RequestBody List<Users>userList){
        return userService.addUsers(userList);
    }

    @DeleteMapping(value = "/user/delete/{id}")
    public void deleteUserById(@PathVariable Integer id){
        userService.removeUserById(id);
    }



}
