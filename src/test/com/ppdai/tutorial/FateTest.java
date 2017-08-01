package test.com.ppdai.tutorial;

import com.ppdai.tutorial.Fate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by qiankai02 on 2017/7/14.
 */
public class FateTest {
    Fate fate1;
    Fate fate2;
    @Before
    public void before() {
        fate1 = Fate.REVOLUTION;
        fate2 = Fate.RICHES;
    }
    @Test
    public void testToString() throws Exception {
        assertEquals("Revolution", fate1.toString());
        assertEquals("Riches", fate2.toString());
    }

}