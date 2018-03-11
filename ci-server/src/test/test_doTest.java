package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class test_doTest {

    @Test
    public void test_TrueIsFalse() {
        try {
            assertFalse(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_FalseIsTrue() {
        try {
            assertTrue(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
