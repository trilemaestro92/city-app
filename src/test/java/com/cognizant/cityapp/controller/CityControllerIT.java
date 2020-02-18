package com.cognizant.cityapp.controller;

import com.cognizant.cityapp.model.City;
import com.cognizant.cityapp.service.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CityController.class)
@ExtendWith(SpringExtension.class)
class CityControllerIT {

    @Autowired
    MockMvc mockMvc;

    @SpyBean
    CityController cityController;

    @MockBean
    CityService cityService;

    List<City> cityList;


    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(cityController).build();
    }
    @BeforeEach
    public void before(){
        cityList = new ArrayList<>();
        cityList.add(new City(1, "Atlanta"));
    }

    @Test
    public void getCitiesByParams_return200Status() throws Exception{
        mockMvc.perform(get("/city/params?stateId=1")).andExpect(status().isOk());
    }

    @Test
    public void getCitiesByParams_throws400_wrongParamsValue() throws Exception{
        mockMvc.perform(get("/city/params?notId=1")).andExpect(status().isBadRequest());
    }

    @Test
    public void getCitiesByParams_callsCityService_onSuccess() throws Exception{
        mockMvc.perform(get("/city/params?stateId=5"));
        verify(cityService, times(1)).getCities(5);
    }




}