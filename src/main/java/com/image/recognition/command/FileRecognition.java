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
import java.util.*;

/**
 * Created by robert on 2015/8/9.
 */
public class FileRecognition extends BaseRecognition {

    FileRecognition() {
    }

    @Override
    public void prepare(String... path) throws ExaDeepExceotion {
        if (null == path || path.length == 0)
            throw new ExaDeepExceotion("please make sure input file path.");
        File file = new File(path[0]);
        if (!file.exists() || !file.isDirectory())
            throw new ExaDeepExceotion("auto load need a directory.");

        File[] images = file.listFiles();

        this.setUrlPath(BuildHelper.getValue("HTTP.URL.ISPORN"));

        this.setParams(Arrays.asList(images));
    }

    @Override
    public List<RecognitionResult> execute() {
        List<RecognitionResult> recognitionResults = new ArrayList<RecognitionResult>();
        if (getParams().getClass().isInstance(List.class)) ;
        {
            for (File file : (List<File>) getParams()) {
                HttpHelper.HttpResult httpResult = null;
                try {
                    BufferedImage bi = ImageIO.read(file);
                    if (null == bi)
                        continue;
                    if (bi.getHeight() > 270 || bi.getWidth() > 270) {
                        BufferedImage bit = transBufferedImage(bi);
                        File fileTMP = new File(file.getPath() + ".bak");

                        ImageIO.write(bit, "jpeg", fileTMP);
                        file = fileTMP;
                    }

                    httpResult = HttpHelper.httpRequestFile(getUrlPath(), file);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    RecognitionResult recognitionResult = JSON.parseObject(httpResult.content, RecognitionResult.class);
                    recognitionResult.setPath(file.getPath());
                    recognitionResult.judgeYellow();
                    recognitionResults.add(recognitionResult);
                }catch (Exception e){
                    e.printStackTrace();
                }

                if (file.getName().endsWith(".bak"))
                    file.delete();
            }
        }

        return recognitionResults;
    }

    private BufferedImage transBufferedImage(BufferedImage bi) {
        //创建一个AffineTransform对象
        AffineTransform transform = new AffineTransform();
        int nw = 270;
        int nh = 270;
        if (bi.getHeight() > bi.getWidth())
            nw = (nh * bi.getWidth()) / bi.getHeight();
        else
            nh = (nw * bi.getHeight()) / bi.getWidth();

        double sx = nw * 1.0 / bi.getWidth();
        double sy = nh * 1.0 / bi.getHeight();
        //实现缩放，sx沿着x轴的缩放因子；sy沿着y轴的缩放因子
        transform.setToScale(sx, sy);

        AffineTransformOp ato = new AffineTransformOp(transform, null);
        //重新创建一个BufferedImage对象
        BufferedImage bit = new BufferedImage(nw, nh, BufferedImage.TYPE_3BYTE_BGR);
        //执行转换
        ato.filter(bi, bit);
        return bit;
    }
}
