package com.image.recognition.command;

import com.image.recognition.bean.RecognitionResult;
import com.image.recognition.exception.ExaDeepExceotion;
import com.image.recognition.tools.HttpHelper;

import java.io.IOException;

/**
 * Created by robert on 2015/8/5.
 */
public class BaseRecognition {
    //
    private String params;

    private String urlPath;

    private String requestMethod;

    public void prepare(String... path) throws ExaDeepExceotion {

    }

    ;

    public RecognitionResult execute() {
        try {
            HttpHelper.HttpResult httpResult = HttpHelper.httpRequest(urlPath, requestMethod, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }
}
