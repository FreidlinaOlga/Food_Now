package com.foodnow.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if(!app.getHome().isHomeComponentPresent()){
            app.getHome().clickOnHomePageLogo();
        }

    }

    @Test
    public void homePageTest() {

        Assert.assertTrue(app.getHome().isHomeComponentPresent());
    }
}
