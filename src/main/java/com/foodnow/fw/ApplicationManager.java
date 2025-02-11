package com.foodnow.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager {
    String browser;
    public WebDriver driver;

    UserHelper user;
    CartAndProductHelper cart;
    HomePageHelper home;



    public ApplicationManager(String browser) {
        this.browser=browser;
    }

    public void init() {

            if(browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();

            }else if(browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();

            }else if(browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
;
          }

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
