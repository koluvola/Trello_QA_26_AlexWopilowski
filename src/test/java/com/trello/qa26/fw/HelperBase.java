package com.trello.qa26.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void attachPhoto( By locator, File file) {
        if (file != null) {
            clickByPosition(locator);
            wd.findElement(locator).sendKeys(file.getAbsolutePath());
        }


    }

    public void click(String xPathSelector) {
        wd.findElement(By.xpath(xPathSelector)).click();
    }

    public void clickButton(By locator) {
        WebElement wb = wd.findElement(locator);
        wb.click();
    }

    public void clickButtonYalla(String url) {
        clickByCssSelector(url);
    }

    public void clickByCssSelector(String cssSelector) {
        wd.findElement(By.cssSelector(cssSelector)).click();

    }

    public void clickCheckBox(By locator) {
        WebElement we = wd.findElement(locator);
        we.click();
    }

    public void clickLogoutButtonOnHeader() {
        clickByCssSelector("[class='_24AWINHReYjNBf aYXvcYtXemTcSj']");
        delay(5000);
        clickByCssSelector("button[data-test-id='header-member-menu-logout'] span[class='lcLi2SyiMFND91']");
        delay(10000);
    }

    public void closeWindow(int number){
        wd.close();
        switchToTub(number);
    }

    public void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isRegistrationFormPresent() {
        return isElementPresent(By.xpath("//h2[contains(.,'Registration')]"));
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public boolean isUserLogIn() {

        return isElementPresent(By.cssSelector("[class='js-board-editing-target board-header-btn-text']"));
    }

    public void switchToTub(int number) {
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(number));
    }

    public void takeScreenShot(String pahttoFile) {
        File screenshotAs = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenShot = new File(pahttoFile + System.currentTimeMillis() + ".png");
        try {
            Files.copy(screenshotAs, screenShot);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void type(String str, By locator) {
        if (str != null) {
            clickByPosition(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(str);
        }


    }

    public void clickByPosition(By locator) {
        wd.findElement(locator).click();
    }

    public void waitForResponse(int time,By locator) {
        WebDriverWait webDriverWait=new WebDriverWait(wd,time);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
