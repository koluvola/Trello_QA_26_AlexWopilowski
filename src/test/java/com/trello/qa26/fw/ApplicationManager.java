package com.trello.qa26.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public String browser;
    public SessionHelper user;
    public WebDriver wd;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }


    public SessionHelper getUser() {
        return user;
    }

    public void init() {
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }

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
