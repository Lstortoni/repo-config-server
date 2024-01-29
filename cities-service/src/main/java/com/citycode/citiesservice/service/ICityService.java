package com.citycode.citiesservice.service;

import com.citycode.citiesservice.dto.CityDTO;
import com.citycode.citiesservice.model.City;

public interface ICityService {

    public CityDTO getCityById(Long city_id);


    public City savaCity (City city);

}
