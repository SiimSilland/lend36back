package kks.lend36back.service;

import kks.lend36back.controller.preferred_city.dto.CityDto;
import kks.lend36back.persistence.city.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PreferredCityService {

    private final CityRepository cityRepository;

    public void addPreferredCity(CityDto cityDto) {

    }

}
