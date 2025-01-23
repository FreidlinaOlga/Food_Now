package com.foodnow.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    UserHelper user;
    CartAndProductHelper cart;
    HomePageHelper home;


    public WebDriver driver;

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://oyster-app-hck73.ondigitalocean.app/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        cart = new CartAndProductHelper(driver);
        home = new HomePageHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public CartAndProductHelper getCart() {
        return cart;
    }

    public HomePageHelper getHome() {
        return home;
    }
}
