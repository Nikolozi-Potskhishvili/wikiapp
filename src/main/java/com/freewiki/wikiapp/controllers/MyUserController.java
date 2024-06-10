package com.freewiki.wikiapp.controllers;



import com.freewiki.wikiapp.model.MyUser;
import com.freewiki.wikiapp.services.MyUserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MyUserController {

    @Autowired
    private final MyUserService myUserService;

    public MyUserController(MyUserService myUserService) {

        this.myUserService = myUserService;
    }

   @GetMapping("/login")
    public String getUser(@RequestParam String username, @RequestParam String password,
                          final Model model, HttpServletRequest request) {
        try {
            MyUser myUserToLogIn = myUserService.checkLogin(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            model.addAttribute("username", myUserToLogIn.getUsername());
            model.addAttribute("id", myUserToLogIn.getId());
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
    public String registerNewUser(@ModelAttribute("user") MyUser myUser, final Model model) {
        myUserService.addNewUser(myUser);
        model.addAttribute("username", myUser.getUsername());
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
