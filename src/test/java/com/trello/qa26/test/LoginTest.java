package com.trello.qa26.test;

import com.trello.qa26.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    //alexwopilowski@hotmail.com
    //Calligula70
    String email = "alexwopilowski@hotmail.com";
    String password = "Calligula70";


    @Test
    public void testAtlassianUserLogin() {
        if (!appl.getUser().isElementPresent(By.cssSelector("[class='_24AWINHReYjNBf aYXvcYtXemTcSj']"))){
            appl.getUser().initLogin();
            appl.getUser().fillLoginForm(new User().withEmail(email).withPassword(password));
            appl.getUser().confirmLogin();

            Assert.assertTrue(appl.getUser().isAvatarPresent());
        }
        /*appl.getUser().initLogin();
        appl.getUser().fillLoginForm(new User().withEmail(email).withPassword(password));
        appl.getUser().confirmLogin();

          Assert.assertTrue(appl.getUser().isAvatarPresent());*/

    }
}
