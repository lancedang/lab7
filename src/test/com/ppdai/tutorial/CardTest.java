package test.com.ppdai.tutorial;

import com.ppdai.tutorial.Card;
import com.ppdai.tutorial.Character;
import com.ppdai.tutorial.Fate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by qiankai02 on 2017/7/14.
 */
public class CardTest {
    Card<Character> charCardEmperor;
    Card<Fate> fateCardRiches;
    @Before
    public void setUp() throws Exception {
        charCardEmperor = new Card<>(Character.EMPEROR);
        fateCardRiches = new Card<>(Fate.RICHES);
    }

    @Test
    public void getCardValue() throws Exception {
        assertEquals(Character.EMPEROR, charCardEmperor.getCardValue());
        assertEquals(Fate.RICHES, fateCardRiches.getCardValue());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Emperor", charCardEmperor.toString());
        assertEquals("Riches", fateCardRiches.toString());
    }

}