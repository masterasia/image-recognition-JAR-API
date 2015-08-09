package com.image.recognition.tools;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;

import java.io.File;
import java.io.IOException;

/**
 * Created by robert on 2015/8/5.
 */
public class HttpHelper implements Constant {

    public static HttpResult httpRequestURL(String urlPath, String url) throws IOException {
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
    }

    public static HttpResult httpRequestFile(String urlPath, File file) throws IOException {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(urlPath);

        Part[] parts ={
                new StringPart("api_key", "exadeep_ruby_demo_key", "ISO-8859-1"),
                new FilePart("images[]", file.getName(), file)
        };

        postMethod.setRequestEntity(new MultipartRequestEntity(parts, postMethod.getParams()));

        int re = 0;
        String message = "";

        re = httpClient.executeMethod(postMethod);

        message = postMethod.getResponseBodyAsString();

        return new HttpResult(re, message);
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
