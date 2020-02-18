package com.cognizant.cityapp.util;

import com.cognizant.cityapp.model.City;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CityData {
    private static Map<Integer, List<City>> database = new TreeMap<>();

    public Map<Integer, List<City>> getDatabase() {
        return database;
    }

    public void setDatabase(Map<Integer, List<City>> database) {
        CityData.database = database;
    }

    static {
        init();
    }

    private static void init(){
        List<City> georgiaCities = new ArrayList<>();
        List<City> illinoisCities = new ArrayList<>();

        georgiaCities.add(new City(1,"Atlanta"));
        georgiaCities.add(new City(2,"Athens"));
        georgiaCities.add(new City(3,"Savannah"));

        illinoisCities.add(new City(1,"Chicago"));
        illinoisCities.add(new City(2,"Naperville"));
        illinoisCities.add(new City(3,"Evanston"));
        database.put(1, georgiaCities);
        database.put(2, illinoisCities);
    }


}
