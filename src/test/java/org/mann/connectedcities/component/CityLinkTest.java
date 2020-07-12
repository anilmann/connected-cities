package org.mann.connectedcities.component;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CityLinkTest {

    @InjectMocks
    private CityLink cityLink;

    @Test
    public void connectedCitieshappyPathTest() {
        cityLink.addCities("A", "B");
        boolean cityConnected = cityLink.isCityConnected("A", "B");
        Assert.assertTrue(cityConnected);
    }

    @Test
    public void notConnectedTest() {
        cityLink.addCities("A", "B");
        boolean cityConnected = cityLink.isCityConnected("A", "C");
        Assert.assertFalse(cityConnected);
        cityConnected = cityLink.isCityConnected("C", "B");
        Assert.assertFalse(cityConnected);
    }

    @Test
    public void oneCityNullTest(){
        cityLink.addCities("A", "B");
        boolean cityConnected = cityLink.isCityConnected(null, "A");
        Assert.assertFalse(cityConnected);
        cityConnected = cityLink.isCityConnected("A", null);
        Assert.assertFalse(cityConnected);
    }

    @Test
    public void bothCityNullTest(){
        cityLink.addCities("A", "B");
        boolean cityConnected = cityLink.isCityConnected(null, null);
        Assert.assertTrue(cityConnected);
    }

    @Test
    public void cityCaseSensitiveTest(){
        cityLink.addCities("A", "B");
        boolean cityConnected = cityLink.isCityConnected("a", "b");
        Assert.assertTrue(cityConnected);
        cityConnected = cityLink.isCityConnected("A", "b");
        Assert.assertTrue(cityConnected);
        cityConnected = cityLink.isCityConnected("a", "B");
        Assert.assertTrue(cityConnected);
        cityConnected = cityLink.isCityConnected("A", "c");
        Assert.assertFalse(cityConnected);
        cityConnected = cityLink.isCityConnected("a", "C");
        Assert.assertFalse(cityConnected);
        cityConnected = cityLink.isCityConnected("a", "c");
        Assert.assertFalse(cityConnected);
    }

    @Test
    public void sameSourceAndDestinationTest(){
        cityLink.addCities("A", "B");
        boolean cityConnected = cityLink.isCityConnected("C", "C");
        Assert.assertTrue(cityConnected);
    }

    @Test
    public void sameSourceAndDestinationCaseSensitiveTest(){
        cityLink.addCities("A", "B");
        boolean cityConnected = cityLink.isCityConnected("B", "b");
        Assert.assertTrue(cityConnected);
    }

    @Test
    public void addSingleSourceDestinationTest(){
        cityLink.addCities("A", "B");
        boolean cityConnected = cityLink.isCityConnected("A", "B");
        Assert.assertTrue(cityConnected);
    }

    @Test
    public void addMultipleSourceDestinationLinkedTest(){
        cityLink.addCities("A", "B");
        cityLink.addCities("B", "C");
        boolean cityConnected = cityLink.isCityConnected("A", "B");
        Assert.assertTrue(cityConnected);
    }

    @Test
    public void addMultipleSourceDestinationUnlinkedTest(){
        cityLink.addCities("A", "B");
        cityLink.addCities("C", "D");
        boolean cityConnected = cityLink.isCityConnected("A", "B");
        Assert.assertTrue(cityConnected);
    }

    @Test
    public void addMultipleSourceDestinationLinkedLaterTest(){
        cityLink.addCities("A", "B");
        cityLink.addCities("C", "D");
        cityLink.addCities("A", "D");
        boolean cityConnected = cityLink.isCityConnected("A", "C");
        Assert.assertTrue(cityConnected);
    }
}