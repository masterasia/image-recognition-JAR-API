package com.image.recognition.tools;

import com.image.recognition.bean.LabelResult;
import com.image.recognition.bean.RecognitionResult;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by robert on 2015/8/5.
 */
public class BuildHelper {

    private static Properties properties;

    private static final String REX = "^(http|https)?(://)?(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*((:\\d+)?)(/(\\w+(-\\w+)*))*(\\.?(\\w)*)(\\?)?(((\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*(\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*)*(\\w*)*)$";

    static {
        properties = new Properties();
        InputStream inputStream = BuildHelper.class.getClassLoader().getResourceAsStream("init.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return properties.get(key).toString();
    }

    /**
     * check url
     *
     * @param url url path
     * @return is a url or not
     */
    public static boolean rexHttpURL(String url) {
        if (url.matches(REX))
            return true;
        return false;
    }

    public static Map<String/*URL path or FILE path*/, List<LabelResult> /*isporn*/> mapFromRecognitionResult(Object params, RecognitionResult recognitionResult) {
        Map result = new HashMap();
        if (params instanceof List) {
            List<Object> param = (List<Object>) params;
            for (int i = 0; i < param.size(); i++) {
                Object tmp = param.get(0);
                if (null != recognitionResult.getResults().get(0).getUrl() && !recognitionResult.getResults().get(0).getUrl().isEmpty()) {
                    if (tmp instanceof File) {
                        File file = (File) tmp;
                        if (file.getName().equalsIgnoreCase(recognitionResult.getResults().get(0).getUrl())) {
                            result.put(file.getName(), recognitionResult.getResults());
                        } else {
                            result.put(recognitionResult.getResults().get(i).getUrl(), recognitionResult.getResults());
                        }
                    } else {
                        String string = (String) tmp;
                        if (string.equalsIgnoreCase(recognitionResult.getResults().get(0).getUrl())) {
                            result.put(string, recognitionResult.getResults());
                        } else {
                            result.put(recognitionResult.getResults().get(i).getUrl(), recognitionResult.getResults());
                        }
                    }
                } else {
                    if (tmp instanceof File) {
                        File file = (File) tmp;
                        result.put(file.getName(), recognitionResult.getResults());
                    } else {
                        String string = (String) tmp;
                        result.put(string, recognitionResult.getResults());
                    }
                }
            }
        }
        return result;
    }
}
