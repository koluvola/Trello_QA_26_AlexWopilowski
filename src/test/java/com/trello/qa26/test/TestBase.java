package com.trello.qa26.test;


import com.trello.qa26.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.lang.reflect.Method;

public class TestBase {

    protected static ApplicationManager appl = new ApplicationManager(System.getProperty("browser",
            BrowserType.FIREFOX));
    //protected static ApplicationManager appl = new ApplicationManager();

    Logger logger= LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
        appl.init();
    }

    @BeforeMethod
    public void startLogger(Method method){
        logger.info("Start test: "+ method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void stopLogger(Method method){
        logger.info("Stop test: "+ method.getName());
    }

    @AfterSuite
    public void tearDown() {
        appl.getUser().delay(20000);
        appl.stopTesting();

    }


}
