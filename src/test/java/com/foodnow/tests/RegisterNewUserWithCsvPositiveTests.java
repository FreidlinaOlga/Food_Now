package com.foodnow.tests;

import com.foodnow.models.User;
import com.foodnow.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterNewUserWithCsvPositiveTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLogOutButtonPresent()) {
            app.getUser().clickLogOutButton();
        }

    }

    @Test(dataProvider = "registerNewUserPositiveWithCsv", dataProviderClass = DataProviders.class)
    public void registerNewUserPositiveWithCsvFileTest(User user) {
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnRegisterLink();
        app.getUser().fillLoginRegisterForm(user);
        app.getUser().clickOnRegistrationButton();
        app.getHome().pause(7000);
        Assert.assertTrue(app.getUser().isLoginButtonPresent());

    }

}
