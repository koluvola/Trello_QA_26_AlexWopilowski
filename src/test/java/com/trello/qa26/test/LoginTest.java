package com.trello.qa26.test;

import com.trello.qa26.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTest extends TestBase {
    //alexwopilowski@hotmail.com
    //Calligula70
    // String email = "alexwopilowski@hotmail.com";
    //String email;
    //String password = "Calligula70";
    //String password = "";
    String pathToFile = "src/test/screenSHots/screenShot-";
    int time=10;

    @BeforeMethod
    public void ensurePreconditions() {
        //if user logged in, logout
        // appl.getUserHelper().isUserLoggedIn()
        if (appl.getUser().isAvatarPresent()) {
            appl.getUser().clickLogoutButtonOnHeader();
            appl.getUser().clickByCssSelector("[class='global-header-section-button']");
        }
    }

    @Test
    public void testAtlassianUserLogin() {
        String password = "Calligula70";
        String email = "alexwopilowski@hotmail.com";

        if (!appl.getUser().isElementPresent(By.cssSelector("[class='_24AWINHReYjNBf aYXvcYtXemTcSj']"))) {
            logger.info("Email: " + email);
            logger.info("Password: " + password);
            appl.getUser().initLogin();
            appl.getUser().fillLoginForm(new User().withEmail(email).withPassword(password),time);
            appl.getUser().confirmLogin();

            Assert.assertTrue(appl.getUser().isAvatarPresent());
            logger.info("Test past\n");
            appl.getUser().takeScreenShot(pathToFile);
        }
        appl.getUser().initLogin();
        appl.getUser().fillLoginForm(new User().withEmail(email).withPassword(password),time);
        appl.getUser().confirmLogin();

          Assert.assertTrue(appl.getUser().isAvatarPresent());

    }

    @Test(enabled = false, dataProvider = "validLogin")
    public void testAtlassianUserLoginDataProvider(String email, String password) {
        //[class='global-header-section-button mod-primary']
        if (!appl.getUser().isElementPresent(By.cssSelector("[class='_24AWINHReYjNBf aYXvcYtXemTcSj']"))) {
            logger.info("Email: " + email);
            logger.info("Password: " + password);
            appl.getUser().initLogin();
            appl.getUser().fillLoginForm(new User().withEmail(email).withPassword(password), time);
            appl.getUser().confirmLogin();

            Assert.assertTrue(appl.getUser().isAvatarPresent());
            logger.info("Test past\n");
            appl.getUser().takeScreenShot(pathToFile);
        }
        appl.getUser().initLogin();
        appl.getUser().fillLoginForm(new User().withEmail(email).withPassword(password),time);
        appl.getUser().confirmLogin();

          Assert.assertTrue(appl.getUser().isAvatarPresent());

    }

    @Test(enabled = false,dataProvider = "validLoginFromCSV")
    public void testAtlassianUserLoginDataProviderFromCSVFile(User user) {
        if (!appl.getUser().isElementPresent(By.cssSelector("[class='_24AWINHReYjNBf aYXvcYtXemTcSj']"))) {
            logger.info("Email: " + user.getEmail());
            logger.info("Password: " + user.getPassword());
            appl.getUser().initLogin();
            appl.getUser().fillLoginForm(user,time);
            appl.getUser().confirmLogin();
            Assert.assertTrue(appl.getUser().isAvatarPresent());
            logger.info("Test past\n");
            appl.getUser().takeScreenShot(pathToFile);
        }
    }
   /* @Test
    public void testUserLoginRegular(User user) {
        if (!appl.getUser().isElementPresent(By.cssSelector("[class='_24AWINHReYjNBf aYXvcYtXemTcSj']"))) {
            logger.info("Email: " + user.getEmail());
            logger.info("Password: " + user.getPassword());
            appl.getUser().initLogin();
            appl.getUser().fillLoginForm(user);
            appl.getUser().confirmLogin();
            Assert.assertTrue(appl.getUser().isAvatarPresent());
            logger.info("Test past\n");
            appl.getUser().takeScreenShot(pathToFile);
        }
    }*/

    @DataProvider
    public Iterator<Object[]> validLogin() {
       /* list.add(new object[]{"my.email1608815240039@gmail.com","iL12345678"});
        list.add(new object[]{"my.email1608821574952@gmail.com","iL12345678"});
        list.add(new object[]{"my.email1608815551767@gmail.com","iL12345678"});*/
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"alexwopilowski@hotmail.com", "Calligula70"});
        list.add(new Object[]{"alexwopilowski@hotmail.com", "Calligula70"});
        list.add(new Object[]{"alexwopilowski@hotmail.com", "Calligula70"});
        list.add(new Object[]{"alexwopilowski@hotmail.com", "Calligula70"});
        /*list.add(new Object[]{"my.email1608821574952@gmail.com", "iL12345678"});
        list.add(new Object[]{"my.email1608815551767@gmail.com", "iL12345678"});*/
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validLoginFromCSV() {
        List<Object[]> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/validLoginCSV.csv")));
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return list.iterator();
    }
}
