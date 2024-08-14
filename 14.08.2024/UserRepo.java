package com.datorium.Datorium.API.Repo;

import com.datorium.Datorium.API.DTOs.User;

import java.util.ArrayList;

public class UserRepo {

    private ArrayList<User> users = new ArrayList<>();

    public int add(User user){
        users.add(user);
        return users.size();
    }

    public ArrayList getUsers(){
        return users;
    }
}
