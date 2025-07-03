package com.structure.httpserver.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.structure.httpserver.util.Json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationManager {

    private static ConfigurationManager myConfigurationManager;
    private static Configuration myCurrentConfiguration;

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance(){
        if(myConfigurationManager == null){
            myConfigurationManager = new ConfigurationManager();
            return myConfigurationManager;
        }
        return null;
    }

    /*
     *
     * Used to load a configuration file by the path provided
     *
     *
     */



    public void loadConfigurationFile(String filepath) throws IOException, HttpConfigurationException {
        FileReader fileReader = null;
        try{
            fileReader = new FileReader(filepath);
        }catch (FileNotFoundException e){
            throw new HttpConfigurationException(e);
        }
        StringBuffer strBuffer = new StringBuffer();
        int i;
        while((i = fileReader.read()) != -1){
            strBuffer.append((char) i);

        }
        JsonNode conf = Json.parse(strBuffer.toString());
        myCurrentConfiguration = Json.fromJson(conf, Configuration.class);

    }

    /*
    * Returns the current loaded configuration
    * */

    public Configuration getCurrentConfiguration() throws HttpConfigurationException {
        if(myCurrentConfiguration == null){
            throw new HttpConfigurationException("No current configuration set.");
        }

        return myCurrentConfiguration;

    }





}
