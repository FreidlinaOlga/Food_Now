package com.foodnow.tests;

import com.foodnow.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationPositiveTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLogOutButtonPresent()) {
            app.getUser().clickLogOutButton();
        }
    }


    @Test(enabled = false)
    public void registrationPositiveTest() {
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnRegisterLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName("Helena")
                .setLastName("Carter")
                .setEmail("helcar@food.com")
                .setPassword("123456")
                .setPhone("232323"));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isLogOutButtonPresent());

    }

}
