package com.cognizant.cityapp.controller;

import com.cognizant.cityapp.service.CityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
public class CityController {

    CityService cityService;

    @GetMapping("/{state}")
    public void getCityList(
            @RequestParam(required = false ,value = "id") String id,
            @PathVariable(value = "state") String state,
            @RequestBody(required= false) String json
    ){
        System.out.println("params: ");
        System.out.println(id);
        System.out.println("pathVariable: ");
        System.out.println(state);
        System.out.println("json: ");
        System.out.println(json);

    }


//    @RestController
//@RequestMapping("/city")
//public class CityController {
//
//    CityService cityService;
//
//    @GetMapping
//    public List<City> getCityListWithParams(
//            @RequestParam(required = false ,value = "id") Integer id
//    ){
//        System.out.println("params: ");
//        System.out.println(id);
//
//        return cityService.getCities(id);
//    }
//
//    @GetMapping("/{stateId}")
//    public List<City> getCityListWithPath(@PathVariable(required = false ,value = "stateId") Integer stateId){
//        System.out.println("pathVariable: ");
//        System.out.println(stateId);
//        return cityService.getCities(stateId);
//    }
//
//    @GetMapping("/json")
//    public List<City> getCityListWithJson(
//            @RequestBody(required= false) StateId json
//    ){
//
//        System.out.println("json: ");
//        System.out.println(json.getStateId());
//
//        return cityService.getCities(json.getStateId());
//
//    }
}
