package com.foodnow.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }
    public boolean isHomeComponentPresent() {
        return isElementPresent(By.xpath("//button[@aria-label='Go to page 2']"));
    }

    public void clickOnHomePageLogo() {
        click(By.xpath("//img[@class='css-rbpvgo']"));
    }
}
