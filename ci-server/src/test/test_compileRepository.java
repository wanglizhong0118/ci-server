package test;

import java.io.File;
import java.io.IOException;
import java.security.acl.AclNotFoundException;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import app.compileRepository;

class test_compileRepository {

    File localtmpPath_exists = new File("C://Users/allwi/Documents/GitHub/ci-server-temp-unittest");
    File localtmpPath_not_exists = new File("C://Users/allwi/Documents/GitHub/ci-server-temp-unittest-fake");

    String logFilePath_exists = "C://Users/allwi/Documents/GitHub/ci-server-temp-unittest/test_log.txt";
    String logFilePath_not_exists = "C://Users/allwi/Documents/GitHub/ci-server-temp-unittest-fake/test_log.txt";

    @Rule
    public ExpectedException fileExceptin = ExpectedException.none();
    public ExpectedException logExceptin = ExpectedException.none();

    @Test
    public void test_compile() {
        fileExceptin.expect(AclNotFoundException.class);
        compileRepository.init(localtmpPath_not_exists, logFilePath_not_exists);
    }

}
