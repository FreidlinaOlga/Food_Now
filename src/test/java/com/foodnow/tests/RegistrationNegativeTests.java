package com.foodnow.tests;


import com.foodnow.models.User;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.foodnow.data.RegistrationData.*;


public class RegistrationNegativeTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLogOutButtonPresent()) {
            app.getUser().clickLogOutButton();
        }
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnRegisterLink();
    }

    @Test
    public void existedUserRegistrationNegativeTest() {


        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName(NAME)
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setPassword(PASSWORD)
                .setPhone(PHONE));

        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text(),'Registration failed. Request failed with status co')]")));

    }

    @Test
    public void emptyEmailFieldRegistrationNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName(NAME)
                .setLastName(LAST_NAME)
                .setPassword(PASSWORD)
                .setPhone(PHONE));


        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[text()='Email is required']")));

    }

    @Test
    public void numbersInEmailFieldRegistrationNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName(NAME)
                .setLastName(LAST_NAME)
                .setEmail("1234567")
                .setPassword(PASSWORD)
                .setPhone(PHONE));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[text()='Email is not valid']")));

    }

    @Test
    public void invalidFirstNameRegistrationNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName("SQL")
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setPassword(PASSWORD)
                .setPhone(PHONE));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text(), 'Registration failed')]")));
    }

    @Test
    public void emptyFirstNameFieldRegistrationNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setPassword(PASSWORD)
                .setPhone(PHONE));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[text()='First name field is required']")));
    }


    @Test
    public void longFirstNameRegistrationNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName("qwertzuiopüasdfghjklöä")
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setPassword(PASSWORD)
                .setPhone(PHONE));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[@class=\"css-j1mlt7\"]")));
    }

    @Test
    public void longLastNameRegistrationNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName(NAME)
                .setLastName("Cartermnbvcxyölkjhgfds")
                .setEmail(EMAIL)
                .setPassword(PASSWORD)
                .setPhone(PHONE));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[@class=\"css-j1mlt7\"]")));
    }

    @Test
    public void invalidPasswordRegistrationNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName(NAME)
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setPassword("123")
                .setPhone(PHONE));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[@class=\"css-j1mlt7\"]")));
    }

    @Test
    public void invalidPhoneRegistrationNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName(NAME)
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setPassword(PASSWORD)
                .setPhone("2323"));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[@class=\"css-j1mlt7\"]")));
    }


}
