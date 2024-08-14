package com.datorium.Datorium.API.Controllers;
import org.springframework.web.bind.annotation.PostMapping;

import com.datorium.Datorium.API.DTOs.User;
import com.datorium.Datorium.API.Services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    public UserController(){
        userService = new UserService();
        //This code runs first, when creating UserController object

    }
    //CRUD
    //AddUser
    //UpdateUser
    //GetUser
    //DeleteUser

    @PostMapping("/add") //localhost:8080/test -> localhost:8080/user/test
    public int add(@RequestBody User user){
        return userService.add(user);
    }

    @GetMapping("/get")
    public ArrayList<User> get() {
        return userService.getUsers();

    }


}
