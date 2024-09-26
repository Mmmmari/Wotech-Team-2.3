package com.datorium.Datorium.API;

import com.datorium.Datorium.API.CityLottery.City;
import com.datorium.Datorium.API.CityLottery.CityRepository;
import com.datorium.Datorium.API.CityLottery.CityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@RestController
@CrossOrigin
public class DatoriumApiApplication {

	public static void main(String[] args) {

		Random random = new Random();
		CityService cityService = new CityService(new CityRepository());
		CityRepository cityRepository = new CityRepository();
		City winner = cityService.getRandomCity(cityRepository, random);
		System.out.println(winner.getName());

		/*UserService userService = new UserService();
		MathService mathService = new MathService();

		System.out.println(userService.getFullName("Laila", "Duffy"));
		System.out.println(mathService.sum(5, 78));*/

		SpringApplication.run(DatoriumApiApplication.class, args);
	}

}
