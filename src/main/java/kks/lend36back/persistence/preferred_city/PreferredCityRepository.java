package kks.lend36back.persistence.preferred_city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PreferredCityRepository extends JpaRepository<PreferredCity, Integer> {

  @Query("select p from PreferredCity p where p.user.id = :userId and p.city.id = cityId")
  PreferredCity ListOfPreferredCities(Integer userId, Integer cityId);



}