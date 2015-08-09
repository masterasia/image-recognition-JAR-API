package com.image.recognition;

import com.image.recognition.bean.RecognitionResult;
import com.image.recognition.bean.RequestType;
import com.image.recognition.command.BaseRecognition;
import com.image.recognition.command.RecognitionFactory;
import com.image.recognition.exception.ExaDeepExceotion;
import org.junit.Test;

/**
 * Created by robert on 2015/8/9.
 */
public class RecognitionTest {

    @Test
    public void URLTest() {
        BaseRecognition baseRecognition = RecognitionFactory.getRecognition(RequestType.URL);
        try {
            baseRecognition.prepare("http://ww4.sinaimg.cn/mw600/006b7bQngw1euskv84yz0j30lm0vy78x.jpg",
                    "http://ww3.sinaimg.cn/mw600/006b7bQngw1euwkix9de8j30zk0nmn1z.jpg",
                    "http://ww3.sinaimg.cn/mw600/005uH27gjw9euwjhk5jybj30h80pt420.jpg",
                    "http://ww2.sinaimg.cn/mw600/006b7bQngw1euvmid17v7j30zk1egk21.jpg");
            RecognitionResult recognitionResult = baseRecognition.execute();

        } catch (ExaDeepExceotion exaDeepExceotion) {
            exaDeepExceotion.printStackTrace();
        }
    }

    @Test
    public void ResourceTest(){
        BaseRecognition baseRecognition = RecognitionFactory.getRecognition(RequestType.RESOURCES);
        try {
            baseRecognition.prepare("F:/test");
            RecognitionResult recognitionResult = baseRecognition.execute();

        } catch (ExaDeepExceotion exaDeepExceotion) {
            exaDeepExceotion.printStackTrace();
        }

    }
}
