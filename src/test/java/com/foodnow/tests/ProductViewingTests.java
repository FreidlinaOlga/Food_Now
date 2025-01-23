package com.foodnow.tests;
import com.foodnow.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;




public class ProductViewingTests extends TestBase{

    @Test
    public void productViewingByUnregisteredUserTest(){
        Assert.assertTrue(app.getHome().isElementPresent(By.xpath("//button[@aria-label='Go to page 2']")));
    }

    @Test
    public void productViewingByRegisteredUserTest(){
        app.getUser().clickOnUserIcon();
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("tl49@gmx.com").setPassword("TestProba1$"));
        app.getUser().clickOnLoginButton();
        app.getHome().pause(1000);
        app.getHome().clickOnHomePageLogo();

        Assert.assertTrue(app.getHome().isElementPresent(By.xpath("//button[@aria-label='Go to page 2']")));
    }


    @Test
    public void categoryViewingByUnregisteredUserTest(){
        app.getCart().selectCategory();

       Assert.assertEquals(app.getCart().verifyColor(), "rgba(128, 128, 128, 1)");

   }

   @Test
    public void categoryViewingByRegisteredUserTest(){
       app.getUser().clickOnUserIcon();
       app.getUser().clickOnLoginLink();
       app.getUser().fillLoginRegisterForm(new User().setEmail("tl49@gmx.com").setPassword("TestProba1$"));
       app.getUser().clickOnLoginButton();
       app.getHome().pause(1000);
       app.getHome().clickOnHomePageLogo();
       app.getCart().selectCategory();
       app.getHome().pause(1000);
       Assert.assertEquals(app.getCart().verifyColor(), "rgba(0, 191, 99, 1)");

   }






}
