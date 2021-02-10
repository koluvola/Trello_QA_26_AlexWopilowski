package com.trello.qa26.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    //public WebDriver wd;
    // public static EventFiringWebDriver wd;
    static EventFiringWebDriver wd;
    public String browser;
    public SessionHelper user;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    Properties properties;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public SessionHelper getUser() {
        return user;
    }

    public void init() {
        String target = System.getProperty("local", "alex");
        try {
            properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
        }


        wd = new EventFiringWebDriver(new FirefoxDriver());
        wd.register(new MyListener());
        //wd = new ChromeDriver();
       // wd.navigate().to("https://trello.com/");
       // wd.navigate().to(properties.getProperty("web.baseURL"));
        wd.navigate().to(properties.getProperty("web.url"));
        logger.info("Opened site: " + wd.getCurrentUrl());
        //open window of site to full size
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user = new SessionHelper(wd);


    }

    public String setEmail(){
        return properties.getProperty("web.email");
    }

    public String setPassword(){
        return properties.getProperty("web.password");
    }

    public void stopTesting() {
        user.delay(10000);
        wd.quit();
    }

    public static class MyListener extends AbstractWebDriverEventListener {
        HelperBase helperBase = new HelperBase(wd);

        Logger logger = LoggerFactory.getLogger(MyListener.class);


        public MyListener() {
            super();
        }

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver wd) {
            //super.beforeFindBy(by, element, driver);
            System.out.println("Searching: " + by);

        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver wd) {
            //super.afterFindBy(by, element, driver);
            System.out.println(by + ": found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver wd) {
            logger.error(throwable.toString());
            String pathToFile = "src/test/screenSHots/screenShot-";
            // File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // File screenShot = new File(pathToFile + System.currentTimeMillis() + ".png");

            // super.onException(throwable, driver);
            // System.out.println(throwable);
            //HelperBase hb = new HelperBase(driver);
            helperBase.takeScreenShot(pathToFile);

            // logger.error("Screenshot with error: "+screenShot.getAbsolutePath());
            logger.error(pathToFile);
        }
    }


}
