package com.trello.qa26.test;

import com.trello.qa26.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBoardTest extends  TestBase{
    int boardNumber= (int) (System.currentTimeMillis()/100000);
    String email = "alexwopilowski@hotmail.com";
    String password = "Calligula70";
    String boardName="New Board"+boardNumber;
    int time=10;

    @Test(enabled = true)
    public void testCreationBoardOnTrello(){
        if (!appl.getUser().isElementPresent(By.cssSelector("[class='_24AWINHReYjNBf aYXvcYtXemTcSj']"))){
            appl.getUser().initLogin();
            appl.getUser().fillLoginForm(new User().withEmail(email).withPassword(password), time);
            appl.getUser().confirmLogin();
            appl.getUser().createNewBoard(boardName);
        }
        else{
            appl.getUser().createNewBoard(boardName);
            Assert.assertTrue(appl.getUser().isUserLogIn());
            appl.getUser().delay(30000);
        }






    }


}
