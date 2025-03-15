package kks.lend36back.persistence.preferred_city;

import kks.lend36back.persistence.city.City;
import kks.lend36back.persistence.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PreferredCityRepository extends JpaRepository<PreferredCity, Integer> {
  @Query("select p from PreferredCity p where p.user.id = :userId")
  List<PreferredCity> getAllPreferredCities(Integer userId);

  @Query("select p from PreferredCity p where p.user.id = :userId and p.city.id = :cityId")
  PreferredCity findPreferredCity(Integer userId, Integer cityId);


  @Transactional
  @Modifying
  @Query("delete from PreferredCity p where p.user = :userId and p.city = :cityId")
  void deletePreferredCity1(User userId, City cityId);

  @Query("select (count(p) > 0) from PreferredCity p where p.user.id = :userId and p.city.id = :cityId")
  boolean preferredCityExists(Integer userId, Integer cityId);


}