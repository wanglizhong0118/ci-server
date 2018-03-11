package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ test_helpFunc.class, test_cloneRepository.class, test_compileRepository.class, test_doTest.class })
public class AllTests {

    public void doTest() {
        System.out.println("hellow");
    }
}
