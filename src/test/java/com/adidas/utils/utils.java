package com.adidas.utils;

import java.io.FileReader;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class utils {

    public static String getProjectProperties(String key) {
        String value = "";
        try {
            Properties prop = new Properties();
            FileReader file = new FileReader("project.properties");
            prop.load(file);
            value = prop.getProperty(key);
        } catch (Exception e) {
            System.out.println("Unable to read project properties file");
        }
        return value;
    }

    public static JSONObject getJSON(String jsonName) {
        return getJSON(jsonName, Collections.emptyMap());
    }

    public static JSONObject getJSON(String jsonName, Map<String, String> values) {
        JSONObject json = new JSONObject();
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/test/resources/jsons/" + jsonName + ".json"));

            json = (JSONObject) obj;
            for (Map.Entry<String, String> entry : values.entrySet()) {
                json.put(entry.getKey(), entry.getValue());
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error al leer el archivo json " + jsonName + ".json");
        }
        return json;
    }

}
