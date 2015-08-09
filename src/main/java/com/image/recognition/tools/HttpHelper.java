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
import java.util.List;

/**
 * Created by robert on 2015/8/5.
 */
public class HttpHelper implements Constant {

    public static HttpResult httpRequestURL(String urlPath, List<String> urls) throws IOException {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(urlPath);
        NameValuePair[] data = new NameValuePair[urls.size() + 1];
        int index = 0;
        data[index++] = new NameValuePair("api_key", "exadeep_ruby_demo_key");
        for (;index < urls.size() + 1; index++) {
            data[index] = new NameValuePair("urls[]", urls.get(index - 1));
        }

        postMethod.setRequestBody(data);

        int re = 0;
        String message = "";

        re = httpClient.executeMethod(postMethod);

        message = postMethod.getResponseBodyAsString();

        return new HttpResult(re, message);
    }

    public static HttpResult httpRequestFile(String urlPath, List<File> files) throws IOException {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(urlPath);

        Part[] parts = new Part[files.size() + 1];
        int index = 0;
        parts[index++] = new StringPart("api_key", "exadeep_ruby_demo_key", "ISO-8859-1");
        for (; index < files.size() + 1; index++) {
            parts[index] = new FilePart("images[]", files.get(index - 1));
        }

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
