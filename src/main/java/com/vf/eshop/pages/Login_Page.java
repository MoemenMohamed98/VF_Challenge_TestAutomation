package com.vf.eshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_Page {

    private final WebDriver driver;
    private final By userName_Text = By.id("username");
    private final By Password_Text = By.id("password");
    private final By Submit_Btn = By.id("submitBtn");



    public Login_Page(WebDriver driver){this.driver = driver;}

    public void eShop_Login (String userName , String password){
        driver.findElement(userName_Text).sendKeys(userName);
        driver.findElement(Password_Text).sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
        wait.until(ExpectedConditions.elementToBeClickable(Submit_Btn));
        driver.findElement(Submit_Btn).click();
    }

}
