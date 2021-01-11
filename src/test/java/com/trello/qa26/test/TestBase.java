package com.trello.qa26.test;


import com.trello.qa26.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager appl = new ApplicationManager(System.getProperty("browser",
            BrowserType.FIREFOX));
    //protected static ApplicationManager appl = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        appl.init();
    }

    @AfterSuite
    public void tearDown() {
        appl.getUser().delay(20000);
        appl.stopTesting();

    }


}
