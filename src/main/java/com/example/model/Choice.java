package com.example.model;

public class Choice {

    private int index;
    private Message message;

    // Don't need a constructor in this one

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
