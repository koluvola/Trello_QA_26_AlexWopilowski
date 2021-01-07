package com.trello.qa26.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public SessionHelper user;
    public WebDriver wd;

    public SessionHelper getUser() {
        return user;
    }

    public void init() {

        wd = new FirefoxDriver();
        //wd = new ChromeDriver();
        wd.navigate().to("https://trello.com/");
        //open window of site to full size
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user = new SessionHelper(wd);

    }

    public void stopTesting() {
        user.delay(10000);
        wd.quit();
    }
}
