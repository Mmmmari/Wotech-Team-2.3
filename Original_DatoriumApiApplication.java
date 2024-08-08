package com.datorium.Datorium.API;

import com.datorium.Datorium.API.DTOs.Book;
import com.datorium.Datorium.API.DTOs.Credentials;
import com.datorium.Datorium.API.DTOs.User;
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

	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name); // "Hello " + name + "!";
	}

	@GetMapping("/getbook") // http://localhost:8080/getbook mapping for endpoint
	public Book getBook(){
		var book = new Book();
		book.title = "book title";
		book.author = "book author";

		return book;

	}

	@PostMapping("/postexample")
	public Book addBook(@RequestBody Book book){
		book.title = book.title.toUpperCase();
		return book;
	}

	// We want user to be able to authorize, by using username and password
	// And then we provide a profile of the user (name, surname, age, email)

	@PostMapping("/authorize")
	public User authorize(@RequestBody Credentials credentials) { // username + password
		if(credentials.username.equals("okklv") && credentials.password.equals("Password123")){
			var user = new User();
			user.name = "Oskars";
			return user;
		}
		return null;
	}

}
