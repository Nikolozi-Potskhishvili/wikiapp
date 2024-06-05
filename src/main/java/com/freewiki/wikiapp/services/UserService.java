package com.freewiki.wikiapp.services;

import com.freewiki.wikiapp.model.User;
import com.freewiki.wikiapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User checkLogin(String username, String password) {
        Optional<User> accountToLogIn = userRepository.findUserByUsername(username);
        if(accountToLogIn.isPresent()) {
            User user = accountToLogIn.get();
            if(user.getPassword().equals(password)) {
                return user;
            } else {
                throw new IllegalStateException("Password is incorrect");
            }
        } else {
            throw new IllegalStateException("Such login does not exist");
        }
    }

    public User getUserById(long id) {
        Optional<User> user = userRepository.findUserById(id);
        if(user.isPresent()) return user.get();
        throw new RuntimeException("No such user exists");
    }

    public void addNewUser(User user) {
       Optional<User> userByEmail =  userRepository.findUserByEmail(user.getEmail());
        Optional<User> userByUsername = userRepository.findUserByUsername(user.getUsername());
       if(userByEmail.isPresent()) {
           throw new IllegalStateException("Email is taken");
       } else if(userByUsername.isPresent()) {
           throw new IllegalStateException("Username is taken");
       }
       userRepository.insertUser(user.getCreatedAt(), user.getEmail(), user.getPassword(), user.getUsername());
    }
}
