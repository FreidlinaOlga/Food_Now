package com.foodnow.tests;

import com.foodnow.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsingCartNegativeTest extends TestBase{

@Test
    public void usingCartByUnloggedUserTest(){
    app.getCart().clickOnCartIcon();

    Assert.assertTrue(app.getHome().isElementPresent(By.xpath("//main//p")));
}
@Test
    public void addProductToCartByUnloggedUserTest(){
    app.getCart().clickOnAddProductButton();
    Assert.assertTrue(app.getHome().isElementPresent(By.xpath("//p[contains(text(), 'You are not logged in')]")));
}
@Test
    public void usingEmptyCartByLoggedUserTest(){
    app.getUser().clickOnUserIcon();
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegisterForm(new User().setEmail("tl49@gmx.com").setPassword("TestProba1$"));
    app.getUser().clickOnLoginButton();
    app.getCart().clickOnCartIcon();
Assert.assertTrue(app.getHome().isElementPresent(By.xpath("//button[text()='Go shopping']")));

}
}
