package com.example.pinterest.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.pinterest.Entity.User;
import com.example.pinterest.Model.editprofileModel;
import com.example.pinterest.Model.loginModel;
import com.example.pinterest.Model.signup;
import com.example.pinterest.Repository.IRepositoryUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
  @Autowired
  private IRepositoryUser UserRepository;

  public String Login(loginModel data) {
    List<User> users = UserRepository.findAll();
    for (User user : (List<User>) users) {
      if (user.getEmail().equals(data.getUserName()) && user.getPassWord().equals(data.getPass())) {
        user.setToken(GenerateToken());
        UserRepository.save(user);
        return user.getToken();
      }
    }
    return "";
  }

  public void setProfileImage(String token,String Image)
  {
    List<User> users = UserRepository.findAll();
    for (User user : (List<User>) users) {
      if (user.getToken().equals(token)) {
        user.setImage(Image);
        UserRepository.save(user);
      }
    }
  }

  public String GetImageURL(String token) {
    List<User> users = UserRepository.findAll();
    for (User user : (List<User>) users) {
      if (user.getToken().equals(token)) {
        return "/Image?id=" + user.getImage();
      }
    }
    return "/Image?id=user";
  }

  public editprofileModel GetEditModel(String token) {
    List<User> users = UserRepository.findAll();
    for (User user : (List<User>) users) {
      if (user.getToken().equals(token)) {
        editprofileModel output = new editprofileModel();
        output.setName(user.getName());
        output.setCountry(user.getCountry());
        output.setAge(String.valueOf(user.getAge()));
        output.setCity(user.getCity());
        output.setBio(user.getBio());
        output.setEmail(user.getEmail());
        output.setPhoneNumber(user.getPhone());
        output.setUsername(user.getUserName());
        return output;
      }
    }
    return null;
  }

  public boolean Edit(String token, editprofileModel data) {
    List<User> users = UserRepository.findAll();
    System.out.println("log2");
    for (User user : (List<User>) users)
      if (user.getToken().equals(token)) {
        System.out.println("log5");
        user.setName(data.getName());
        user.setCountry(data.getCountry());
        user.setAge(Integer.parseInt(data.getAge()));
        user.setCity(data.getCity());
        user.setBio(data.getBio());
        user.setEmail(data.getEmail());
        user.setPhone(data.getPhoneNumber());
        user.setName(data.getName());      
        UserRepository.save(user);
        return true;
      }

    return false;
  }

  public String Register(signup u) {

    List<User> users = UserRepository.findAll();
    for (User user : (List<User>) users) {
      if (user.getEmail().equals(u.getEmail())) {
        System.out.println("in if register");
        return "";
      }
      System.out.println("user imail : " + user.getEmail());
      System.out.println("user imail2 : " + u.getEmail());
    }

    // Creating new user :
    User user = new User();
    user.setAge(20);
    user.setBio("bio");
    user.setCity("");
    user.setToken("token");
    user.setCountry("");
    user.setEmail(u.getEmail());
    user.setGender(false);
    user.setImage("user");
    user.setPassWord(u.getPass());
    user.setPhone("");
    user.setUserName("");
    user.setName("name");
    user.setId(NextID());
    user.setToken(GenerateToken());
    UserRepository.save(user);

    return user.getToken();
  }

  public Long NextID() {
    Random r = new Random();
    String output = "";
    for (int i = 0; i < 10; i++) {
      output += r.nextInt(9);
    }
    return Long.parseLong(output);
  }

  public static String GenerateToken() {
    Random r = new Random();
    String chars = "";

    for (char c = 'a'; c <= 'z'; c++)
      chars += c;

    for (char c = 'A'; c <= 'Z'; c++)
      chars += c;

    for (char c = '0'; c <= '9'; c++)
      chars += c;

    char[] arry = chars.toCharArray();
    String output = "";
    for (int i = 0; i < 32; i++)
      output += arry[r.nextInt(chars.length())];

    return output;
  }

  public List<User> getAllUsers() {
    List<User> users = UserRepository.findAll();
    ArrayList<User> Result = new ArrayList<>();
    for (User user : (List<User>) users) {
      Result.add(user);
    }
    return Result;
  }

  public String getName(String token) {
    List<User> users = UserRepository.findAll();

    for (User user : (List<User>) users) {
      if (user.getToken().equals(token)) {
        System.out.println("user found");
        return user.getName();

      }
    }
    return "";
  }

}