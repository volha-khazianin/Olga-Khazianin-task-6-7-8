package com.electonicstore;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestRunner{
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        List<String> file = Arrays.asList("src/main/java/suites/suite.xml");
        testNG.setTestSuites(file);
        testNG.run();
    }
}
