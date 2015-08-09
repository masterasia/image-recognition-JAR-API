package com.image.recognition.bean;

/**
 * Created by robert on 2015/8/9.
 */
public class LabelResult {
    private String label;
    private int label_idx;
    private String score;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getLabel_idx() {
        return label_idx;
    }

    public void setLabel_idx(int label_idx) {
        this.label_idx = label_idx;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
