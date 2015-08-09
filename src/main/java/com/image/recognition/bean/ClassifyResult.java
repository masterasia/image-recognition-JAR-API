package com.image.recognition.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robert on 2015/8/9.
 */
public class ClassifyResult {
    private boolean review;
    private String url;
    private List<LabelResult> scores = new ArrayList<LabelResult>();

    public boolean isReview() {
        return review;
    }

    public void setReview(boolean review) {
        this.review = review;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<LabelResult> getScores() {
        return scores;
    }

    public void setScores(List<LabelResult> scores) {
        this.scores = scores;
    }
}
