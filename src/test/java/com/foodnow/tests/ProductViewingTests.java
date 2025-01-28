package com.foodnow.tests;

import com.foodnow.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.foodnow.data.UserData.EMAIL;
import static com.foodnow.data.UserData.PASSWORD;


public class ProductViewingTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLogOutButtonPresent()) {
            app.getUser().clickLogOutButton();
            app.getHome().waitAndClickHomePageLogo();
        }
    }

    @Test
    public void productViewingByUnregisteredUserTest() {

        Assert.assertTrue(app.getHome().isElementPresent(By.xpath("//button[@aria-label='Go to page 2']")));
    }

    @Test
    public void productViewingByRegisteredUserTest() {
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail(EMAIL).setPassword(PASSWORD));
        app.getUser().clickOnLoginButton();
        app.getHome().pause(6000);
        app.getHome().waitAndClickHomePageLogo();
        app.getHome().pause(6000);
        Assert.assertTrue(app.getHome().isElementPresent(By.xpath("//button[@aria-label='Go to page 2']")));
    }


    @Test
    public void categoryViewingByUnregisteredUserTest() {
        app.getCart().selectCategory();
        app.getHome().pause(2000);
        Assert.assertEquals(app.getCart().verifyColor(), "rgba(0, 191, 99, 1)");

    }

    @Test
    public void categoryViewingByRegisteredUserTest() {
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail(EMAIL).setPassword(PASSWORD));
        app.getUser().clickOnLoginButton();
        app.getHome().pause(1000);
        app.getHome().waitAndClickHomePageLogo();
        app.getHome().pause(2000);
        app.getCart().selectCategory();
        app.getHome().pause(1000);
        Assert.assertEquals(app.getCart().verifyColor(), "rgba(0, 191, 99, 1)");

    }


}
