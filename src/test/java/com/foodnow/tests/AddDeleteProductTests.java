package com.foodnow.tests;

import com.foodnow.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddDeleteProductTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("helcar@food.com").setPassword("123456"));
        app.getUser().clickOnLoginButton();

    }

    @Test
    public void addProductTest() {
        app.getHome().pause(1000);
        app.getHome().clickOnHomePageLogo();
        app.getCart().clickOnAddProductButton();
        app.getHome().pause(1500);
        Assert.assertTrue(app.getHome().isElementPresent(By.cssSelector(".Toastify__toast-body > div:nth-child(2)")));
    }




    @Test
    public void deleteProductTest() {

        app.getCart().clickOnCartIcon();
        app.getCart().clickOnDeleteIcon();
        Assert.assertTrue(app.getHome().isElementPresent(By.xpath("//p[contains(text(),'Your cart is empty')]")));
//        Assert.assertTrue((isElementPresent(By.xpath("#root > div > main > div > div.css-1wo8pw5 > div > button"))));
    }


}
