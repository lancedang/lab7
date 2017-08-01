package com.ppdai.tutorial;

import java.util.Stack;
import java.util.Collections;

/**
 * com.ppdai.tutorial.Deck for a generic type of cards
 *
 * @param <T>  The Type of the Cards
 * @param <T2> com.ppdai.tutorial.Card Class of some chosen type
 * @author Taner
 * @version 30092016
 */
public abstract class Deck<T, T2 extends Card<T>> {
    /**
     * Stack of cards that have been used already.
     */
    protected Stack<T2> discardStack;

    /**
     * Stack of cards yet to be used.
     */
    public Stack<T2> drawingStack;

    /**
     * Some description or title of the deck being used.
     */
    private String name;

    /**
     * com.ppdai.tutorial.Deck Constructor.
     * <p>
     * Creates a Discard Stack and Drawing Stack with initially
     * zero cards inside both.
     *
     * @param name The title or description of this deck
     */
    public Deck(String name) {
        this.name = name;
        //TODO: Implement
        this.discardStack = new Stack<>();
        this.drawingStack = new Stack<>();
    }

    /**
     * Add cards to the Stack to ensure the deck has some
     * cards to use for play.
     */
    public abstract void populateDeck();

    /**
     * Draw a card from the Drawing Stack if there is a card
     * to draw. If one is not available, the Discard Stack is
     * popped completely into the Drawing Stack, and the Drawing
     * Stack is shuffled. A card is then drawn.
     * <p>
     * Before this card's value is returned by the method, the
     * card is first pushed onto the top of the Discard Stack.
     *
     * @return The value of the top card of the drawingStack
     */
    public T drawCard() {
        //TODO: Implement

        //If the drawingStack is empty, refill the drawingDeck and shuffle

        //Draw the top card of the Drawing Stack

        //Push it on the Discard Stack then return the card's value

        if (drawingStack.empty()) {
            resetDeck();
        }
        T2 popCard = drawingStack.pop();
        discardStack.push(popCard);
        return popCard.getCardValue();
    }

    /**
     * Shuffle the drawingStack
     */
    public void shuffleDeck() {
        Collections.shuffle(drawingStack);
    }

    /**
     * Push all of the cards in the Discard Stack onto the Drawing Stack and shuffle
     */
    public void resetDeck() {
        //TODO: Implement
        while (!discardStack.empty()) {
            drawingStack.push(discardStack.pop());
        }
        shuffleDeck();
    }

    /**
     * Remove all cards from both card Stacks
     */
    public void destroyDeck() {
        //TODO: Implement
        this.drawingStack.clear();
        this.discardStack.clear();
    }
}
