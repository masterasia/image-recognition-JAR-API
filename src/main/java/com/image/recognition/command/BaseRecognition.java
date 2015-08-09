package com.image.recognition.command;

import com.image.recognition.bean.RecognitionResult;
import com.image.recognition.exception.ExaDeepExceotion;

/**
 * Created by robert on 2015/8/5.
 */
public class BaseRecognition {
    //请求发送内容
    private Object params;
    //请求路径
    private String urlPath;
    //请求类型
    private String requestMethod;

    public void prepare(String... path) throws ExaDeepExceotion {
        throw new ExaDeepExceotion("are you serious?");
    }

    public RecognitionResult execute() {

        return null;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
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
