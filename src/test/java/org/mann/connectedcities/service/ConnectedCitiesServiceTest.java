package org.mann.connectedcities.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mann.connectedcities.component.CityLink;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConnectedCitiesServiceTest {

    @Mock
    private CityLink cityLink;

    @InjectMocks
    private ConnectedCitiesService citiesService;

    @Test
    public void testHappyPath() {
        Mockito.when(cityLink.isCityConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(true);

        boolean isConnected = citiesService.areCitiesConnected("A", "B");
        Assert.assertTrue(isConnected);
    }

    @Test
    public void testNotConnected(){
        Mockito.when(cityLink.isCityConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(false);

        boolean isConnected = citiesService.areCitiesConnected("A", "C");
        Assert.assertFalse(isConnected);
    }
}
