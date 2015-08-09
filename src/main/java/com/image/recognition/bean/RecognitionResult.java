package com.image.recognition.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robert on 2015/8/5.
 */
public class RecognitionResult {
    private boolean isYellow = false;
    private String path;
    private int status;
    private double time;
    private List<ClassifyResult> results = new ArrayList<ClassifyResult>();

    public boolean isYellow() {
        return isYellow;
    }

    public void setIsYellow(boolean isYellow) {
        this.isYellow = isYellow;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public List<ClassifyResult> getResults() {
        return results;
    }

    public void setResults(List<ClassifyResult> results) {
        this.results = results;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void judgeYellow(){
        List<LabelResult> labels = this.getResults().get(0).getScores();
        for (LabelResult label : labels){
            if (label.getLabel().equalsIgnoreCase("porn") && Double.parseDouble(label.getScore().substring(0,3)) > 75.0)
                this.isYellow = true;
        }
    }
}
