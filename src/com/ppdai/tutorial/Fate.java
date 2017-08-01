package com.ppdai.tutorial;

/**
 * Created by qiankai02 on 2017/7/14.
 */
public enum Fate {
    RICHES("Riches"),
    REVOLUTION("Revolution");
    private String playerFate;

    Fate(String playerFate) {
        this.playerFate = playerFate;
    }

    @Override
    public String toString() {
        return playerFate;
    }
}
