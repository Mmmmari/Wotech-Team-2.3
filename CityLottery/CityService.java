package com.datorium.Datorium.API.CityLottery;

import java.util.ArrayList;
import java.util.Random;

public class CityService {

    // 1. Count total amount of citizens -> 100
    // 2. Choose random number -> 56
    // 3. Loop going through all the cities
    // 4. Choose the city with the correct lottery number

    private ICityRepository cityRepository;
    public CityService(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City getRandomCity(ICityRepository cityRepo, Random random) {
        ArrayList<City> cities = cityRepo.getCities();
        int totalCitizenCount = getTotalCitizens(cityRepo);
        int randomNumber = getRandomNumber(totalCitizenCount, random);
        City winner = getCity(cities, randomNumber);
        return winner;
    }

    private int getTotalCitizens(ICityRepository cityRepo) {
        ArrayList<City> cities = cityRepo.getCities();
        int totalCitizenCount = 0;
        for (City city : cities) {
            totalCitizenCount += city.getPopulation();
        }
        return totalCitizenCount;
    }

    private int getRandomNumber(int totalCitizenCount, Random random) {
        // 2. Choose random number from 0 (inclusive) to 100 (exclusive)
        int randomNumber = random.nextInt(totalCitizenCount);
        return randomNumber;
    }

    private City getCity(ArrayList<City> cities, int random) {
        // 3. Loop going through all the cities
        // 4. Choose the city with the correct lottery number
        // population --> 75
        // randomNumber --> 56
        // subtract 56 - 25 (wocity) = 31 --> positive number
        // BECAUSE IT IS NOT BELOW OR EQUAL TO 0, GO TO NEXT CITY POPULATION
        // 31 - 75 --> THIS IS BELOW 0, we choose this city
        City winnerCity = null;
        for (City city : cities) {
            random -= city.getPopulation();
            if (random <= 0) {
                winnerCity = city;
            }
        }
        return winnerCity;
    }
}
