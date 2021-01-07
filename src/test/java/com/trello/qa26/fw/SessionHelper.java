package com.trello.qa26.fw;

import com.trello.qa26.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmLogin() {
        clickButton(By.cssSelector("button[id='login-submit'] span[class='css-t5emrf']"));
        delay(1000);

    }

    public void fillLoginForm(User user) {
        type(user.getEmail(), By.cssSelector("#user"));
        delay(2000);
        clickButton(By.cssSelector("[id='login']"));
        delay(2000);
        type(user.getPassword(), By.cssSelector("#password"));
        delay(5000);

    }

    public void initLogin() {
        clickByCssSelector("a[class='btn btn-sm btn-link text-white']");

    }

    public boolean isAvatarPresent() {
        delay(20000);
        return isElementPresent(By.cssSelector("[class='_1FekJJAz6Hu32v']"));
    }
}
