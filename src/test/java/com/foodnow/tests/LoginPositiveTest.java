package com.foodnow.tests;

import com.foodnow.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPositiveTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLogOutButtonPresent()) {
            app.getUser().clickLogOutButton();
        }
    }
    @Test
    public void loginPositiveTest() {

        app.getUser().clickOnUserIcon();
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("tl49@gmx.com").setPassword("TestProba1$"));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
    }


}
