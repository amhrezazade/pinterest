package com.example.pinterest.controllers;


import com.example.pinterest.Model.UserModel;
import com.example.pinterest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping({"/Home","/"})
public class HomeController 
{

   @Autowired
   private UserService Userservice;

   @RequestMapping({"/","/error"})
   public String index(final Model model) 
   {
       return "index";
   }

   @RequestMapping({"/ShowUsers"})
   public String ShowUsers(final Model model)
    {
        List<UserModel> x = Userservice.getAllUsers();
        model.addAttribute("users",x);
        return "test";
    }

}
