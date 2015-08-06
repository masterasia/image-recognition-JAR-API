package com.image.recognition.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by robert on 2015/8/5.
 */
public class BuildHelper {

    private static Properties properties;

    static {
        properties = new Properties();
        InputStream inputStream = BuildHelper.class.getClassLoader().getResourceAsStream("init.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key){
        return properties.get(key).toString();
    }
}
