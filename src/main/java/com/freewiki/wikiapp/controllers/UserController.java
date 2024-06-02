package com.freewiki.wikiapp.controllers;



import com.freewiki.wikiapp.model.User;
import com.freewiki.wikiapp.services.UserService;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getUser(@RequestParam String username, @RequestParam String password,
                          final Model model) {
        try {
            User userToLogIn = userService.checkLogin(username, password);
            model.addAttribute("username", userToLogIn.getUsername());
            return "welcome";
        } catch (IllegalStateException e) {
            if(e.getMessage().equals("Password is incorrect")) {
                model.addAttribute("error", e.getMessage());
            } else if(e.getMessage().equals("Such login does not exist")) {
                model.addAttribute("error", e.getMessage());
            } else {
                model.addAttribute("error", e.getMessage());
            }
            return "loginFail";
        }
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute("user") User user, final Model model) {
        userService.addNewUser(user);
        model.addAttribute("username", user.getUsername());
        return "welcome";
    }

    /*@GetMapping("/welcome")
    public String welcomePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        model.addAttribute("username", currentUserName);
        return "welcome";
    } */
}
