package com.example.pinterest.controllers;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.example.pinterest.Model.UserModel;
import com.example.pinterest.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({ "/Home", "/" })
public class HomeController {

    @Autowired
    private UserService Userservice;

    @GetMapping(value = "/imge", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImageWithMediaType(@RequestParam String id) throws IOException {
        InputStream in = getClass().getResourceAsStream("/resources/templates/img/" + id + ".jpg");
        // return IOUtils.toByteArray(in);

        byte[] targetArray = new byte[in.available()];
        in.read(targetArray);

        return targetArray;
    }

    @GetMapping(value = "/test")
    public @ResponseBody String TestAPI(@RequestBody String filename) throws IOException {
        String o = "";
        try {
            o += "Target : " + filename + "  - ";
            File file = new File(filename);
            o += "PATH OK - ";
            byte[] fileContent = Files.readAllBytes(file.toPath());
            o += "Arrey OK - ";
        } catch (Exception ex) {
            o += ex.getLocalizedMessage();
        }

        return o;
    }

    @RequestMapping({ "/", "/index" })
    public String index(final Model model) {
        return "index";
    }

    @RequestMapping({ "/ShowUsers" })
    public String ShowUsers(final Model model) {
        List<UserModel> x = Userservice.getAllUsers();
        model.addAttribute("users", x);
        return "test";
    }

}
