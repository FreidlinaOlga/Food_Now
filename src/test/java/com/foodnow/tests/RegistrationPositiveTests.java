package com.foodnow.tests;

import com.foodnow.models.User;
import com.foodnow.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.foodnow.data.RegistrationData.*;

public class RegistrationPositiveTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLogOutButtonPresent()) {
            app.getUser().clickLogOutButton();
        }
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnRegisterLink();

    }


    @Test(enabled = false)
    public void registrationPositiveTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName(NAME)
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setPassword(PASSWORD)
                .setPhone(PHONE));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isLogOutButtonPresent());

    }


    @Test(dataProvider = "registerNewUserWithCsv", dataProviderClass = DataProviders.class)
    public void registerNewUserPositiveFromDataProviderWithCsvFileTest(User user) {

        app.getUser().clickOnRegisterLink();
        app.getUser().fillLoginRegisterForm(user);
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isUserRegistered());

    }

}
