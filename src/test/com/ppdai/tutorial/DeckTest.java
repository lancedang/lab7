package test.com.ppdai.tutorial;

import com.ppdai.tutorial.Card;
import com.ppdai.tutorial.Character;
import com.ppdai.tutorial.Deck;
import com.ppdai.tutorial.PlebeiansDeck;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by qiankai02 on 2017/7/14.
 */
public class DeckTest {
    PlebeiansDeck plebeiansDeck;
    @Before
    public void setUp() throws Exception {
        plebeiansDeck = new PlebeiansDeck();
        plebeiansDeck.populateDeck();
    }

    @Test
    public void drawCard() throws Exception {
        Character drawCard1 = plebeiansDeck.drawCard();
        Character drawCard2 = plebeiansDeck.drawCard();
        Character drawCard3 = plebeiansDeck.drawCard();
        Character drawCard4 = plebeiansDeck.drawCard();
        Character drawCard5 = plebeiansDeck.drawCard();

        assertEquals("Plebeian", drawCard1.toString());
        assertEquals("Patrician", drawCard2.toString());
        assertEquals("Patrician", drawCard3.toString());
        assertEquals("Patrician", drawCard4.toString());
        assertEquals("Patrician", drawCard5.toString());

        Character drawCard6 = plebeiansDeck.drawCard();

    }

    @Ignore
    @Test
    public void shuffleDeck() throws Exception {
        Stack<Card<Character>> oldStack = plebeiansDeck.drawingStack;
        /*
        for(int i = 0; i< 5; i++) {
            System.out.println("--" + oldStack.pop());
        }
        */

        //执行shuffle
        plebeiansDeck.shuffleDeck();
        Stack<Card<Character>> newStack = plebeiansDeck.drawingStack;

        //判断shuffle前后 栈内元素顺序是否相同
        for(int i = 0; i< 5; i++) {
            System.out.println("++" + newStack.pop());
        }
        assertEquals(oldStack, newStack);
    }

    @Test
    public void resetDeck() throws Exception {
        //plebeiansDeck.drawCard();
        plebeiansDeck.resetDeck();
        Stack<Card<Character>> oldStack = plebeiansDeck.drawingStack;
        //判断shuffle前后 栈内元素顺序是否相同
        for(int i = 0; i< 5; i++) {
            System.out.println(oldStack.pop());
        }
    }

    @Ignore
    @Test
    public void destroyDeck() throws Exception {
        assertEquals(5, plebeiansDeck.drawingStack.size());
        plebeiansDeck.destroyDeck();
        assertEquals(0, plebeiansDeck.drawingStack.size());

    }

}