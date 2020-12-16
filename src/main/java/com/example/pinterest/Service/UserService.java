package com.example.pinterest.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.pinterest.Entity.User;
import com.example.pinterest.Model.UserModel;
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

  public editprofileModel GetEditModel(String token) {
    List<User> users = UserRepository.findAll();
    for (User user : (List<User>) users) {
      if (user.getToken().equals(token)) {
        editprofileModel output = new editprofileModel();
        output.setAge(user.getCountry());
        output.setBio(user.getAddress());
        output.setEmail(user.getEmail());
        output.setPhoneNumber(user.getPhone());
        output.setUsername(user.getUserName());
        output.setPassword(user.getPassWord());
        return output;
      }
    }
    return null;
  }

  public boolean Edit(String token, editprofileModel data) {
    List<User> users = UserRepository.findAll();

    for (User user : (List<User>) users)
      if (user.getToken().equals(token)) {
        user.setEmail(data.getEmail());
        user.setAddress(data.getBio());
        user.setPhone(data.getPhoneNumber());
        user.setUserName(data.getUsername());
        user.setCountry(data.getAge());
        user.setPassWord(data.getPassword());
        UserRepository.save(user);
        return true;
      }

    return false;
  }

  public String Register(signup u) {

    List<User> users = UserRepository.findAll();
    for (User user : (List<User>) users)
      if (user.getEmail().equals(u.getEmail()))
        return "";

    // Creating new user :
    User user = new User();
    user.setAddress("");
    user.setCountry("");
    user.setEmail(u.getEmail());
    user.setGender(false);
    user.setImage("image");
    user.setPassWord(u.getPass());
    user.setPhone("");
    user.setUserName("");

    user.setId(NextID());
    user.setToken(GenerateToken());
    UserRepository.save(user);

    return user.getToken();
  }

  private String NextID() {
    Random r = new Random();
    String output = "";
    for (int i = 0; i < 10; i++) {
      output += r.nextInt(9);
    }
    return output;
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

  public List<UserModel> getAllUsers() {
    List<User> users = UserRepository.findAll();
    ArrayList<UserModel> Result = new ArrayList<>();
    for (User user : (List<User>) users) {
      Result.add(new UserModel(user));
    }
    return Result;
  }

}