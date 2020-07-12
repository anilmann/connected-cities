package org.mann.connectedcities.component;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
public class CityLink {

    private final List<Set<String>> connectedCities = new LinkedList<>();

    public void addCities(String source, String destination) {

        List<Set<String>> mergeSets = new LinkedList<>();
        boolean isAdded = false;
        String tempSrc = source.trim().toUpperCase();
        String tempDest = destination.trim().toUpperCase();

        //Iterate through set of cities and check if any city (source or destination) is present in any set, if yes
        // then add cities to that set. In case multiple sets were updated, it will be taken care to merge them in
        // single set later.
        for (Set<String> cities : connectedCities) {
            if (cities.contains(tempSrc) || cities.contains(tempDest)) {
                cities.add(tempSrc);
                cities.add(tempDest);
                mergeSets.add(cities);
                isAdded = true;
            }
        }

        //In case two cities are from 2 different sets and are connected at this point then connected cities set
        // should be merged as one
        if (mergeSets.size() > 1) {
            Set<String> finalSet = new HashSet<>();
            for (Set<String> cities : mergeSets) {
                finalSet.addAll(cities);
                connectedCities.remove(cities);
            }
            connectedCities.add(finalSet);
        }

        //In case cities were not part of any existing set of cities then we need to create a new set.
        if (!isAdded) {
            Set<String> newCities = new HashSet<>();
            newCities.add(tempSrc);
            newCities.add(tempDest);
            connectedCities.add(newCities);
        }
    }

    /**
     * This method will check if two cities are connected
     * @param source
     * @param destination
     * @return boolean value
     */
    public boolean isCityConnected(String source, String destination) {

        //If both cities are null then they are same
        if (source == null && destination == null) {
            return true;
        }

        //Either of one city is null then they will never be connected
        if (source == null || destination == null) {
            return false;
        }

        //Removing case sensitivity
        String tempSrc = source.trim().toUpperCase();
        String tempDest = destination.trim().toUpperCase();

        if (tempSrc.equals(tempDest)) {
            return true;
        }

        for (Set<String> cities : connectedCities) {
            if (cities.contains(tempSrc) && cities.contains(tempDest)) {
                return true;
            }
        }

        return false;
    }
}