package com.ankamma.csv.service;

import com.ankamma.csv.model.City;

import java.util.List;

public interface ICityService {

    List<City> findAll();
    City findById(Long id);
}
