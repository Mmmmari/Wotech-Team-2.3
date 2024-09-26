package com.datorium.Datorium.API.CityLottery;

import java.util.ArrayList;

public class CityRepository implements ICityRepository {

    // mock DB
    public ArrayList<City> getCities() {
        // prepare list of cities --> Repo
        // mock list of cities before DB is used
        ArrayList<City> cities = new ArrayList<City>();
        City goog = new City("Goog", 75);
        City wocity = new City("WoCity", 25);
        //City banteer = new City("Banteer", 230);
       // City pori = new City("Pori", 145);
        cities.add(goog);
        cities.add(wocity);
       // cities.add(banteer);
       // cities.add(pori);

        return cities;
  
