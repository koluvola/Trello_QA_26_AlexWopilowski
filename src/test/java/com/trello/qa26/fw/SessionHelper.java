package com.trello.qa26.fw;

import com.trello.qa26.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

  public void changeAvatar(String path) {

        int number = 1;
        WebElement avatar = wd.findElement(By.cssSelector("[data-test-selector='profile-hover-info']"));
        WebElement photo = wd.findElement(By.xpath("//*[@class='sc-chPdSV cbaecT']"));
        switchToTub(number);

        new Actions(wd).moveToElement(avatar)
                //.click()
                .moveToElement(photo)
                .click()
                .perform();
        click("//*[text()[contains(.,'Upload a photo')]]");
        //click("//div[@id='uid16']//span[1]");
        //click("//button//span[contains(., 'Upload')]");
       // attachPhoto(By.cssSelector("[#image-input]"),new File(path));

    }

    /*  public void changeAvatar1(String path) {
        WebElement avatar = wd.findElement(By.cssSelector("[data-test-selector='profile-hover-info']"));
//[data-test-selector='profile-hover-info'] [class^=Droplist__Trigger]
        Actions actions = new Actions(wd);
        actions
                .moveToElement(avatar)
                .moveToElement(avatar.findElement(By.xpath(".//*[@class='Droplist__Trigger-sc-1z05y4v-3 eteVrT']")))
                .click()
                //.moveToElement(wd.findElement(By.xpath("//div[@id='uid16']/span[1]"))).click()
                .perform();


        //  click(By.xpath("//div[@id='uid16']/span[1]"));
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Change profile photo')]"))).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        attachPhoto(By.cssSelector("#image-input"), new File(path));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click("//button//span[contains(., 'Upload')]");
    }*/


    public void clickOnAccountButton() {
        click("//*[@class='_24AWINHReYjNBf aYXvcYtXemTcSj']");
        delay(5000);
    }

    public void clickProfileAndVisibility() {
        click("//*[contains(text(),'Profile and Visibility')]");
        delay(5000);
    }

    public void clickToAtlassianProfile() {
       /* click("//*[@href='https://id.atlassian.com/login?login_hint=alexwopilowski%40hotmail" +
                ".com&continue=https%3A%2F%2Fid.atlassian.com%2Fmanage-profile']");*/
        clickByCssSelector("[href$='manage-profile']");
        delay(5000);
        switchToTub(1);

    }

    public void confirmLogin() {
        clickButton(By.cssSelector("button[id='login-submit'] span[class='css-t5emrf']"));
        delay(1000);

    }

    public void createNewBoard(String boardName) {
        //clickButton(By.cssSelector("div[class='all-boards'] div:nth-child(2) ul:nth-child(1) li:nth-child(1) div:nth-child(1)"));
        clickButton(By.xpath("//*[text()='Create new board']"));

        type(boardName, By.cssSelector("[class='_23NUW98LaZfBpQ']"));
        clickButton(By.cssSelector("[class='uj9Ovoj4USRUQz voB8NatlbuEme5 _21upOlzpUQJcdT']"));
    }

    public void destroyBoard() {
        //delay(5000);
        if (isElementPresent(By.cssSelector("[class='board-tile-details is-badged']"))) {
            clickByCssSelector("div[class='board-tile-details is-badged']");
            delay(5000);
            clickByCssSelector("[class='board-menu-navigation-item-link js-open-more']");
            delay(5000);
            clickByCssSelector("[class='board-menu-navigation-item-link js-close-board']");
            delay(5000);
            clickByCssSelector("[class='js-confirm full nch-button nch-button--danger']");
            delay(5000);
            clickByCssSelector("[class='quiet js-delete']");
            delay(5000);
            clickByCssSelector("[class='js-confirm full nch-button nch-button--danger']");
            delay(5000);
            clickByCssSelector("[class='MEu8ZECLGMLeab']");
            delay(5000);
            clickByCssSelector("[class='sc-bdVaJa kBFJig']");
            delay(5000);
        } else
            System.out.println("No boards");


    }

    public void fillLoginForm(User user, int time) {
        type(user.getEmail(), By.xpath("//*[@id=\"user\"]"));
        waitForResponse(time, By.xpath("//*[@id=\"password\"]"));
        //delay(2000);
        clickButton(By.cssSelector("[id='login']"));
        delay(2000);
        type(user.getPassword(), By.xpath("//*[@id=\"password\"]"));
        delay(5000);

    }

    public void initLogin() {
        //[class='global-header-section-button mod-primary']
        //a[class='global-header-section-button']
        if (isElementPresent(By.cssSelector("a[class='btn btn-sm btn-link text-white']"))) {
            clickByCssSelector("a[class='btn btn-sm btn-link text-white']");
        }


    }

    public boolean isAvatarPresent() {
        delay(20000);
        return isElementPresent(By.cssSelector("[class='_1FekJJAz6Hu32v']"));
    }


    public void clearAll(String locator){

        List<WebElement> board=wd.findElements(By.xpath(locator));
        System.out.println(board.size());
        for(int i=0; i<board.size();i++){
            WebElement element=board.get(0);
            element.click();
            clickByCssSelector("div[class='board-tile-details is-badged']");
            delay(5000);
            clickByCssSelector("[class='board-menu-navigation-item-link js-open-more']");
            delay(5000);
            clickByCssSelector("[class='board-menu-navigation-item-link js-close-board']");
            delay(5000);
            clickByCssSelector("[class='js-confirm full nch-button nch-button--danger']");
            delay(5000);
            clickByCssSelector("[class='quiet js-delete']");
            delay(5000);
            clickByCssSelector("[class='js-confirm full nch-button nch-button--danger']");
            delay(5000);
            clickByCssSelector("[class='MEu8ZECLGMLeab']");
            delay(5000);
            clickByCssSelector("[class='sc-bdVaJa kBFJig']");
            delay(5000);
        }
    }
}
