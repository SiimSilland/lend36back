package kks.lend36back.service;

import kks.lend36back.controller.preferred_city.dto.CityDto;
import kks.lend36back.persistence.city.CityRepository;
import kks.lend36back.persistence.preferred_city.PreferredCity;
import kks.lend36back.persistence.preferred_city.PreferredCityRepository;
import kks.lend36back.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PreferredCityService {

    private final CityRepository cityRepository;
    private final UserRepository userRepository;
    private final PreferredCityRepository preferredCityRepository;

    public void addPreferredCity(Integer userId, Integer cityId) {
        PreferredCity preferredCity = new PreferredCity();
        preferredCity.setUser(userId);
        preferredCity.setCity(cityId);
        preferredCityRepository.save(preferredCity);
    }

    //todo: kontroll kas linn ja user on olemas
    // todo: vaata üle integer vs entity

}
