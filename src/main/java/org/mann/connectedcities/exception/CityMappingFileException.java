package org.mann.connectedcities.exception;

public class CityMappingFileException extends RuntimeException{

    public CityMappingFileException(String exceptionMessage){
        super(exceptionMessage);
    }

    public CityMappingFileException(String exceptionMessage, Throwable exp){
        super(exceptionMessage, exp);
    }
}
