package com.datorium.Datorium.API;

import com.datorium.Datorium.API.DTOs.Book;
import com.datorium.Datorium.API.DTOs.Credentials;
import com.datorium.Datorium.API.DTOs.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@CrossOrigin
public class DatoriumApiApplication { // Main class

	public static void main(String[] args) { // This is the only thing supposed to be here
		System.out.println("asd"); // just for testing
		SpringApplication.run(DatoriumApiApplication.class, args); // initializes Spring application

	}

}
/*
The waiter is API.
The chef is the Service (knows how to prep all the food)
The restaurant's food storage supervisor is like Repo (goes to check if all the ingredients are available)
DataBase is the food storage space at the restaurant

 */
