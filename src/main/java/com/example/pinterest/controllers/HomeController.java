package com.example.pinterest.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.example.pinterest.Entity.User;
import com.example.pinterest.Model.editprofileModel;
import com.example.pinterest.Model.loginModel;
import com.example.pinterest.Model.signup;
import com.example.pinterest.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/Home", "/", "/acc" })
public class HomeController {

    private String LastError = "";
    @Autowired
    private UserService Userservice;

    @GetMapping("/folloerList")
    public String FollowerList(@CookieValue(value = "token", defaultValue = "Atta") String token, Model model) {

        if (token == null || token.equals(""))
            return "redirect:/acc/login";

        List<User> x = Userservice.getAllUsers();
        if (x == null)
            return "redirect:/acc/login";
        model.addAttribute("users", x);
        return "list";
    }

    @GetMapping("/editprofile")
    public String edit(@CookieValue(value = "token", defaultValue = "Atta") String token, Model model) {
        System.out.println("c ed");
        if (token == null || token.equals(""))
            return "redirect:/acc/login";
        editprofileModel x = Userservice.GetEditModel(token);
        if (x == null)
            return "redirect:/login";
        model.addAttribute("editprofileModel", x);
        return "editprofile";
    }

    @PostMapping("/editProfileUser")
    public String edit(@ModelAttribute editprofileModel data,
            @CookieValue(value = "token", defaultValue = "Atta") String token, Model model,
            HttpServletResponse response) {

        System.out.println("log1");        
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
        return "redirect:/acc/index";
    }

    @GetMapping("/signup")
    public String SignUp(Model model) {

        model.addAttribute("UserSignUpModel", new signup());
        model.addAttribute("message", LastError);
        return "signup";
    }

    @PostMapping("/signupUser")
    public String SignUp(@ModelAttribute signup data, Model model, HttpServletResponse response) {
        System.out.println(data.getPass());
        System.out.println(data.getPass2());

        if (data.getPass() == data.getPass2()) {
            LastError = "تکرار رمز عبور اشتباه است";
            return "redirect:/acc/signup";
        }

        // Register to database :
        String token = Userservice.Register(data);

        if (token == null || token == "") {
            LastError = "نام کاربری وجود دارد";
            System.out.println("controller register");
            return "redirect:/acc/signup";
        }

        // create a cookie
        Cookie cookie = new Cookie("token", token);
        // add cookie to response
        response.addCookie(cookie);

        System.out.println("RegisterOK");
        return "redirect:/acc/index";
    }

    @RequestMapping({ "/", "/index" })
    public String index(@CookieValue(value = "token", defaultValue = "defult token") String token, final Model model) {
        System.out.println(token);
        String accuntName = Userservice.getName(token);
        model.addAttribute("accuntName", accuntName);
        System.out.println(accuntName);
        return "index";
    }

}
