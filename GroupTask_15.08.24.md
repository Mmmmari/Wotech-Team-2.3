# Cheese.java
```java
package com.datorium.Datorium.API.DTO;

public class Cheese {
    public String name;
    public int price;
}
```

# UpdateCheeseDTO.java
```java
package com.datorium.Datorium.API.DTO;

public class UpdateCheeseDTO {
    public Cheese cheese;
    public int cheeseIndex;
}
```

# CheeseShopRepo.java
```java
package com.datorium.Datorium.API.Repo;

import com.datorium.Datorium.API.DTO.Cheese;
import com.datorium.Datorium.API.DTO.User;

import java.util.ArrayList;

public class CheeseShopRepo {
    private ArrayList<Cheese> cheeses = new ArrayList<Cheese>();

    public int add(Cheese cheese){
        cheeses.add(cheese);
        return cheeses.size();
    }
    public ArrayList<Cheese> getCheese(){
        return cheeses;
    }

    public Cheese update(int cheeseIndex, Cheese updateCheeseDTO){
        var cheese = cheeses.get(cheeseIndex);
        cheese.name = updateCheeseDTO.name;
        cheese.price = updateCheeseDTO.price;
        return cheese;
    }
}
```

# CheeseShopService.java
```java
package com.datorium.Datorium.API.Services;
import com.datorium.Datorium.API.DTO.Cheese;
import com.datorium.Datorium.API.Repo.CheeseShopRepo;
import java.util.ArrayList;

public class CheeseShopService {
    private CheeseShopRepo cheeseShopRepo;

    public CheeseShopService() { // we want to connect to the server; userService checks if the user is real; if the username us already in use
        cheeseShopRepo = new CheeseShopRepo();
    }
    public int add(Cheese cheese){
        return cheeseShopRepo.add(cheese);
    }
    public ArrayList<Cheese> getCheese(){
        return cheeseShopRepo.getCheese();
    }
    public Cheese update(int cheeseIndex, Cheese updateCheeseDTO){
        return cheeseShopRepo.update(cheeseIndex, updateCheeseDTO);
    }
}
```

# CheeseShopController.java
```java
package com.datorium.Datorium.API.Controllers;

import ch.qos.logback.core.BasicStatusManager;
import com.datorium.Datorium.API.DTO.UpdateCheeseDTO;
import com.datorium.Datorium.API.DTO.Cheese;
import com.datorium.Datorium.API.Services.CheeseShopService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/cheese")
public class CheeseShopController {

    private CheeseShopService cheeseShopService;
    public CheeseShopController(){
        // This code runs first, when creating UserController object
        cheeseShopService = new CheeseShopService();
    }

    @PostMapping("/add") //localhost:8080/test -> localhost:8080/user/test
    public int add(@RequestBody Cheese cheese) {
        return cheeseShopService.add(cheese);
    }

    @GetMapping("/get")
    public ArrayList<Cheese> get() {
        return cheeseShopService.getCheese();
    }

    @PostMapping ("/update")
    public Cheese update(@RequestBody UpdateCheeseDTO updateCheeseDTO) {
        return cheeseShopService.update(updateCheeseDTO.cheeseIndex, updateCheeseDTO.cheese);
    }
}
```
