package com.freewiki.wikiapp.services;

import com.freewiki.wikiapp.model.MyUser;
import com.freewiki.wikiapp.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MyUserService {
    private final MyUserRepository myUserRepository;

    @Autowired
    public MyUserService(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    public List<MyUser> getUsers() {
        return myUserRepository.findAll();
    }

    public MyUser checkLogin(String username, String password) {
        Optional<MyUser> accountToLogIn = myUserRepository.findUserByUsername(username);
        if(accountToLogIn.isPresent()) {
            MyUser myUser = accountToLogIn.get();
            if(myUser.getPassword().equals(password)) {
                return myUser;
            } else {
                throw new IllegalStateException("Password is incorrect");
            }
        } else {
            throw new IllegalStateException("Such login does not exist");
        }
    }

    public MyUser findUserByUsername(String username) {
        Optional<MyUser> user = myUserRepository.findUserByUsername(username);
        if(!user.isPresent()) {
            throw new NoSuchElementException("No such user exists");
        }
        return user.get();
    }

    public MyUser getUserById(long id) {
        Optional<MyUser> user = myUserRepository.findUserById(id);
        if(user.isPresent()) return user.get();
        throw new RuntimeException("No such user exists");
    }

    public void addNewUser(MyUser myUser) {
       Optional<MyUser> userByEmail =  myUserRepository.findUserByEmail(myUser.getEmail());
        Optional<MyUser> userByUsername = myUserRepository.findUserByUsername(myUser.getUsername());
       if(userByEmail.isPresent()) {
           throw new IllegalStateException("Email is taken");
       } else if(userByUsername.isPresent()) {
           throw new IllegalStateException("Username is taken");
       }
       myUserRepository.insertUser(myUser.getCreatedAt(), myUser.getEmail(), myUser.getPassword(), myUser.getUsername());
    }
}
