package com.image.recognition.command;

import com.image.recognition.bean.RequestType;
import com.image.recognition.command.BaseRecognition;
import com.image.recognition.command.FileRecognition;
import com.image.recognition.command.URLRecognition;

/**
 * Created by robert on 2015/8/5.
 */
public class RecognitionFactory {

    public static BaseRecognition getRecognition(RequestType requestType) {
        switch (requestType) {
            //HTTP地址模式
            case URL:
                return new URLRecognition();
            //本地文件模式
            case RESOURCES:
                return new FileRecognition();
            default:
                break;
        }

        return null;
    }
}
