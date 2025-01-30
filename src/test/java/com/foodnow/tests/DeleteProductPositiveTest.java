package com.foodnow.tests;

import com.foodnow.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.foodnow.data.UserData.EMAIL;
import static com.foodnow.data.UserData.PASSWORD;

public class DeleteProductPositiveTest extends TestBase {

    @BeforeMethod
    public void preconditions() {

        if (app.getUser().isLogOutButtonPresent()) {
            app.getUser().clickLogOutButton();
        }
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail(EMAIL).setPassword(PASSWORD));
        app.getUser().clickOnLoginButton();

    }


    @Test()
    public void deleteProductTest() {
        app.getHome().pause(6000);
        app.getHome().waitAndClickHomePageLogo();
        app.getCart().clickOnAddProductButton();
        app.getCart().clickOnCartIcon();
        app.getCart().waitAndClickOnDeleteIcon();
        app.getHome().pause(6000);

        Assert.assertTrue(app.getHome().isElementPresent(By.xpath("//button[contains(text(), \"Go shopping\")]")));
    }

}
