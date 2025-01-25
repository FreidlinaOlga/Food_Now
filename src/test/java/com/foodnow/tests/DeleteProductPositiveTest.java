package com.foodnow.tests;

import com.foodnow.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteProductPositiveTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("helcar@food.com").setPassword("123456"));
        app.getUser().clickOnLoginButton();
        app.getHome().clickOnHomePageLogo();
        app.getCart().clickOnAddProductButton();
    }


    @Test(enabled = false)
    public void deleteProductTest() {

        app.getCart().clickOnCartIcon();
        app.getCart().waitAndClickOnDeleteIcon();

        Assert.assertTrue(app.getHome().isElementPresent(By.xpath("//button[contains(text(), \"Go shopping\")]")));
    }

}
