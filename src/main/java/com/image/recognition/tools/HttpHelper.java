package com.image.recognition.tools;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by robert on 2015/8/5.
 */
public class HttpHelper {

    private static int timeOut = 30000;

    public static HttpResult httpRequest(String urlPath) throws IOException {
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(urlPath);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(timeOut);
            httpURLConnection.setReadTimeout(timeOut);
            httpURLConnection.connect();

            int re = httpURLConnection.getResponseCode();
            String message = getStringFromStream(httpURLConnection.getInputStream());

            return new HttpResult(re, message);
        } finally {
            if (null != httpURLConnection)
                httpURLConnection.disconnect();
        }
    }

    private static String getStringFromStream(InputStream inputStream){
        return null;
    }

    static public class HttpResult {
        final public int code;
        final public String content;


        public HttpResult(int code, String content) {
            this.code = code;
            this.content = content;
        }
    }
}
