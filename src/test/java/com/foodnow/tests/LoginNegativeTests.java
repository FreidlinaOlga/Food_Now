package com.foodnow.tests;

import com.foodnow.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.foodnow.data.UserData.EMAIL;
import static com.foodnow.data.UserData.PASSWORD;

public class LoginNegativeTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLogOutButtonPresent()) {
            app.getUser().clickLogOutButton();
        }
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnLoginLink();
    }


    @Test
    public void wrongEmailLoginNegativeTest() {

        app.getUser()
                .fillLoginRegisterForm(new User()
                        .setEmail("tl49@gmx.")
                        .setPassword(PASSWORD));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[text()='Login or email is invalid. Try again.']")));
    }


    @Test
    public void wrongPasswordLoginNegativeTest() {

        app.getUser()
                .fillLoginRegisterForm(new User()
                        .setEmail(EMAIL)
                        .setPassword("TestP"));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[text()='Login or email is invalid. Try again.']")));
    }
    @Test
    public void emptyEmailFieldLoginNegativeTest() {

        app.getUser()
                .fillLoginRegisterForm(new User()
                        .setPassword(PASSWORD));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[@class=\"css-j1mlt7\"]")));
    }

    @Test
    public void emptyPasswordFieldLoginNegativeTest() {

        app.getUser()
                .fillLoginRegisterForm(new User()
                        .setEmail(EMAIL));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser()
                .isElementPresent(By.xpath("//div[@class=\"css-j1mlt7\"]")));
    }
}
