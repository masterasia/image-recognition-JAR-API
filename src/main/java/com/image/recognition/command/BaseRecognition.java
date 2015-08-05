package com.image.recognition.command;

import com.image.recognition.bean.RecognitionResult;

/**
 * Created by robert on 2015/8/5.
 */
public interface BaseRecognition {

    public void prepare(String path);

    public RecognitionResult execute();
}
