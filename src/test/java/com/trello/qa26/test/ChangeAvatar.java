package com.trello.qa26.test;

import com.trello.qa26.model.User;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeAvatar extends TestBase {
    //alexwopilowski@hotmail.com
    //Calligula70
    int time=10;
    String email = "alexwopilowski@hotmail.com";
    int number = 0;
    String password = "Calligula70";
    String path = "C:\\Users\\Alex_Wopilowski\\Documents\\GitHub\\Trello_QA_26_AlexWopilowski\\src\\test\\resources\\cat1.jpg";
    String pathToFile = "src/test/screenSHots/screenShot-";


    @BeforeMethod
    public void preconditions() {

        if (!appl.getUser().isElementPresent(By.cssSelector("[class='_24AWINHReYjNBf aYXvcYtXemTcSj']"))) {

            appl.getUser().initLogin();
            appl.getUser().fillLoginForm(new User().withEmail(appl.setEmail()).withPassword(appl.setPassword()), time);
            appl.getUser().confirmLogin();
        }


    }

    @Test(enabled = false)
    public void testChangeAvatar() {

        appl.getUser().clickOnAccountButton();
        appl.getUser().clickProfileAndVisibility();
        appl.getUser().clickToAtlassianProfile();
        appl.getUser().changeAvatar(path);
        appl.getUser().closeWindow(number);


    }
}
