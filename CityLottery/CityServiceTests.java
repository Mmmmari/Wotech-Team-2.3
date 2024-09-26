package com.datorium.Datorium.API;

import com.datorium.Datorium.API.CityLottery.City;
import com.datorium.Datorium.API.CityLottery.CityRepository;
import com.datorium.Datorium.API.CityLottery.CityService;
import com.datorium.Datorium.API.CityLottery.ICityRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityServiceTests {

    // when there is goog and wocity
    // goog has 10%
    // wocity has 90%
    // randomizer chooses 9
    // choose goog

    @Test
    public void GIVEN_Goog10_Wocity90_WHEN_Random9_THEN_Choose_Goog(){
        // Arrange
        // create a mock repository
        ICityRepository cityRepository = Mockito.mock(ICityRepository.class);

        // Define two cities, Goog and Wocity, with their respective probabilities
        City goog = new City("Goog", 10);
        City wocity = new City("Wocity", 90);

        // Mock the behavior of the repository to return these cities
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(wocity);
        cities.add(goog);
        Mockito.when(cityRepository.getCities()).thenReturn(cities);

        // Create the CityService with the mocked repository
        CityService cityService = new CityService(cityRepository);

        // Mock the randomizer to return a value of 9
        Random random = Mockito.mock(Random.class);
        Mockito.when(random.nextInt(100)).thenReturn(9);

        // Act
        City winnerCity = cityService.getRandomCity(cityRepository, random);

        // Assert
        //Assert.isTrue(winnerCity.equals("Goog"));
        //Assert.isTrue(goog.getName().equals(winnerCity.getName()) && goog.getPopulation() == winnerCity.getPopulation());
        Assert.isInstanceOf(winnerCity.getClass(), "Goog");

    }
}
