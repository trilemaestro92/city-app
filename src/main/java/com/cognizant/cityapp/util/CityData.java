package com.cognizant.cityapp.util;

import com.cognizant.cityapp.model.City;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CityData {
    private static Map<Integer, List<City>> database = new TreeMap<>();

    public static Map<Integer, List<City>> getDatabase() {
        return database;
    }

    public static void setDatabase(Map<Integer, List<City>> database) {
        CityData.database = database;
    }

    static {
        init();
    }

    private static void init(){

        Map<Integer, List<City>> initDatabase = new TreeMap<>();
        List<City> georgiaCities = new ArrayList<>();
        List<City> illinoisCities = new ArrayList<>();
        List<City> californiaCities = new ArrayList<>();

        georgiaCities.add(new City(1,"Atlanta"));
        georgiaCities.add(new City(2,"Athens"));
        georgiaCities.add(new City(3,"Savannah"));

        illinoisCities.add(new City(1,"Chicago"));
        illinoisCities.add(new City(2,"Naperville"));
        illinoisCities.add(new City(3,"Evanston"));

        californiaCities.add(new City(1,"Los Angeles"));
        californiaCities.add(new City(2, "San Francisco"));
        californiaCities.add(new City(3, "Sacramento"));

        initDatabase.put(1, georgiaCities);
        initDatabase.put(2, illinoisCities);
        initDatabase.put(3, californiaCities);

        setDatabase(initDatabase);
    }


}
