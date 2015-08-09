package com.image.recognition.command;

import com.image.recognition.exception.ExaDeepExceotion;
import com.image.recognition.tools.BuildHelper;

/**
 * Created by robert on 2015/8/5.
 */
public class SingleRecognition extends BaseRecognition {

    @Override
    public void prepare(String... path) throws ExaDeepExceotion {
        if (path.length > 1)
            throw new ExaDeepExceotion("this is single path, please check your input.");
        if (!BuildHelper.rexHttpURL(path[0]))
            throw new ExaDeepExceotion("your path is illegal.");


    }
}
