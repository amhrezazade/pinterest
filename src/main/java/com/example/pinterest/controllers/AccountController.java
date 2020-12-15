package com.example.pinterest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.example.pinterest.Model.editprofileModel;
import com.example.pinterest.Model.loginModel;
import com.example.pinterest.Model.signup;
import com.example.pinterest.Service.UserService;

@Controller
@RequestMapping({ "/acc" })
public class AccountController {

    @Autowired
    private UserService Userservice;

    @GetMapping("/editprofile")
    public String edit(@CookieValue(value = "token", defaultValue = "Atta") String token, Model model) {

        if (token == null || token.equals(""))
            return "redirect:/acc/login";

        System.out.println("token : " + token);

        editprofileModel x = Userservice.GetEditModel(token);

        if (x == null)
            return "redirect:/acc/login";

        System.out.println("x.name : " + x.getUsername());

        model.addAttribute("editprofileModel", new editprofileModel());

        System.out.println("model set");

        return "editprofile";
    }

    @PostMapping("/editProfileUser")
    public String edit(@ModelAttribute editprofileModel data,
            @CookieValue(value = "token", defaultValue = "Atta") String token, Model model,
            HttpServletResponse response) {

        if (!Userservice.Edit(token, data))
            return "redirect:/acc/login";

        System.out.println("Edit OK");
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String Login(Model model) {

        model.addAttribute("UserLoginModel", new loginModel());
        return "login";
    }

    @PostMapping("/loginUser")
    public String Login(@ModelAttribute loginModel data, Model model, HttpServletResponse response) {

        // Register to database :
        String token = Userservice.Login(data);

        if (token.equals("")) {
            System.out.println("Username or pass wrong");
            return "redirect:/acc/login";
        }

        // create a cookie
        Cookie cookie = new Cookie("token", token);
        // add cookie to response
        response.addCookie(cookie);

        System.out.println("Login OK");
        return "redirect:/index";
    }

    @GetMapping("/signup")
    public String SignUp(Model model) {

        model.addAttribute("UserSignUpModel", new signup());
        return "signup";
    }

    @PostMapping("/signupUser")
    public String SignUp(@ModelAttribute signup data, Model model, HttpServletResponse response) {

        // Register to database :
        String token = Userservice.Register(data);
        // create a cookie
        Cookie cookie = new Cookie("token", token);
        // add cookie to response
        response.addCookie(cookie);

        System.out.println("RegisterOK");
        return "redirect:/index";
    }

}
