package org.mann.connectedcities.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mann.connectedcities.controller.ConnectedCitiesController;
import org.mann.connectedcities.service.ConnectedCitiesService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class ConnectedCitiesControllerTests {

	@Mock
	private ConnectedCitiesService cityService;

	@InjectMocks
	private ConnectedCitiesController controller;

	@Test
	public void testHappyPath() {
		Mockito.when(cityService.areCitiesConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(true);

		String isConnected = controller.isConnected("A", "B");
		Assert.assertEquals("yes", isConnected);
	}

	@Test
	public void testNotConnected(){
		Mockito.when(cityService.areCitiesConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(false);

		String isConnected = controller.isConnected("A", "B");
		Assert.assertEquals("no", isConnected);
	}

}
