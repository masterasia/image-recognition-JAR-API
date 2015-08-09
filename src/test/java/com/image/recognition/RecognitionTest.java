package com.image.recognition;

import com.image.recognition.bean.RecognitionResult;
import com.image.recognition.bean.RequestType;
import com.image.recognition.command.BaseRecognition;
import com.image.recognition.exception.ExaDeepExceotion;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by robert on 2015/8/9.
 */
public class RecognitionTest {

    @Test
    public void URLTest() {
        BaseRecognition baseRecognition = RecognitionFactory.getRecognition(RequestType.URL);
        try {
            baseRecognition.prepare("http://ww4.sinaimg.cn/mw600/006b7bQngw1euskv84yz0j30lm0vy78x.jpg");
            List<RecognitionResult> recognitionResults = baseRecognition.execute();
            assertTrue(recognitionResults.get(0).isYellow());
        } catch (ExaDeepExceotion exaDeepExceotion) {
            exaDeepExceotion.printStackTrace();
        }
    }
}
