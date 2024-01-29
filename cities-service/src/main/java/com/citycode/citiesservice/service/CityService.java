package com.citycode.citiesservice.service;

import com.citycode.citiesservice.dto.CityDTO;
import com.citycode.citiesservice.dto.HotelDTO;
import com.citycode.citiesservice.model.City;
import com.citycode.citiesservice.repository.ICityRepository;
import com.citycode.citiesservice.repository.IHotelsAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService{
    @Autowired
    private ICityRepository cityRepo;

    @Autowired
    private IHotelsAPI hotelsApi;
    @Override
    @CircuitBreaker(name ="hotels-service",fallbackMethod="fallbackGetCitiesHotel")
    @Retry(name="hotels-service")
    public CityDTO getCityById(Long city_id) {

        // Leo los hoteles que estan en esa City

        City city = cityRepo.findById(city_id).orElse(null);

        List<HotelDTO> hotelsList = hotelsApi.getHotelsByCityId(city_id);


        CityDTO cityDTO = new CityDTO(city.getCity_id(),city.getName(),city.getContinent(),city.getCountry(),city.getState(),hotelsList);

        createException();
       return cityDTO;

    }

    public void createException(){

        throw new IllegalArgumentException("Prueba Resilience ycirtuin breaket");
    }

    public CityDTO fallbackGetCitiesHotel(Throwable throwable) {

         return new CityDTO(99999999L,"Fallido","Fallido","Fallido","Fallido",null);
    }

    @Override
    public City savaCity(City city) {

        return cityRepo.save(city);

    }
}
