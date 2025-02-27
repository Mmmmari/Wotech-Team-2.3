1. Create MathService
2. Create a method sum()
3. Create a unit test for this method.
Hi, I want to be able to get a sum of 2 numbers, but if the sum is above 100, then I want to receive 0 instead.

DatoriumApiApplications.java
```java
package com.datorium.Datorium.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin
public class DatoriumApiApplication {

	public static void main(String[] args) {
		var userService = new com.example.demo.UserService();


		System.out.println(userService.getFullName("Oskars", "Klaumanis"));


		var mathService = new MathService();
		System.out.println(mathService.getSum(1, 2));

		SpringApplication.run(DatoriumApiApplication.class, args);
	}
}
```

MathService.java: 
```java
package com.datorium.Datorium.API;

public class MathService {

    public int getSum(int num1, int num2) {
        int result = num1 + num2;
        if (result > 100) {
            return 0;
        }
        return result;
    }
}
```

Result: 

![Kuvatõmmis 2024-09-18 203602](https://github.com/user-attachments/assets/40ee2553-a1ff-45b7-9d22-dab51378c6a2)


DatoriumApiApplicationTest.java
```java
package com.datorium.Datorium.API;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class DatoriumApiApplicationTests {

	@Test
	void WHEN_NameIsOskarsAndSurnameIsKlaumanis_THEN_Result_OskarsKlaumanis() {
		// unittest

		// //Arrange -> prepare data and services
		var userService = new com.example.demo.UserService();

		//Act -> do some action, usully call a method
		var fullname = userService.getFullName("Oskars", "Klaumanis");

		//Assert -> Test whether or not the result is correct
		Assert.isTrue(fullname.equals("Oskars Klaumanis"), "Hey, the name should be with a space inbetween first name and the last name");
	}


	@Test
		void WHEN_SumBelowHundred_THEN_Result_Sum() {
			var mathService = new MathService();
			var sum = mathService.getSum(1, 2);
			Assert.isTrue(sum == 3,  "Hey, the sum should be the result. Unless the sum exceeds hundred.");
		}

	@Test
	void WHEN_SumOverHundred_THEN_Result_Zero() {

		var mathService = new MathService();
		var sum = mathService.getSum(100,2);
		Assert.isTrue(sum == 0,  "Hey, the sum exceeds hundred.");
	}
	}
```

Result_Test_1: 

![Kuvatõmmis 2024-09-18 204159](https://github.com/user-attachments/assets/f5231c92-f009-4da5-885f-d545712260d0)


Result_Test_2: 

![Kuvatõmmis 2024-09-18 205438](https://github.com/user-attachments/assets/555f6561-c4a4-401e-8113-2489cc0a60db)




