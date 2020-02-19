package com.cognizant.cityapp.controller;

import com.cognizant.cityapp.model.City;
import com.cognizant.cityapp.model.StateId;
import com.cognizant.cityapp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/city")
public class CityController {

    CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @GetMapping("/params")
    @ResponseStatus(value = HttpStatus.OK)
    public List<City> getCityListWithParams(
            @RequestParam(value = "stateId") Integer stateId
    ){
        System.out.println("params: ");
        System.out.println(stateId);

        return cityService.getCities(stateId);
    }

    @GetMapping("/{stateId}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<City> getCityListWithPath(@PathVariable(value = "stateId") Integer stateId){
        System.out.println("pathVariable: ");
        System.out.println(stateId);
        return cityService.getCities(stateId);
    }

    @PostMapping("/json")
    @ResponseStatus(value = HttpStatus.OK)
    public List<City> getCityListWithJson(
            @RequestBody StateId json
    ){

        System.out.println("json: ");
        System.out.println(json.getStateId());

        return cityService.getCities(json.getStateId());

    }

    @GetMapping("/header")
    @ResponseStatus(value = HttpStatus.OK)
    public List<City> getCitiesWithHeader(@RequestHeader("stateId") Integer stateId){

        System.out.println("header: ");
        System.out.println(stateId);

        return cityService.getCities(stateId);
    }
}
