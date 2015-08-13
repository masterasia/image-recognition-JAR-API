package com.image.recognition;

import com.image.recognition.tools.BuildHelper;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by robert on 2015/8/5.
 */
public class PropertiesTest {
    @Test
    public void properties() {
        assertTrue(null != BuildHelper.getValue("HTTP.URL.ISPORN"));
        assertTrue(!BuildHelper.getValue("HTTP.URL.ISPORN").isEmpty());
    }

    @Test
    public void httpRex(){
//        String url = "http://www.baidu.com";
//        String url = "http://blog.chinaunix.net/uid-22174570-id-1786903.html";
//        String url = "https://gitcafe.com/exadeep/py_isporn";
        String url = "https://exadeep.com/api";

        assertTrue(BuildHelper.rexHttpURL(url));
    }
}
