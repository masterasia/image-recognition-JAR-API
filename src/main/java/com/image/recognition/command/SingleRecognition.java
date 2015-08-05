package com.image.recognition.command;

import com.image.recognition.bean.RecognitionResult;
import com.image.recognition.tools.BuildHelper;
import com.image.recognition.tools.HttpHelper;

/**
 * Created by robert on 2015/8/5.
 */
public class SingleRecognition implements BaseRecognition {

    private String path ;

    public void prepare(String path) {
        this.path = path;
    }

    public RecognitionResult execute() {

        return null;
    }
}
