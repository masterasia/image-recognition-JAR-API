package com.image.recognition.tools;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by robert on 2015/8/5.
 */
public class HttpHelper implements Constant {

    public static HttpResult httpRequest(String urlPath, String method, Map<Object, Object> params) throws IOException {
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(urlPath);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(method);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(TIME_OUT);
            httpURLConnection.setReadTimeout(TIME_OUT);

            httpURLConnection.connect();

            int re = 0;
            String message = "";
            if (null != params && !params.isEmpty()) {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(byteFromMap(params));
                outputStream.flush();
                outputStream.close();
                re = httpURLConnection.getResponseCode();
                message = getStringFromStream(httpURLConnection.getInputStream());
            }
            return new HttpResult(re, message);
        } finally {
            if (null != httpURLConnection)
                httpURLConnection.disconnect();
        }
    }

    private static String getStringFromStream(InputStream inputStream){
        char[] temp = new char[1024];
        CharArrayWriter writer = new CharArrayWriter();
        try {
            for (int n = 0; (n = new InputStreamReader(inputStream).read(temp)) > 0;) {
                writer.write(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return writer.toString();
    }

    private static byte[] byteFromMap(Map<Object, Object> params){
        StringBuilder sb = new StringBuilder();
        System.out.print(params.toString());
        sb.append("{");
        Iterator<Entry<Object, Object>> iterator = params.entrySet().iterator();
        int flag = 0;
        while (iterator.hasNext()) {
            Entry<Object, Object> entry = iterator.next();
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
        return sb.toString().getBytes();
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
