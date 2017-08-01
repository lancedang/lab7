package test.com.ppdai.tutorial;

import com.ppdai.tutorial.Character;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by qiankai02 on 2017/7/14.
 */
public class CharacterTest {
    Character emperor;
    Character patrician;
    Character plebeian;
    @Before
    public void setUp() throws Exception {
        emperor = Character.EMPEROR;
        patrician =Character.PATRICIAN;
        plebeian = Character.PLEBEIAN;
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Emperor", emperor.toString());
        assertEquals("Patrician", patrician.toString());
        assertEquals("Plebeian", plebeian.toString());

    }

}