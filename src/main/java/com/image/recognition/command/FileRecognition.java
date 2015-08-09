package com.image.recognition.command;

import com.image.recognition.bean.RecognitionResult;
import com.image.recognition.exception.ExaDeepExceotion;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

/**
 * Created by robert on 2015/8/9.
 */
public class FileRecognition extends BaseRecognition{

    @Override
    public void prepare(String... path) throws ExaDeepExceotion {
        if (null == path || path.length == 0)
            throw new ExaDeepExceotion("please make sure input file path.");
        File file = new File(path[0]);
        if (!file.exists() || !file.isDirectory())
            throw new ExaDeepExceotion("auto load need a directory.");

        File[] images = file.listFiles();
        for (File imageF:images){
            try {
                BufferedImage bi = ImageIO.read(imageF);
                if (bi.getHeight() > 270 || bi.getWidth() > 270){

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public List<RecognitionResult> execute() {

        return null;
    }
}
