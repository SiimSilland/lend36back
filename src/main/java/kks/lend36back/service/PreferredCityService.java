package kks.lend36back.service;

import kks.lend36back.controller.preferred_city.dto.PreferredCityDto;
import kks.lend36back.persistence.city.City;
import kks.lend36back.persistence.city.CityRepository;
import kks.lend36back.persistence.preferred_city.PreferredCity;
import kks.lend36back.persistence.preferred_city.PreferredCityMapper;
import kks.lend36back.persistence.preferred_city.PreferredCityRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PreferredCityService {

    private final CityRepository cityRepository;
    private final UserRepository userRepository;
    private final PreferredCityRepository preferredCityRepository;
    private final PreferredCityMapper preferredCityMapper;

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

    public List<PreferredCityDto> getAllPreferredCities(Integer userId){
        List<PreferredCity> preferredCityList = preferredCityRepository.getAllPreferredCities(userId);
        return preferredCityMapper.toPreferredCityDto(preferredCityList);

    }

}
