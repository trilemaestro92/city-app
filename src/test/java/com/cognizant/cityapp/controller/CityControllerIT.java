package com.cognizant.cityapp.controller;

import com.cognizant.cityapp.model.City;
import com.cognizant.cityapp.model.StateId;
import com.cognizant.cityapp.service.CityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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


    private ObjectMapper mapper;

    List<City> cityList;


    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(cityController).build();
    }
    @BeforeEach
    public void before(){
        cityList = new ArrayList<>();
        cityList.add(new City(1, "Atlanta"));
        this.mapper = new ObjectMapper();
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
    public void getCitiesByParams_throws404_wrongUri() throws Exception{
        mockMvc.perform(get("/cities/params?stateId=1")).andExpect(status().isNotFound());
    }

    @Test
    public void getCitiesByParams_callsCityService_onSuccess() throws Exception{
        mockMvc.perform(get("/city/params?stateId=5"));
        verify(cityService, times(1)).getCities(5);
    }


    @Test
    public void getCitiesByPath_return200Status() throws Exception{
        mockMvc.perform(get("/city/1")).andExpect(status().isOk());
    }

    @Test
    public void getCitiesByPath_throws400_withStringPath() throws Exception{
        mockMvc.perform(get("/city/one")).andExpect(status().isBadRequest());
    }

    @Test
    public void getCitiesByPath_throws404_withWrongUri() throws Exception{
        mockMvc.perform(get("/cities/one")).andExpect(status().isNotFound());
    }

    @Test
    public void getCitiesByPath_callsCityService_onSuccess() throws Exception{
        mockMvc.perform(get("/city/5"));
        verify(cityService, times(1)).getCities(5);
    }

    @Test
    public void getCitiesByJson_return200Status() throws Exception{
        mockMvc.perform(post("/city/json")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new StateId(1))))
                .andExpect(status().isOk());
    }

    @Test
    public void getCitiesByJson_throws400_withIncorrectJson() throws Exception{
        mockMvc.perform(post("/city/json")
                .contentType(MediaType.APPLICATION_JSON)
                .content("Not: StateId"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getCitiesByJson_throws404_withWrongUri() throws Exception{
        mockMvc.perform(post("/cities/json")
                .contentType(MediaType.APPLICATION_JSON)
                .content("Not: StateId"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getCitiesByJson_callsCityService_onSuccess() throws Exception{
        mockMvc.perform(post("/city/json")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new StateId(7))));

        verify(cityService, times(1)).getCities(7);
    }

    @Test
    public void getCitiesByHeader_return200Status() throws Exception{
        mockMvc.perform(get("/city/header")
                .header("stateId", 2))
                .andExpect(status().isOk());
    }

    @Test
    public void getCitiesByHeader_throws400_withIncorrectHeaderKey() throws Exception{
        mockMvc.perform(get("/city/header")
                .header("state", 2))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getCitiesByHeader_throws400_withIncorrectHeaderValue() throws Exception{
        mockMvc.perform(get("/city/header")
                .header("stateId", "two"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getCitiesByHeader_throws404_withWrongUri() throws Exception{
        mockMvc.perform(get("/api/cities/header")
                .header("stateId", 2))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getCitiesByHeader_callsCityService_onSuccess() throws Exception{
        mockMvc.perform(get("/city/header")
                .header("stateId", 4));

        verify(cityService, times(1)).getCities(4);
    }


}