package com.structure.httpserver.config;

public class HttpConfigurationException extends Exception{
    public HttpConfigurationException(){

    }

    public HttpConfigurationException(String message){
        super(message);
    }

    public HttpConfigurationException(Throwable cause){
        super(cause);
    }


}
