package com.ankamma.csv.controller;

import com.ankamma.csv.model.City;
import com.ankamma.csv.service.ICityService;
import com.ankamma.csv.util.WriteCsvToResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class MyCityController {

    @Autowired
    ICityService cityService;

    @RequestMapping(value = "/cities", produces = "text/csv")
    public void findCities(HttpServletResponse response) throws IOException {
        List<City> cities = (List<City>) cityService.findAll();
        WriteCsvToResponse.writeCities(response, cities);
    }

    @RequestMapping(value = "/cities/{cityId}", produces = "text/csv")
    public void findCity(@PathVariable Long cityId, HttpServletResponse response) throws IOException {

        City city = cityService.findById(cityId);
        WriteCsvToResponse.writeCity(response, city);
    }
}
