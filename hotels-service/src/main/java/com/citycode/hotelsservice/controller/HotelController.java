package com.citycode.hotelsservice.controller;

import com.citycode.hotelsservice.model.Hotel;
import com.citycode.hotelsservice.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private IHotelService hotelServ;

    @GetMapping("/{city_id}")
    public List<Hotel> getHotelsByCityId(@PathVariable Long city_id){

        return hotelServ.getHotelsByCityId(city_id);
    }


    @PostMapping("/save")
    public Hotel getHotelsByCityId(@RequestBody Hotel hotel){

        return hotelServ.saveHotel(hotel);
    }

}
