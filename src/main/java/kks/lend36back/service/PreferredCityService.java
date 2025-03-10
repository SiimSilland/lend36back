package kks.lend36back.service;

import kks.lend36back.persistence.city.City;
import kks.lend36back.persistence.city.CityRepository;
import kks.lend36back.persistence.preferred_city.PreferredCity;
import kks.lend36back.persistence.preferred_city.PreferredCityRepository;
import kks.lend36back.persistence.user.User;
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

        User userById = userRepository.findUserById(userId);
        City cityById = cityRepository.findCityById(cityId);

        PreferredCity preferredCity = new PreferredCity();
        preferredCity.setUser(userById);
        preferredCity.setCity(cityById);
        preferredCityRepository.save(preferredCity);
    }

    public void deletePreferredCity(Integer userId, Integer cityId) {
        User userById = userRepository.findUserById(userId);
        City cityById = cityRepository.findCityById(cityId);
        preferredCityRepository.deletePreferredCity1(userById, cityById);

    }

    //todo: kontroll kas linn ja user on olemas
    // todo: vaata üle integer vs entity

}
