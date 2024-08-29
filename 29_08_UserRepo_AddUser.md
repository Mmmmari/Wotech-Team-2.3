DATORIUM API APPLICATION 

1. UserRepo.java - with ADDING A TABLE : 

```java:
package com.datorium.Datorium.API.Repo;


import com.datorium.Datorium.API.DTO.User;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class UserRepo { // used for users, don't use "user" as part of the function's name.


   private ArrayList<User> users = new ArrayList<>(); // Mocked database


   public int add(User user){ // hold ctrl and add left click on mouse to see the original
       users.add(user);
       return users.size();
   }
   public ArrayList<User> getUsers(){
       return users;
   } // returning the users from the private property, privet ArrayList;


   public User update(int userIndex, User updateUserDTO){ // this user is never going to exist in database, but we use this DTO, to update the actual entities in database
       var user = users.get(userIndex); // getting user from ArrayList
       user.name = updateUserDTO.name;
       return user;
   }


   // User user = type, name of the variable
   public String addUser(User user) {
       String url = "jdbc:sqlite:my.db";  // Update this to your actual database name


       try (var conn = DriverManager.getConnection(url)) { // Create a connection
           if (conn != null) { // If connection exists, do things with connection, e.g. send query
               var statement = conn.createStatement();
               statement.execute("CREATE TABLE people (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(20))");
               statement.execute("INSERT INTO people (name) VALUES ('" + user.name + "')");
               return "User " + user.name + " added successfully";  // Return a success message
           }
       } catch (SQLException e) {
           System.err.println(e.getMessage());
           return "Failed to add user: " + e.getMessage();  // Return an error message
       }
       return null;  // This should generally not be reached if the connection was successful
   }
}
```

2. POST method to add users
![Kuvatõmmis 2024-08-29 214900](https://github.com/user-attachments/assets/65280805-2c84-420e-ba53-f26bf32fe8b8)


3. UserRepo.java when the table has already been created:

```java:
package com.datorium.Datorium.API.Repo;

import com.datorium.Datorium.API.DTO.User;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserRepo { // used for users, don't use "user" as part of the function's name.

    private ArrayList<User> users = new ArrayList<>(); // Mocked database

    public int add(User user){ // hold ctrl and add left click on mouse to see the original
        users.add(user);
        return users.size();
    }
    public ArrayList<User> getUsers(){
        return users;
    } // returning the users from the private property, privet ArrayList;

    public User update(int userIndex, User updateUserDTO){ // this user is never going to exist in database, but we use this DTO, to update the actual entities in database
        var user = users.get(userIndex); // getting user from ArrayList
        user.name = updateUserDTO.name;
        return user;
    }

    // User user = type, name of the variable
    public String addUser(User user) {
        String url = "jdbc:sqlite:my.db";  // Update this to your actual database name

        try (var conn = DriverManager.getConnection(url)) { // Create a connection
            if (conn != null) { // If connection exists, do things with connection, e.g. send query
                var statement = conn.createStatement();
                statement.execute("INSERT INTO people (name) VALUES ('" + user.name + "')");
                return "User " + user.name + " added successfully";  // Return a success message
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return "Failed to add user: " + e.getMessage();  // Return an error message
        }
        return null;  // This should generally not be reached if the connection was successful
    }
}
```

4. DB Browser for SQLite  (we also added Kristiina before asd)
   
![Kuvatõmmis 2024-08-29 215743](https://github.com/user-attachments/assets/f2f10477-e16b-4052-8b51-ae61f6dd4cb2)



