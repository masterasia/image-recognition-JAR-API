package com.image.recognition;

import com.image.recognition.bean.RequestType;
import com.image.recognition.command.BaseRecognition;

/**
 * Created by robert on 2015/8/5.
 *
 */
public class RecognitionFactory {

    public static BaseRecognition getRecognition(RequestType requestType){
        switch (requestType) {
            case SINGLE:
                break;
            case LIST:
                break;
            case RESOURCES:
                break;
            default:
                break;
        }

        return null;
    }
}