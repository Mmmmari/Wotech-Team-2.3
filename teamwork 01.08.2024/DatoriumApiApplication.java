package com.datorium.Datorium.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@CrossOrigin
public class DatoriumApiApplication {

	public static void main(String[] args) {
		System.out.println("asd");
		SpringApplication.run(DatoriumApiApplication.class, args);
	}

	@GetMapping("/ping")
	public String ping() {

		return "pong";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name); // "Hello " + name + "!";
	}

	@GetMapping("/getbook")//localhost:8080/getbook
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

	@PostMapping("/authorize")
	public User authorize(@RequestBody Credentials credentials){ // username + password
		//
		if (credentials.username.equals("mmmari") && credentials.password.equals("pw123")) {
			var user = new User();
			user.name = "Mari";
			return user;
		}
		return null;
	}

	//We want the user to be able to authorize by using username and password
	// And then we provide a profile of the user (name, surname, age, email)


	@PostMapping("/purchase")
	public Cost purchase(@RequestBody Order order) { // food + drink
		//
		if (order.food.equals("hamburger") && order.drink.equals("cocacola")) {
			var cost = new Cost();
			cost.cost = "10 €";
			return cost;
		}
		return null;
	}
}
