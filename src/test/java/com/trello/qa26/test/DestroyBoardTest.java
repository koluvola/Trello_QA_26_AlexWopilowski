package com.trello.qa26.test;

import com.trello.qa26.model.User;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DestroyBoardTest extends TestBase {

    String email = "alexwopilowski@hotmail.com";
    String locator = "";
    String password = "Calligula70";
    int time = 10;

    @Test(enabled = true)
    public void destroyBoard() {
        if (!appl.getUser().isElementPresent(By.cssSelector("[class='_24AWINHReYjNBf aYXvcYtXemTcSj']"))) {
            appl.getUser().initLogin();
            appl.getUser().fillLoginForm(new User().withEmail(email).withPassword(password), time);
            appl.getUser().confirmLogin();
            appl.getUser().destroyBoard();
            //appl.getUser().clearAll(locator);
        } else if (appl.getUser().isElementPresent(By.cssSelector("[class='_24AWINHReYjNBf aYXvcYtXemTcSj']"))) {
            appl.getUser().destroyBoard();
        }


    }
}
