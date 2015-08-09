package com.image.recognition.command;

import com.image.recognition.bean.RecognitionResult;
import com.image.recognition.tools.*;

import java.io.IOException;

/**
 * Created by robert on 2015/8/5.
 */
public class SingleRecognition implements BaseRecognition {

    private String path ;

    private String urlPath;

    private String requestMethod;

    public void prepare(String path) {
        this.path = path;
    }

    public RecognitionResult execute() {
        try {
            HttpHelper.HttpResult httpResult = HttpHelper.httpRequest(urlPath, requestMethod, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
