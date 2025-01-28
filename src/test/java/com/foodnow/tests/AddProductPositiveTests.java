package com.foodnow.tests;

import com.foodnow.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.foodnow.data.UserData.EMAIL;
import static com.foodnow.data.UserData.PASSWORD;

public class AddProductPositiveTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogOutButtonPresent()) {
          app.getUser().clickLogOutButton();
       }
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail(EMAIL).setPassword(PASSWORD));
        app.getUser().clickOnLoginButton();
    }


    @Test
    public void addProductTest() {

        app.getHome().waitAndClickHomePageLogo();
        app.getCart().clickOnAddProductButton();

        Assert.assertTrue(app.getHome().isElementPresent(By.cssSelector(".Toastify__toast-body > div:nth-child(2)")));
    }




}
