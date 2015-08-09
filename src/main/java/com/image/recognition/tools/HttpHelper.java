package com.image.recognition.tools;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.*;

/**
 * Created by robert on 2015/8/5.
 */
public class HttpHelper implements Constant {

    public static HttpResult httpRequestURL(String urlPath, String url) throws IOException {

        try {
            HttpClient httpClient = new HttpClient();
            PostMethod postMethod = new PostMethod(urlPath);
            NameValuePair[] data = {
                    new NameValuePair("api_key", "exadeep_ruby_demo_key"),
                    new NameValuePair("urls[]", url)
            };
            postMethod.setRequestBody(data);

            int re = 0;
            String message = "";

            re = httpClient.executeMethod(postMethod);

            message = postMethod.getResponseBodyAsString();

            return new HttpResult(re, message);
        } finally {

        }
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
