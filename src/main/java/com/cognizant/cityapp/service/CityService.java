package com.cognizant.cityapp.service;

import com.cognizant.cityapp.model.City;
import com.cognizant.cityapp.util.CityData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    CityData cityData = new CityData();

    public List<City> getCities(Integer id) {
        System.out.println(cityData.getDatabase());
        if(id == null){
            throw new NullPointerException("id: " + id + " is null");
        }
        if(cityData.getDatabase().get(id) == null){
            throw new NullPointerException("id: " + id + " not available");
        }
        return cityData.getDatabase().get(id);
    }
}

