package com.image.recognition;

import com.alibaba.fastjson.JSONObject;
import com.image.recognition.tools.Constant;
import com.image.recognition.tools.HttpHelper;
import org.junit.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by robert on 2015/8/5.
 */
public class HttpTest implements Constant{

    @Test
    public void httpBAIDU(){
        try {
            HttpHelper.HttpResult httpResult = HttpHelper.httpRequestURL("http://www.baidu.com",  null);
            assertEquals(200, httpResult.code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void httpTest(){
        try {
            HttpHelper.HttpResult httpResult = HttpHelper.httpRequestURL("https://exadeep.com/", null);
            assertEquals(200, httpResult.code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void httpSendTest(){
        try{
//          String mt = "{api_key => exadeep_ruby_demo_key, urls => [http://ww2.sinaimg.cn/mw600/a00dfa2agw1eus8btk8xdj20tl18g128.jpg,
//          http://ww4.sinaimg.cn/mw600/006b7bQngw1euskv84yz0j30lm0vy78x.jpg]}";
            Map<Object, Object> mt = new HashMap<Object, Object>();
            mt.put("api_key", "exadeep_ruby_demo_key");
            mt.put("urls", "http://ww2.sinaimg.cn/mw600/a00dfa2agw1eus8btk8xdj20tl18g128.jpg");
            List<String> urls = new ArrayList<String>();
            urls.add("http://ww2.sinaimg.cn/mw600/a00dfa2agw1eus8btk8xdj20tl18g128.jpg");
            urls.add("http://ww4.sinaimg.cn/mw600/006b7bQngw1euskv84yz0j30lm0vy78x.jpg");
            mt.put("urls", urls);
            System.out.println(JSONObject.toJSONString(mt));
            HttpHelper.HttpResult httpResult = HttpHelper.httpRequestURL("https://exadeep.com/api/v1/jianhuang",  JSONObject.toJSONString(mt));
            System.out.println(httpResult.content);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
