package com.vf.eshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SmartPhones_Page {

    private final WebDriver driver;
    private final By Category_Tabs = By.cssSelector("div.category-tabs-section");
    private final By OPPO_Tab = By.xpath("//div/div[2]/div[2]/div[9]");         //  div.category-tabs-section>div.tab:nth-child(9)
    private final By First_Product = By.xpath("(//div[@class='product-card'])[1]");
    private final By First_color = By.xpath("//div/div[1]/div[3]/div[4]/div/div/button[1]");      //  div.color-switcher-desktop>button:nth-child(1)
    private final By Second_color = By.xpath("//div/div[1]/div[3]/div[4]/div/div/button[2]");     //  div.color-switcher-desktop>button:nth-child(2)
    private final By AddToCart_Btn = By.cssSelector("button.add-to-cart");




    public SmartPhones_Page(WebDriver driver){
        this.driver = driver;
    }

    public void Select_OppoTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Category_Tabs));
        wait.until(ExpectedConditions.elementToBeClickable(OPPO_Tab));
        driver.findElement(OPPO_Tab).click();
    }

    public void Select_FirstProduct(){
         new WebDriverWait(driver, Duration.ofSeconds(5))
                 .until(ExpectedConditions.presenceOfElementLocated(First_Product));

//        new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.elementToBeClickable(First_Product));
        driver.findElement(First_Product).click();
    }

    public void Select_The_FirstColor(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(First_color));
        driver.findElement(First_color).click();
    }

    public void Select_The_SecColor(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(Second_color));
        driver.findElement(Second_color).click();
    }
    public void Click_On_AddToCart(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(AddToCart_Btn));
        driver.findElement(AddToCart_Btn).click();
    }






}
