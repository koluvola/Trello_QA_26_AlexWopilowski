package com.trello.qa26.test;

import com.trello.qa26.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepeatLoginTest extends TestBase {
    //alexwopilowski@hotmail.com
    //Calligula70
    String email = "alexwopilowski@hotmail.com";
    //String email;
    String password = "Calligula70";
    //String password = "";
    String pathToFile = "src/test/screenSHots/screenShot-";
    int time=10;

    @Test(enabled = false)
    public void testAtlassianUserLogin() {
        //String password = "Calligula70";
        // String email = "alexwopilowski@hotmail.com";

        if (!appl.getUser().isElementPresent(By.cssSelector("[class='_24AWINHReYjNBf aYXvcYtXemTcSj']"))) {
            logger.info("Email: " + email);
            logger.info("Password: " + password);
            appl.getUser().initLogin();
            // appl.getUser().fillLoginForm(new User().withEmail(email).withPassword(password));
            appl.getUser().fillLoginForm(new User().withEmail(appl.setEmail()).withPassword(appl.setPassword()),time);
            appl.getUser().confirmLogin();

            Assert.assertTrue(appl.getUser().isAvatarPresent());
            logger.info("Test past\n");
            appl.getUser().takeScreenShot(pathToFile);
        }
        appl.getUser().initLogin();
        appl.getUser().fillLoginForm(new User().withEmail(email).withPassword(password), time);
        appl.getUser().confirmLogin();

        Assert.assertTrue(appl.getUser().isAvatarPresent());

    }
}
