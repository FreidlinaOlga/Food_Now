package com.foodnow.tests;

import com.foodnow.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.foodnow.data.UserData.EMAIL;
import static com.foodnow.data.UserData.PASSWORD;

public class UsingCartNegativeTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLogOutButtonPresent()) {
            app.getUser().clickLogOutButton();
        }
        app.getHome().waitAndClickHomePageLogo();
    }

@Test
    public void usingCartByUnloggedUserTest(){
    app.getCart().clickOnCartIcon();

    Assert.assertTrue(app.getHome().isElementPresent(By.xpath("//main//p")));
}
@Test(enabled = false)
    public void addProductToCartByUnloggedUserTest(){

    app.getCart().clickOnAddProductButton();

    Assert.assertTrue(app.getHome().isElementPresent(By.xpath("//p[contains(text(), 'You are not logged in')]")));
}
@Test
    public void usingEmptyCartByLoggedUserTest(){

    app.getUser().clickOnUserIcon();
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegisterForm(new User().setEmail(EMAIL).setPassword(PASSWORD));
    app.getUser().clickOnLoginButton();
    app.getCart().waitAndClickOnCartIcon();
app.getHome().pause(6000);
    Assert.assertTrue(app.getHome().isElementPresent(By.xpath("//button[text()='Go shopping']")));

}
}
