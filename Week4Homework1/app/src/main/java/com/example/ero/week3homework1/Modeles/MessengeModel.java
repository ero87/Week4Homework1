package com.example.ero.week3homework1.Modeles;

public class MessengeModel {

    private String text;
    private boolean isMine;

    public MessengeModel(String text, boolean isMine) {
        this.text = text;
        this.isMine = isMine;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }
}
