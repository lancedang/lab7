package com.ppdai.tutorial;

/**
 * Created by qiankai02 on 2017/7/14.
 */
public class EmperorsDeck extends Deck<Character, Card<Character>> {

    public EmperorsDeck() {
        super("Emperor's Deck");
    }

    @Override
    public void populateDeck() {
        destroyDeck();
        for (int i = 0; i < 4; i++) {
            drawingStack.push(new Card<Character>(Character.PATRICIAN));
        }
        drawingStack.push(new Card<Character>(Character.EMPEROR));
    }
}
