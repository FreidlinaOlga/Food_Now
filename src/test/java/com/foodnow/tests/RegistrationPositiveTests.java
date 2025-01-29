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

    }


    @Test(enabled = false)
    public void registrationPositiveTest() {
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnRegisterLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName(NAME)
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setPassword(PASSWORD)
                .setPhone(PHONE));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isLogOutButtonPresent());

    }

<<<<<<< HEAD

=======
>>>>>>> 2b6b3e413895f9e6874e60a46b9c3ca20903e16f
}
