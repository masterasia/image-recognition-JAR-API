package com.image.recognition.command;

import com.alibaba.fastjson.JSON;
import com.image.recognition.bean.RecognitionResult;
import com.image.recognition.exception.ExaDeepExceotion;
import com.image.recognition.tools.BuildHelper;
import com.image.recognition.tools.HttpHelper;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by robert on 2015/8/9.
 */
public class FileRecognition extends BaseRecognition {

    FileRecognition() {
    }

    @Override
    public void prepare(List<String> paths) throws ExaDeepExceotion {
        if (null == paths || paths.isEmpty())
            throw new ExaDeepExceotion("please make sure input file path.");

        List<File> files = new ArrayList<File>();
        for (String path : paths) {
            File file = new File(path);
            if (!file.exists())
                throw new ExaDeepExceotion("auto load need a directory or a file.");

            if (!file.isDirectory()) {
                files.add(file);
            } else {
                files.addAll(Arrays.asList(file.listFiles()));
            }
        }
        this.setUrlPath(BuildHelper.getValue("HTTP.URL.ISPORN"));

        this.setParams(files);
    }

    @Override
    public RecognitionResult execute() {
        List<File> tmpFiles = new ArrayList<File>();
        HttpHelper.HttpResult httpResult = null;
        if (getParams() instanceof List) ;
        {
            for (File file : (List<File>) getParams()) {
                try {
                    BufferedImage bi = ImageIO.read(file);
                    if (null == bi)
                        continue;
                    if (bi.getHeight() > 270 || bi.getWidth() > 270) {
                        BufferedImage bit = transBufferedImage(bi);
                        File fileTMP = new File(file.getPath() + ".bak");

                        ImageIO.write(bit, "jpeg", fileTMP);
                        tmpFiles.add(fileTMP);
                    }else {
                        tmpFiles.add(file);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        try {
            httpResult = HttpHelper.httpRequestFile(getUrlPath(), tmpFiles);

            RecognitionResult recognitionResult = JSON.parseObject(httpResult.content, RecognitionResult.class);

            return recognitionResult;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            for (File file : tmpFiles) {
                if (file.getName().endsWith(".bak"))
                    file.delete();
            }
        }


        return null;
    }

    private BufferedImage transBufferedImage(BufferedImage bi) {
        //����һ��AffineTransform����
        AffineTransform transform = new AffineTransform();
        int nw = 270;
        int nh = 270;
        if (bi.getHeight() > bi.getWidth())
            nw = (nh * bi.getWidth()) / bi.getHeight();
        else
            nh = (nw * bi.getHeight()) / bi.getWidth();

        double sx = nw * 1.0 / bi.getWidth();
        double sy = nh * 1.0 / bi.getHeight();
        //ʵ�����ţ�sx����x����������ӣ�sy����y�����������
        transform.setToScale(sx, sy);

        AffineTransformOp ato = new AffineTransformOp(transform, null);
        //���´���һ��BufferedImage����
        BufferedImage bit = new BufferedImage(nw, nh, BufferedImage.TYPE_3BYTE_BGR);
        //ִ��ת��
        ato.filter(bi, bit);
        return bit;
    }
}
