package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class test_compileRepository {

    File localtmpPath_exists = new File("C://Users/allwi/Documents/GitHub/ci-server-temp-unittest");
    File localtmpPath_not_exists = new File("C://Users/allwi/Documents/GitHub/ci-server-temp-unittest-fake");

    String logFilePath_exists = "C://Users/allwi/Documents/GitHub/ci-server-temp-unittest/test_log.txt";
    String logFilePath_not_exists = "C://Users/allwi/Documents/GitHub/ci-server-temp-unittest-fake/test_log.txt";

    @Test
    public void test_Doit() throws IOException {
        assertTrue(true);

    }

}
