package com.foodnow.tests;


import com.foodnow.models.User;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnRegisterLink();
    }

    @Test(enabled = false)
    public void registrationPositiveTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName("Helena")
                .setLastName("Carter")
                .setEmail("helcar@food.com")
                .setPassword("123456")
                .setPhone("232323"));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isLogOutButtonPresent());

    }


    @Test
    public void existedUserRegistrationNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName("Helena")
                .setLastName("Carter")
                .setEmail("helcar@food.com")
                .setPassword("123456")
                .setPhone("232323"));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text(),'Registration failed. Request failed with status co')]")));

    }

    @Test
    public void emptyEmailFieldRegistrationNegativeTest() {
        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName("Helena")
                .setLastName("Carter")
                .setPassword("123456")
                .setPhone("232323"));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[text()='Email is required']")));

    }

    @Test
    public void numbersInEmailFieldRegistrationNegativeTest() {
        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName("Helena")
                .setLastName("Carter")
                .setEmail("1234567")
                .setPassword("123456")
                .setPhone("232323"));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[text()='Email is not valid']")));

    }

    @Test
    public void invalidNameInFirstNameFieldRegistrationNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName("SQL")
                .setLastName("Carter")
                .setEmail("helcar@food.com")
                .setPassword("123456")
                .setPhone("232323"));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text(), 'Registration failed')]")));
    }

    @Test
    public void emptyFirstNameFieldRegistrationNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setLastName("Carter")
                .setEmail("helcar@food.com")
                .setPassword("123456")
                .setPhone("232323"));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[text()='First name field is required']")));
    }


    @Test
    public void longFirstNameRegistrationNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName("qwertzuiopüasdfghjklöä")
                .setLastName("Carter")
                .setEmail("helcar@food.com")
                .setPassword("123456")
                .setPhone("232323"));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[@class=\"css-j1mlt7\"]")));
    }

    @Test
    public void longLastNameRegistrationNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName("Henry")
                .setLastName("Cartermnbvcxyölkjhgfds")
                .setEmail("helcar@food.com")
                .setPassword("123456")
                .setPhone("232323"));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[@class=\"css-j1mlt7\"]")));
    }

    @Test
    public void invalidPasswordRegistrationNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName("Henry")
                .setLastName("Carter")
                .setEmail("helcar@food.com")
                .setPassword("123")
                .setPhone("232323"));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[@class=\"css-j1mlt7\"]")));
    }

    @Test
    public void invalidPhoneRegistrationNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User()
                .setFirstName("Henry")
                .setLastName("Carter")
                .setEmail("helcar@food.com")
                .setPassword("123456")
                .setPhone("2323"));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[@class=\"css-j1mlt7\"]")));
    }


}
