package com.image.recognition.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robert on 2015/8/5.
 */
public class RecognitionResult {
    private int status;
    private double time;
    private List<ClassifyResult> results = new ArrayList<ClassifyResult>();

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


}
