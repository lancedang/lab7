package com.ppdai.tutorial;

/**
 * Created by qiankai02 on 2017/7/14.
 */
public class FateDeck extends Deck<Fate, Card<Fate>> {

    public FateDeck() {
        super("The Deck of Fate");
    }

    @Override
    public void populateDeck() {
        destroyDeck();
        drawingStack.push(new Card<>(Fate.REVOLUTION));
        drawingStack.push(new Card<>(Fate.RICHES));
    }
}
