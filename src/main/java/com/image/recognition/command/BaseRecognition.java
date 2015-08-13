package com.image.recognition.command;

import com.image.recognition.bean.RecognitionResult;
import com.image.recognition.exception.ExaDeepExceotion;

import java.util.List;

/**
 * Created by robert on 2015/8/5.
 */
public class BaseRecognition {
    //����������
    private Object params;
    //����·��
    private String urlPath;
    //��������
    private String requestMethod;

    public void prepare(List<String> paths) throws ExaDeepExceotion {
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
