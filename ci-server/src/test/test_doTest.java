package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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
