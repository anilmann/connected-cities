package org.mann.connectedcities.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mann.connectedcities.component.CityLink;
import org.mann.connectedcities.exception.CityMappingFileException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RunWith(MockitoJUnitRunner.class)
public class CityResourceFileReaderServiceTest {

    @Mock
    private CityLink cityLink;

    @Mock
    private Resource cityInfoResource;

    @InjectMocks
    CityResourceFileReaderService fileReaderService;

    @Test
    public void happyPath() throws IOException {
        InputStream is = new ByteArrayInputStream("A-B".getBytes());
        Mockito.when(cityInfoResource.getInputStream()).thenReturn(is);
        fileReaderService.initialize();
    }

    @Test(expected = IOException.class)
    public void ioExceptionTest() throws IOException {
        Mockito.when(cityInfoResource.getInputStream()).thenThrow(IOException.class);
        fileReaderService.initialize();
    }

    @Test(expected = CityMappingFileException.class)
    public void missingDestinationTest() throws IOException {
        InputStream is = new ByteArrayInputStream("A-".getBytes());
        Mockito.when(cityInfoResource.getInputStream()).thenReturn(is);
        fileReaderService.initialize();
    }

    @Test(expected = CityMappingFileException.class)
    public void emptyDestinationTest() throws IOException {
        InputStream is = new ByteArrayInputStream("A- ".getBytes());
        Mockito.when(cityInfoResource.getInputStream()).thenReturn(is);
        fileReaderService.initialize();
    }

    @Test(expected = CityMappingFileException.class)
    public void multipleDestinationTest() throws IOException {
        InputStream is = new ByteArrayInputStream("A-B-C".getBytes());
        Mockito.when(cityInfoResource.getInputStream()).thenReturn(is);
        fileReaderService.initialize();
    }
}
