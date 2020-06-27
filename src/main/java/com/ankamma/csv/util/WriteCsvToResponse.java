package com.ankamma.csv.util;

import com.ankamma.csv.model.City;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriteCsvToResponse {

    private static final Logger LOGGER = LoggerFactory.getLogger(WriteCsvToResponse.class);

    public static void writeCities(HttpServletResponse response, List<City> cities) throws IOException {

        try {
            String filename = "city.csv";
            response.setContentType("text/csv");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + filename + "\"");
            ColumnPositionMappingStrategy<City> mapStrategy
                    = new ColumnPositionMappingStrategy<>();
            mapStrategy.setType(City.class);
            String[] columns = new String[]{"id", "name", "population"};
            mapStrategy.setColumnMapping(columns);

            StatefulBeanToCsv<City> btcsv = new StatefulBeanToCsvBuilder<City>(response.getWriter())
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(',')
                    .build();

            btcsv.write(cities);

        } catch (CsvException ex) {

            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }

    public static void writeCity(HttpServletResponse response, City city) throws IOException{

        try {
            String filename = "city.csv";
            response.setContentType("text/csv");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + filename + "\"");
            ColumnPositionMappingStrategy<City> mapStrategy
                    = new ColumnPositionMappingStrategy<>();

            mapStrategy.setType(City.class);

            String[] columns = new String[]{"id", "name", "population"};
            mapStrategy.setColumnMapping(columns);

            StatefulBeanToCsv<City> btcsv = new StatefulBeanToCsvBuilder<City>(response.getWriter())
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(',')
                    .build();

            btcsv.write(city);

        } catch (CsvException ex) {

            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }
}