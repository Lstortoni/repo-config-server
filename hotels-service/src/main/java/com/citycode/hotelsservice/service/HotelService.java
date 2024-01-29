package com.citycode.hotelsservice.service;

import com.citycode.hotelsservice.model.Hotel;
import com.citycode.hotelsservice.repository.IHotelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService implements IHotelService {

    @Autowired
    private IHotelsRepository hotelRepo;
    @Override
    public List<Hotel> getHotelsByCityId(Long city_id) {
        return hotelRepo.findHotelsByCityId(city_id);
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {

        Hotel hotel1 = hotelRepo.save(hotel);

        return hotel1;
    }
}
