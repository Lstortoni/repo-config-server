package com.citycode.hotelsservice.service;

import com.citycode.hotelsservice.model.Hotel;

import java.util.List;

public interface IHotelService {

    public List<Hotel> getHotelsByCityId (Long city_id);

    public Hotel saveHotel (Hotel hotel);

}
