//MAIN

package com.datorium.Datorium.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin
public class DatoriumApiApplication {

	public static void main(String[] args) {
		System.out.println("asd");
		SpringApplication.run(DatoriumApiApplication.class, args);
	}


	@GetMapping("/marco") //Function without// parameters
	public String ping() {
		return "polo";
	}

	@GetMapping("/hello") //Function with parameters
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
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

		if (temperature >= 20) {
			summer.setActivity("Sunbathing");
			summer.setBeachWeather(true);
		} else {
			summer.setActivity("Read a book");
			summer.setBeachWeather(false);
		}
		return String.format("The temperature is %.2f! \nAn activity we recommend: %s! \nIs it beach weather? %b!", temperature, summer.activity, summer.isHotEnoughForBeach);
	}

}



//SUMMER

package com.datorium.Datorium.API;

public class Summer{
    public float temperature;
    public String activity;
    public boolean isHotEnoughForBeach;

    public Summer(float temperature) {
        this.temperature = temperature;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setBeachWeather(boolean isBeachWeather) {
        this.isHotEnoughForBeach = isBeachWeather;
    }
}

