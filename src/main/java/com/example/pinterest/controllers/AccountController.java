package com.example.pinterest.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import com.example.pinterest.Model.UserModel;
import com.example.pinterest.Service.UserService;

@Controller
@RequestMapping({ "/accunt" })
public class AccountController {

    @RequestMapping({ "/login" })
    public String login(final Model model) {
        return "login";
    }

    @RequestMapping({ "/login" })
    public String login(final Model model,UserModel u) {
       
        return "login";
    }

    

}
