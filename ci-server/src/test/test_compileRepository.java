package test;

import java.io.File;
import org.junit.jupiter.api.Test;

class test_compileRepository {

    File localtmpPath_exists = new File("C://Users/allwi/Documents/GitHub/ci-server-temp-unittest");
    File localtmpPath_not_exists = new File("C://Users/allwi/Documents/GitHub/ci-server-temp-unittest-fake");

    String logFilePath_exists = "C://Users/allwi/Documents/GitHub/ci-server-temp-unittest/test_log.txt";
    String logFilePath_not_exists = "C://Users/allwi/Documents/GitHub/ci-server-temp-unittest-fake/test_log.txt";

    @Test
    public void test_compile() {

    }

}
