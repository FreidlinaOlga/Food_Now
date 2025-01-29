package com.foodnow.tests;

import com.foodnow.models.User;
import com.foodnow.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterNewUserWithCsvNegativeTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLogOutButtonPresent()) {
            app.getUser().clickLogOutButton();
        }
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnRegisterLink();
    }

    @Test(dataProvider = "registerNewUserNegativeEmailWithCsv", dataProviderClass = DataProviders.class)
    public void registerNewUserInvalidEmailNegativeWithCsvFileTest(User user) {

        app.getUser().fillLoginRegisterForm(user);
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isEmailWrong());

    }


    @Test(dataProvider = "registerNewUserNegativeLastNameWithCsv", dataProviderClass = DataProviders.class)
    public void registerNewUserInvalidLastNameNegativeWithCsvFileTest(User user) {

        app.getUser().fillLoginRegisterForm(user);
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isLastNameInvalid());

    }

    @Test(dataProvider = "registerNewUserNegativeNameWithCsv", dataProviderClass = DataProviders.class)
    public void registerNewUserInvalidNameNegativeWithCsvFileTest(User user) {

        app.getUser().fillLoginRegisterForm(user);
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isNameInValid());

    }
    @Test(dataProvider = "registerNewUserNegativePhoneWithCsv", dataProviderClass = DataProviders.class)
    public void registerNewUserInvalidPhoneNegativeWithCsvFileTest(User user) {

        app.getUser().fillLoginRegisterForm(user);
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isPhoneInValid());

    }



}
