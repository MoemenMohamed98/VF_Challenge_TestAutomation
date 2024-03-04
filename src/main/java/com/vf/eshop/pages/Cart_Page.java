package com.vf.eshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart_Page {

    private final WebDriver driver;
    private final By Show_Cart = By.xpath("//img[@alt='shopping trolly']");
    private final By Summary_Cart = By.cssSelector("div.cart-page");


    public Cart_Page(WebDriver driver) {
        this.driver = driver;
    }
    public void ShowCart_Updated(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(Show_Cart));


        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.cart-btn>span")));

    }

    public void Click_On_Cart(){

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-bar']")));

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(Show_Cart));

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(Show_Cart));

        driver.findElement(Show_Cart).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(Summary_Cart));
    }
}
