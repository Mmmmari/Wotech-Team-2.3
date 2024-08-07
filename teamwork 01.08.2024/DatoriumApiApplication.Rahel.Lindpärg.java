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
		return String.format("Hello %s!", name); // "Hello " + name;
	}

	@GetMapping("/sum")
	public int sum(@RequestParam(value = "number1") int number1, @RequestParam(value = "number2") int number2){
		return number1 + number2;
	}

	@GetMapping("/multiply")
	public int multiply(@RequestParam(value = "number1") int number1, @RequestParam(value = "number2") int number2){
		return number1 * number2;
	}
	@GetMapping("/birthdays") //Function without parameters
	public String[] birthdays() {
		String[] birthdays = new String[4];
		birthdays[0] = "20.02";
		birthdays[1] = "13.08";
		birthdays[2] = "04.06";
		birthdays[3] = "20.04";
		return birthdays;
	}
	@GetMapping("/summer") //Function with parameters
	public String summer(@RequestParam(value = "temperature") float temperature) {
		Summer summer = new Summer(temperature);
		summer.setActivity("Sunbathing");
		summer.setBeachWeather(true);
		return String.format("The temperature is %.2f! \nWe recommend %s! \nIs it beach weather? %b!", temperature, summer.activity, summer.isHotEnoughForBeach);

	}
	@GetMapping("/draw")
	public int[][] draw(){
		return new int[][]{
				new int[]{0, 0, 0},
				new int[]{1, 0, 0},
				new int[]{1, 0, 0}};
	}
	@GetMapping("/getBook")//localhost:8080/getBook
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
		if(credentials.username.equals("RL") && credentials.password.equals("Pass")){
			var user = new User();
			user.name = "Rahel";
			return user;
		}
		return null;
	}

	@PostMapping("/purchase")
	public Cost purchase(@RequestBody Order order){ // food + drink
		if(order.food.equals("hamburger") && order.drink.equals("cocacola")){
			var cost = new Cost();
			cost.cost = "10 euros";
			return cost;
		}
		return null;
	}


}