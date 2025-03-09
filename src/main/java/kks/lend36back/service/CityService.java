package kks.lend36back.service;

import kks.lend36back.controller.city.dto.CityList;
import kks.lend36back.persistence.city.City;
import kks.lend36back.persistence.city.CityMapper;
import kks.lend36back.persistence.city.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public List<CityList> getCities(){

        List<City> cities = cityRepository.findAll();
        List<CityList> cityList = cityMapper.toCityList(cities);
        return cityList;


    }



}
