package test.com.ppdai.tutorial;

import com.ppdai.tutorial.Card;
import com.ppdai.tutorial.Character;
import com.ppdai.tutorial.PlebeiansDeck;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by qiankai02 on 2017/7/14.
 */
public class PlebeiansDeckTest {
    PlebeiansDeck plebeiansDeck;

    @Before
    public void setUp() throws Exception {
        plebeiansDeck = new PlebeiansDeck();
    }

    @Test
    public void populateDeck() throws Exception {
        plebeiansDeck.populateDeck();
        Stack<Card<Character>> drawingStack = plebeiansDeck.drawingStack;

        assertEquals(5, drawingStack.size());
        assertEquals(Character.PLEBEIAN, drawingStack.pop().getCardValue());

        for (int i = 0; i < 3; i++) {
            assertEquals(Character.PATRICIAN, drawingStack.pop().getCardValue());
        }
    }


}