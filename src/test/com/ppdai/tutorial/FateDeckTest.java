package test.com.ppdai.tutorial;

import com.ppdai.tutorial.Card;
import com.ppdai.tutorial.Character;
import com.ppdai.tutorial.Fate;
import com.ppdai.tutorial.FateDeck;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by qiankai02 on 2017/7/14.
 */
public class FateDeckTest {
    FateDeck fateDeck;
    @Before
    public void before(){
        fateDeck = new FateDeck();
    }
    @Test
    public void populateDeck() throws Exception {
        fateDeck.populateDeck();
        Stack<Card<Fate>> drawingStack = fateDeck.drawingStack;

        assertEquals(2, drawingStack.size());

        assertEquals(Fate.RICHES, drawingStack.pop().getCardValue());
        assertEquals(Fate.REVOLUTION, drawingStack.pop().getCardValue());
    }

}