package com.image.recognition;

import com.image.recognition.tools.HttpHelper;
import org.junit.*;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by robert on 2015/8/5.
 */
public class HttpTest {

    @Test
    public void httpBAIDU(){
        try {
            HttpHelper.HttpResult httpResult = HttpHelper.httpRequest("http://www.baidu.com");
            assertEquals(200, httpResult.code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void httpTest(){
        try {
            HttpHelper.HttpResult httpResult = HttpHelper.httpRequest("https://exadeep.com/");
            assertEquals(200, httpResult.code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
