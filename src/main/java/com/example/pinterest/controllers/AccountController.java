package com.example.pinterest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.example.pinterest.Entity.User;
import com.example.pinterest.Model.UserModel;
import com.example.pinterest.Model.signup;
import com.example.pinterest.Service.UserService;

@Controller
@RequestMapping({ "/acc" })
public class AccountController {

    @Autowired
    private UserService Userservice;

    @RequestMapping({ "/login1" })
    public String login(final Model model) {
        return "login";
    }

    @RequestMapping({ "/login2" })
    public String login(final Model model, UserModel u) {

        return "login";
    }

    @GetMapping("/signup")
    public String SignUp(Model model) {

        model.addAttribute("UserSignUpModel", new signup());
        return "signup";
    }

    @PostMapping("/signupUser")
    public String SignUp(@ModelAttribute signup data, Model model, HttpServletResponse response) {



        //Register to database :
        Userservice.Register(user);

        // create a cookie
        Cookie cookie = new Cookie("token", "");
        // add cookie to response
        response.addCookie(cookie);

        System.out.println("RegisterOK");

        return "redirect:/index";
    }


}
