package com.image.recognition.command;

import com.image.recognition.exception.ExaDeepExceotion;
import com.image.recognition.tools.BuildHelper;

/**
 * Created by robert on 2015/8/9.
 */
public class MultiRecognition extends BaseRecognition {

    @Override
    public void prepare(String... paths) throws ExaDeepExceotion {
        for (String path : paths)
            if (!BuildHelper.rexHttpURL(path))
                throw new ExaDeepExceotion("someone of your paths is illegal.");


    }
}
