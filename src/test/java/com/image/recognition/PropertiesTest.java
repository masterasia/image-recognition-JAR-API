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
        assertTrue(null != BuildHelper.getValue("HTTP.URL"));
        assertTrue(!BuildHelper.getValue("HTTP.URL").isEmpty());
    }
}
