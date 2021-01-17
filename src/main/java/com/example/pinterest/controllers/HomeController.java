package com.example.pinterest.controllers;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.example.pinterest.Entity.User;
import com.example.pinterest.Model.editprofileModel;
import com.example.pinterest.Model.loginModel;
import com.example.pinterest.Model.signup;
import com.example.pinterest.Service.UserService;
import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({ "/Home", "/", "/acc" })
public class HomeController {

    private String token = "";

    @Autowired
    private UserService Userservice;

    @GetMapping(value = "/Image", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImageWithMediaType(@RequestParam String id) throws IOException {
        if (id == null || id.equals(""))
            id = "user";
        return Files.readAllBytes(Paths.get("target\\Files\\" + id));
    }

    @PostMapping("/uploadfile")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            System.out.println("isEmpty");
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/editprofile";
        }
        
        try {
            String id = String.valueOf(Userservice.NextID());
            String filename = "target\\Files\\" + id;
            byte[] bytes = file.getBytes();
            Path path = Paths.get(filename);
            Files.write(path, bytes);
            Userservice.setProfileImage(token, id);
            System.out.println("x");
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/editprofile";
    }

    @GetMapping("/folloerList")
    public String FollowerList(Model model) {
        model.addAttribute("imageurl", Userservice.GetImageURL(token));
        if (token == null || token.equals(""))
            return "redirect:/acc/login";

        List<User> followers = Userservice.getAllUsers();
        List<User> following = Userservice.getAllUsers();

        model.addAttribute("er", followers);
        model.addAttribute("ing", following);
        return "list";
    }

    @GetMapping("/editprofile")
    public String edit(Model model) {
        model.addAttribute("imageurl", Userservice.GetImageURL(token));
        System.out.println("EditProfile Page");
        if (token == null || token.equals("")) {
            return "redirect:/acc/login";
        }

        editprofileModel x = Userservice.GetEditModel(token);
        if (x == null)
            return "redirect:/login";
        model.addAttribute("editprofileModel", x);
        return "editprofile";
    }

    @PostMapping("/editProfileUser")
    public String edit(@ModelAttribute editprofileModel data, Model model, HttpServletResponse response) {

        System.out.println("log1");
        if (!Userservice.Edit(token, data))
            return "redirect:/acc/login";

        System.out.println("Edit OK");
        return "redirect:/index";
    }

    @GetMapping("/UploadImage")
    public String ProfileImage(@CookieValue(value = "token", defaultValue = "") String token, Model model) {
        model.addAttribute("imageurl", Userservice.GetImageURL(token));
        if (token == null || token.equals(""))
            return "redirect:/acc/login";
        return "upload";
    }

    @GetMapping("/logout")
    public String LogOut(Model model) {
        token = "";
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String Login(Model model) {
        model.addAttribute("imageurl", Userservice.GetImageURL(token));
        model.addAttribute("UserLoginModel", new loginModel());
        return "login";
    }

    @PostMapping("/loginUser")
    public String Login(@ModelAttribute loginModel data, Model model, HttpServletResponse response) {

        // Register to database :
        token = Userservice.Login(data);

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
        model.addAttribute("imageurl", Userservice.GetImageURL(token));
        model.addAttribute("UserSignUpModel", new signup());
        return "signup";
    }

    @PostMapping("/signupUser")
    public String SignUp(@ModelAttribute signup data, Model model, HttpServletResponse response,
            RedirectAttributes redirectAttributes) {
        System.out.println(data.getPass());
        System.out.println(data.getPass2());

        if (data.getPass() == data.getPass2()) {
            redirectAttributes.addFlashAttribute("message", "تکرار رمز عبور اشتباه است");
            return "redirect:/acc/signup";
        }

        // Register to database :
        token = Userservice.Register(data);

        if (token == null || token == "") {
            redirectAttributes.addFlashAttribute("message", "نام کاربری وجود دارد");
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
    public String index(final Model model) {
        System.out.println(token);
        model.addAttribute("imageurl", Userservice.GetImageURL(token));
        String accuntName = Userservice.getName(token);
        model.addAttribute("accuntName", accuntName);
        System.out.println(accuntName);
        return "index";
    }

}
