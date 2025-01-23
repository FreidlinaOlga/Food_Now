package com.foodnow.fw;

import com.foodnow.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void fillLoginRegisterForm(User user) {
        type(By.xpath("//input[@id='firstName-id']"), user.getFirstName());
        type(By.xpath("//input[@id='lastName-id']"), user.getLastName());
        type(By.xpath("//input[@id='email-id']"), user.getEmail());
        type(By.xpath("//input[@id='password-id']"), user.getPassword());
        type(By.xpath("//input[@id='phoneNumber-id']"), user.getPhone());
    }

    public void clickOnRegisterLink() {
        click(By.xpath("//a[contains(text(),'or register')]"));
    }

    public void clickOnUserIcon() {
        click(By.xpath("//*[@id=\"root\"]/div/div/div[1]/nav/a[1]/img"));
    }

    public void enterPassword(String password) {
        type(By.xpath("//input[@id='password-id']"), password);
    }

    public void enterEmail(String email) {
        type(By.xpath("//input[@id='email-id']"), email);
    }

    public void fillLastNameField(String lastName) {
        type(By.xpath("//input[@id='lastName-id']"), lastName);
    }

    public void fillFirstNameField(String firstName) {
        type(By.xpath("//input[@id='firstName-id']"), firstName);
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[.='Registration']"));
    }

    public void enterPhoneNumber(String phone) {
        type(By.xpath("//input[@id='phoneNumber-id']"), phone);
    }

    public boolean isLogOutButtonPresent() {
        return isElementPresent(By.xpath("//button[.='Log out']"));
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='#/login']"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[.='Login']"));
    }
}
