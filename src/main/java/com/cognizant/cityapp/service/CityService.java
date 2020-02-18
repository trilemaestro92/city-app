package com.cognizant.cityapp.service;

import com.cognizant.cityapp.model.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityService {
    Map<Integer, List<City>> cityHashMap;

    public List<City> getCities(Integer id) {

        //Mock CityList and HashMap
        List<City> georgiaCityList = new ArrayList<>();
        georgiaCityList.add(new City("Atlanta"));
        georgiaCityList.add(new City("Norcross"));
        georgiaCityList.add(new City("Johns Creek"));

        List<City> illinoisCityList = new ArrayList<>();
        georgiaCityList.add(new City("Chicago"));
        georgiaCityList.add(new City("Naperville"));
        georgiaCityList.add(new City("Aurora"));

        cityHashMap = new HashMap<>();
        cityHashMap.put(1, georgiaCityList );
        cityHashMap.put(2, illinoisCityList);

//        if(cityHashMap.get(id) == null){
//            throw new NullPointerException("id: " + id + " not available");
//        }
        System.out.println(cityHashMap.get(1));

        return cityHashMap.get(id);
    }}
