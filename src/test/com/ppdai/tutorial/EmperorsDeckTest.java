package test.com.ppdai.tutorial;

import com.ppdai.tutorial.Card;
import com.ppdai.tutorial.Character;
import com.ppdai.tutorial.EmperorsDeck;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by qiankai02 on 2017/7/14.
 */
public class EmperorsDeckTest {
    EmperorsDeck emperorsDeck;
    @Before
    public void setUp() throws Exception {
        emperorsDeck = new EmperorsDeck();
    }

    @Test
    public void populateDeck() throws Exception {
        emperorsDeck.populateDeck();
        //package modifier makes it imposssible to visit the drawingStack in deck
        //here, change it to public
        Stack<Card<Character>> drawingStack = emperorsDeck.drawingStack;

        assertEquals(5, drawingStack.size());
        assertEquals(Character.EMPEROR, drawingStack.pop().getCardValue());

        for (int i = 0; i < 3; i++) {
            assertEquals(Character.PATRICIAN, drawingStack.pop().getCardValue());
        }

    }

}