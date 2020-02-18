package com.cognizant.cityapp.service;

import com.cognizant.cityapp.model.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CityServiceTest {

    @InjectMocks
    private CityService cityService;

    List<City> cityList;

    @BeforeEach
    void setUp() {
        cityList = new ArrayList<>();
        cityList.add(new City("Atlanta"));
        cityList.add(new City("Norcross"));
        cityList.add(new City("Johns Creek"));
    }

    @Test
    public void getCity_shouldReturn_listOfCities(){
        assertEquals(cityList.get(0).getName() ,cityService.getCities(1).get(0).getName());
    }

    @Test void getCity_shouldThrowNullPointerException_ifIdDoesNotExist(){
        assertThrows(NullPointerException.class, ()->{
            cityService.getCities(5);
        });
    }

}