package com.foodnow.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartAndProductHelper extends BaseHelper{

    public CartAndProductHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnCartIcon() {
        click(By.xpath("//nav[1]/a[2]/img"));
    }

    public void waitAndClickOnDeleteIcon() {
        clickWithWait(By.cssSelector("div:nth-of-type(4) button > svg > path"));

    }
    public void waitAndClickOnAddProductButton() {
        clickWithWait(By.cssSelector("#root .css-1urp7g4 button img"));

    }

    public void clickOnGoShoppingButton() {
        click(By.cssSelector("#root > div > main > div > div.css-1wo8pw5 > div > button"));
    }

    public void clickOnAddProductButton() {
        click(By.cssSelector("#root .css-1urp7g4 button img"));
    }

    public void selectCategory() {
        click(By.cssSelector(".css-qzqyzm button:nth-child(10)"));
    }
    public String verifyColor() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector(".css-qzqyzm button:nth-child(10)")));
        String cssValue = element.getCssValue("color");
        System.out.println("****************************************************");
        System.out.println(cssValue);
        System.out.println("*******************************************************");
        return cssValue;
    }


    public void waitAndClickOnCartIcon() {
        clickWithWait(By.xpath("//nav[1]/a[2]/img"));
    }
}

