package com.trello.qa26.test;

import com.trello.qa26.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBoardTest extends  TestBase{
    String email = "alexwopilowski@hotmail.com";
    String password = "Calligula70";
    String boardName="New Board";

    @Test
    public void testCreationBoardOnTrello(){

        appl.getUser().initLogin();
        appl.getUser().fillLoginForm(new User().withEmail(email).withPassword(password));
        appl.getUser().confirmLogin();
        appl.getUser().createNewBoard(boardName);

        Assert.assertTrue(appl.getUser().isUserLogIn());



    }
}
