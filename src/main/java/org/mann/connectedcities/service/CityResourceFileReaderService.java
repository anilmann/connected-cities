package org.mann.connectedcities.service;

import org.mann.connectedcities.exception.CityMappingFileException;
import org.mann.connectedcities.component.CityLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class CityResourceFileReaderService {

    @Autowired
    private CityLink cityLink;

    @Value("classpath:data/city-information.txt")
    private Resource cityInfoResource;

    /**
     * Load cities mapping (connectivity) from resource file.
     * @throws IOException
     */
    @PostConstruct
    public void initialize() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(cityInfoResource.getInputStream()))){
            reader.lines().forEach(this::addCities);
        }
    }

    private void addCities(String line) {
        String [] str = line.trim().split("-");
        if(str.length != 2){
            throw new CityMappingFileException("City mapping issue detected. Input Data :: " + line);
        }
        cityLink.addCities(str[0].trim(), str[1].trim());
    }
}
