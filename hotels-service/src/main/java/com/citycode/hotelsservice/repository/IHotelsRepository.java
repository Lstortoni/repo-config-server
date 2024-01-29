package com.citycode.hotelsservice.repository;

import com.citycode.hotelsservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IHotelsRepository extends JpaRepository<Hotel,Long> {

    @Query("SELECT p FROM Hotel p WHERE p.city_id = :city_id")
    List<Hotel> findHotelsByCityId(Long city_id);

}
