package com.cognizant.cityapp.controller;

import com.cognizant.cityapp.model.City;
import com.cognizant.cityapp.service.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CityControllerTest {

    @InjectMocks
    CityController cityController;

    @Mock
    CityService cityService;

    List<City> cityList;

    @BeforeEach
    void setUp() {
        cityList = new ArrayList<>();
        cityList.add(new City(1,"Atlanta"));
        cityList.add(new City(2,"Norcross"));
        cityList.add(new City(3,"Johns Creek"));
    }

    @Test
    public void getCityWithParams_returnListOfCities_withAvailableId(){
        when(cityService.getCities(3)).thenReturn(cityList);
        assertEquals(cityList, cityController.getCityListWithParams(3));
    }

    @Test
    public void getCityWithParams_callsCityService_withAvailableId(){
        when(cityService.getCities(3)).thenReturn(cityList);
        assertEquals(cityList, cityController.getCityListWithParams(3));
        verify(cityService, times(1)).getCities(3);
    }


}