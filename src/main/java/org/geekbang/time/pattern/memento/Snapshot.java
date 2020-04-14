package org.geekbang.time.pattern.memento;

public class Snapshot {

    private String text;

    public Snapshot(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
