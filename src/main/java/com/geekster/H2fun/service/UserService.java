package com.geekster.H2fun.service;

import com.geekster.H2fun.model.Users;
import com.geekster.H2fun.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService  {
    @Autowired
    IUserRepository userRepository;
    public Iterable<Users> getAllUsers() {
        Iterable<Users> allUsers = userRepository.findAll();
        return allUsers;
    }


    public String addUsers(List<Users> userList) {
        Iterable<Users> addedUsers = userRepository.saveAll(userList);
        if(addedUsers != null){
            return "Yes";
        }
        else {
            return "No";
        }

    }

    public void removeUserById(Integer id) {
        userRepository.deleteById(id);
    }

    public Optional<Users> findUserById(String id) {
        Integer userId=Integer.parseInt(id);
        return userRepository.findById(userId);
    }

    public Users fetchUserByName(String name) {
        return userRepository.findByName(name);
    }

    public List<Users> fetchUserByAge(Integer age) {
        return userRepository.findByAgeGreaterThan(age);
    }

    public List<Users> fetchSortedUsers() {
        return userRepository.findUsersOrderedByAgeASC();
    }

    public List<Users> getAllUsersWhereAge(Integer age) {
       return userRepository.findUserAccordingToAge(age);
    }
}
