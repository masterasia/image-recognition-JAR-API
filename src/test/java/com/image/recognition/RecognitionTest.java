package com.image.recognition;

import com.alibaba.fastjson.JSON;
import com.image.recognition.bean.RecognitionResult;
import com.image.recognition.bean.RequestType;
import com.image.recognition.command.BaseRecognition;
import com.image.recognition.command.RecognitionFactory;
import com.image.recognition.exception.ExaDeepExceotion;
import com.image.recognition.tools.BuildHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robert on 2015/8/9.
 */
public class RecognitionTest {

    @Test
    public void URLTest() {
        BaseRecognition baseRecognition = RecognitionFactory.getRecognition(RequestType.URL);
        try {
            List<String> urls = new ArrayList<String>();

            urls.add("http://ww4.sinaimg.cn/mw600/006b7bQngw1euskv84yz0j30lm0vy78x.jpg");
            urls.add("http://ww3.sinaimg.cn/mw600/006b7bQngw1euwkix9de8j30zk0nmn1z.jpg");
            urls.add("http://ww3.sinaimg.cn/mw600/005uH27gjw9euwjhk5jybj30h80pt420.jpg");
            urls.add("http://ww2.sinaimg.cn/mw600/006b7bQngw1euvmid17v7j30zk1egk21.jpg");

            baseRecognition.prepare(urls);
            RecognitionResult recognitionResult = baseRecognition.execute();
            System.out.println(recognitionResult);
            System.out.println(JSON.toJSONString(BuildHelper.mapFromRecognitionResult(baseRecognition.getParams(), recognitionResult)));
        } catch (ExaDeepExceotion exaDeepExceotion) {
            exaDeepExceotion.printStackTrace();
        }
    }

    @Test
    public void ResourceTest() {
        BaseRecognition baseRecognition = RecognitionFactory.getRecognition(RequestType.RESOURCES);
        try {
            List<String> files = new ArrayList<String>();
            files.add("F:/test");
            baseRecognition.prepare(files);
            RecognitionResult recognitionResult = baseRecognition.execute();

            System.out.println(recognitionResult);
            System.out.println(JSON.toJSONString(BuildHelper.mapFromRecognitionResult(baseRecognition.getParams(), recognitionResult)));
        } catch (ExaDeepExceotion exaDeepExceotion) {
            exaDeepExceotion.printStackTrace();
        }

    }
}
