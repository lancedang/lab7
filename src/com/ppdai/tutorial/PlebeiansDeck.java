package com.ppdai.tutorial;

/**
 * The Plebeian's com.ppdai.tutorial.Deck which holds cards of type com.ppdai.tutorial.Character.
 * 
 * @author Taner
 * @version 30092016
 * 
 *          Fix where there is a play Once and a RNG
 */
public class PlebeiansDeck extends Deck<Character, Card<Character>>
{
    /**
     * Constructor for the Plebeians's com.ppdai.tutorial.Deck
     */
    public PlebeiansDeck()
    {
        super("Plebeian's deck");
    }

    /**
     * Build the Plebeian's com.ppdai.tutorial.Deck.
     * 
     * This is specifically: 
     *          1x - Plebeian com.ppdai.tutorial.Card
     *          4x - Patrician com.ppdai.tutorial.Card
     */
    @Override
    public void populateDeck()
    {
        destroyDeck();

        for (int i = 0; i < 4; i++)
        {
            drawingStack.add(new Card<Character>(Character.PATRICIAN));
        }

        drawingStack.add(new Card<Character>(Character.PLEBEIAN));
    }
}
