package com.foodnow.tests;

import com.foodnow.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductPositiveTests extends TestBase {

    @BeforeMethod
    public void precondition() {
//        if (app.getUser().isLogOutButtonPresent()) {
//            app.getUser().clickLogOutButton();
//        }
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("helcar@food.com").setPassword("123456"));
        app.getUser().clickOnLoginButton();
    }


    @Test
    public void addProductTest() {

        app.getHome().waitAndClickHomePageLogo();
        app.getCart().clickOnAddProductButton();

        Assert.assertTrue(app.getHome().isElementPresent(By.cssSelector(".Toastify__toast-body > div:nth-child(2)")));
    }




}
