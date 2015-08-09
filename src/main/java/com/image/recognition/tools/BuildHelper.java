package com.image.recognition.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
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

    public static String byteFromMap(Map<Object, Object> params){
        StringBuilder sb = new StringBuilder();
        System.out.print(params.toString());
        sb.append("{");
        Iterator<Map.Entry<Object, Object>> iterator = params.entrySet().iterator();
        int flag = 0;
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();
            if (flag++ > 0)
                sb.append(",");
            sb.append("\"");
            sb.append(entry.getKey());
            sb.append("\"");
            sb.append("=>");
            sb.append("\"");
            sb.append(entry.getValue());
            sb.append("\"");

        }
        sb.append("}");
        return sb.toString();
    }
}
