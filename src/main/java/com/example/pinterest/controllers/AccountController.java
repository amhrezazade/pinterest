package com.example.pinterest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import com.example.pinterest.Model.UserModel;
import com.example.pinterest.Model.signup;
import com.example.pinterest.Service.UserService;

@Controller
@RequestMapping({ "/accunt" })
public class AccountController {

    @RequestMapping({ "/login1" })
    public String login(final Model model) {
        return "login";
    }

    @RequestMapping({ "/login2" })
    public String login(final Model model,UserModel u) {
       
        return "login";
    }

    @GetMapping("/signup")
    public String SignUp(Model model){

        model.addAttribute("UserSignUpModel", new signup());
        return "signup";
    }


    @PostMapping("/signupUser")
    public String SignUp(@ModelAttribute signup u, Model model){
        System.out.println(u.getEmail());
        System.out.println(u.getPass());
        System.out.println(u.getPass2());
        return "index";
    }

}
