package com.image.recognition;

import com.alibaba.fastjson.JSON;
import com.image.recognition.bean.RecognitionResult;
import com.image.recognition.bean.RequestType;
import com.image.recognition.command.BaseRecognition;
import com.image.recognition.command.RecognitionFactory;
import com.image.recognition.exception.ExaDeepExceotion;
import com.image.recognition.tools.BuildHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by robert on 2015/8/12.
 */
public class Main {
    public static void main(String[] args){
        switch (args.length){
            case 1 :
                if (args[0].equalsIgnoreCase("help")){
                    printHelp();
                    break;
                }else if (args[0].equalsIgnoreCase("example")){
                    example();
                    break;
                }
            default:
                if (args.length > 1){
                    String[] tars = new String[args.length - 1];
                    System.arraycopy(args, 1, tars, 0 , args.length - 1);
                    if (args[0].equalsIgnoreCase("url")){
                        urlIsPorn(Arrays.asList(tars));
                        break;
                    }else if (args[0].equalsIgnoreCase("file")){
                        fileIsPorn(Arrays.asList(tars));
                        break;
                    }
                }
                printHelp();
                break;
        }
    }

    private static void printHelp() {
        System.out.println("Let us go.");
        System.out.println("see this help again : java -jar ....jar help .");
        System.out.println("see an example: java -jar ....jar example .");
        System.out.println("see call isporn with url: java -jar ....jar url http1 http2 http3... .");
        System.out.println("see call isporn with file: java -jar ....jar file filepath1 filepath2 filepath3... .");
    }

    private static void example() {
        System.out.println("When you see this, that means you have our jar~ congratulations.");
        System.out.println("The RecognitionFacoty is the base class.");
        System.out.println("Method getRecognition can get two type class.");
        System.out.println("One for URL , one for files.");
        System.out.println("You can use RequestType to choose it.");
        System.out.println("And then.");
        System.out.println("You should call prepare method, which need a String list as input params.");
        System.out.println("After all, you can call execute method, that will return RecognitionResult.");
        System.out.println("Now I will make a test use URL.");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("First I get recognition class by factory class.");
        System.out.println("BaseRecognition baseRecognition = RecognitionFactory.getRecognition(RequestType.URL)");
        BaseRecognition baseRecognition = RecognitionFactory.getRecognition(RequestType.URL);
        System.out.println("Second I call the prepare method, and input some URLS.");
        List<String> urls = new ArrayList<String>();

        urls.add("http://ww4.sinaimg.cn/mw600/006b7bQngw1euskv84yz0j30lm0vy78x.jpg");
        urls.add("http://ww3.sinaimg.cn/mw600/006b7bQngw1euwkix9de8j30zk0nmn1z.jpg");
        urls.add("http://ww3.sinaimg.cn/mw600/005uH27gjw9euwjhk5jybj30h80pt420.jpg");
        urls.add("http://ww2.sinaimg.cn/mw600/006b7bQngw1euvmid17v7j30zk1egk21.jpg");

        try {
            System.out.println("baseRecognition.prepare(urls)");
            System.out.println("Becareful! This mehod may throws Exception.");

            baseRecognition.prepare(urls);

            System.out.println("Now we can call the execute method");

            System.out.println("RecognitionResult recognitionResult = baseRecognition.execute()");
            RecognitionResult recognitionResult = baseRecognition.execute();
            System.out.println(recognitionResult);
            System.out.println("If you want , you can change result to a map (key-URL or FILE name : value-label)");
            System.out.println("You can use method: BuildHelper.mapFromRecognitionResult");
            System.out.println(JSON.toJSONString(BuildHelper.mapFromRecognitionResult(baseRecognition.getParams(), recognitionResult)));
        } catch (ExaDeepExceotion exaDeepExceotion) {
            exaDeepExceotion.printStackTrace();
        }
    }

    private static void urlIsPorn(List<String> urls){
        BaseRecognition baseRecognition = RecognitionFactory.getRecognition(RequestType.URL);
        try {
            baseRecognition.prepare(urls);
            RecognitionResult recognitionResult = baseRecognition.execute();
            System.out.println("Base result : ");
            System.out.println(recognitionResult);
            System.out.println("Simple result : ");
            System.out.println(JSON.toJSONString(BuildHelper.mapFromRecognitionResult(baseRecognition.getParams(), recognitionResult)));
        } catch (ExaDeepExceotion exaDeepExceotion) {
            exaDeepExceotion.printStackTrace();
        }
    }

    private static void fileIsPorn(List<String> files){
        BaseRecognition baseRecognition = RecognitionFactory.getRecognition(RequestType.RESOURCES);
        try {
            baseRecognition.prepare(files);
            RecognitionResult recognitionResult = baseRecognition.execute();
            System.out.println("Base result : ");
            System.out.println(recognitionResult);
            System.out.println("Simple result : ");
            System.out.println(JSON.toJSONString(BuildHelper.mapFromRecognitionResult(baseRecognition.getParams(), recognitionResult)));
        } catch (ExaDeepExceotion exaDeepExceotion) {
            exaDeepExceotion.printStackTrace();
        }
    }
}
