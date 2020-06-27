package com.ankamma.csv.service;
import com.ankamma.csv.model.City;
import com.ankamma.csv.repository.CityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {

        return  (List<City>) repository.findAll();
    }

    @Override
    public City findById(Long id) {

        return repository.findById(id).orElse(new City());
    }
}
