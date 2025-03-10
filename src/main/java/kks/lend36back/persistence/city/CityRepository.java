package kks.lend36back.persistence.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends JpaRepository<City, Integer> {
    @Query("select c from City c where c.id = :cityId")
    City findCityById(Integer cityId);


}