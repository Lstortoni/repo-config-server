package com.citycode.citiesservice.controller;


import com.citycode.citiesservice.dto.CityDTO;
import com.citycode.citiesservice.model.City;
import com.citycode.citiesservice.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private ICityService cityServ;

    @GetMapping("/{city_id}")
     public CityDTO getCityById(@PathVariable Long city_id){

        return cityServ.getCityById(city_id);
    }



    @PostMapping("/save")
    public City getHotelsByCityId(@RequestBody City city){

        return cityServ.savaCity(city);
    }

}
