package com.image.recognition;

import com.image.recognition.bean.RequestType;
import com.image.recognition.command.BaseRecognition;
import com.image.recognition.command.SingleRecognition;

/**
 * Created by robert on 2015/8/5.
 */
public class RecognitionFactory {

    public static BaseRecognition getRecognition(RequestType requestType) {
        switch (requestType) {
            //单地址模式
            case SINGLE:
                return new SingleRecognition();
            //多地址模式
            case LIST:
                break;
            //本地文件模式
            case RESOURCES:
                break;
            default:
                break;
        }

        return null;
    }
}
