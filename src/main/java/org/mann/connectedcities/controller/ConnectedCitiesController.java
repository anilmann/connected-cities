package org.mann.connectedcities.controller;

import org.mann.connectedcities.service.ConnectedCitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectedCitiesController {

    @Autowired
    private ConnectedCitiesService cityService;

    /**
     * @param originCity
     * @param destinationCity
     * @return yes if origin and destination city are connected else will return no
     */
    @GetMapping(path = "/connected")
    public String isConnected(@RequestParam("origin") String originCity,
                               @RequestParam("destination") String destinationCity){
        return cityService.areCitiesConnected(originCity, destinationCity) ? "yes": "no";
    }
}