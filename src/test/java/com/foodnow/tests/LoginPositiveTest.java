package com.foodnow.tests;

import com.foodnow.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.foodnow.data.UserData.EMAIL;
import static com.foodnow.data.UserData.PASSWORD;

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
        app.getUser().fillLoginRegisterForm(new User().setEmail(EMAIL).setPassword(PASSWORD));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
    }


}
