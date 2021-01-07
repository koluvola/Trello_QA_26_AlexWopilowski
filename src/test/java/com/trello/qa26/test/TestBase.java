package com.trello.qa26.test;


import com.trello.qa26.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public ApplicationManager appl = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        appl.init();
    }

    @AfterMethod
    public void tearDown() {
        appl.getUser().delay(20000);
        appl.stopTesting();

    }


}
