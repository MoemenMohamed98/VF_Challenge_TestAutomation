package com.vf.eshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home_Page {

private final WebDriver driver;
private final By userProfile_btn = By.id("userProfileMenu");
private final By Search_Bar = By.id("searchInput");
private final By Search_List = By.cssSelector("div.search-results.desktop-search-results");
private final By Samsung_SmartPhones = By.xpath("//div[3]/div/div/p[2]");  // (//div[@class='category-result'])[2]
private final By Cookies_Popup = By.cssSelector("div[id='onetrust-banner-sdk']");
private final By AcceptCookies_Btn = By.cssSelector("button[id='onetrust-accept-btn-handler']");



    public Home_Page(WebDriver driver) {this.driver = driver;}

    public void Click_on_Profile_Menu(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Handling The cookies Settings
        wait.until(ExpectedConditions.visibilityOfElementLocated(Cookies_Popup));
        driver.findElement(AcceptCookies_Btn).click();

        wait.until(ExpectedConditions.elementToBeClickable(userProfile_btn));
        driver.findElement(userProfile_btn).click();
    }
    public void Search_For_Product(String productName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Search_Bar));
        driver.findElement(Search_Bar).sendKeys(productName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Search_List));
        wait.until(ExpectedConditions.elementToBeClickable(Samsung_SmartPhones));
        driver.findElement(Samsung_SmartPhones).click();
    }



}
