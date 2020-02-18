package com.cognizant.cityapp.service;

import com.cognizant.cityapp.model.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CityServiceTest {

    @InjectMocks
    private CityService cityService;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void getCity_shouldReturnListOfCities_withAvailableId(){
        assertEquals(3 ,cityService.getCities(1).size());
    }

    @Test void getCity_shouldThrowNullPointerException_ifIdDoesNotExist(){
        assertThrows(NullPointerException.class, ()->{
            cityService.getCities(3);
        });
    }

    @Test void getCity_shouldThrowNullPointerException_ifIdIsNull(){
        assertThrows(NullPointerException.class, ()->{
            cityService.getCities(null);
        });
    }

}