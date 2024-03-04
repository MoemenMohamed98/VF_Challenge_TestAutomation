package com.vf.eshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOut_Page {

    private final WebDriver driver;
    private final By Checkout_Btn =By.xpath("(//button[@class='checkout-btn'])[1]");
    private final By AddAddress_Btn = By.cssSelector("div.add-address");
    private final By Address_List = By.className("address-new");
    private final By Select_City = By.xpath("(//div[@class='form-select-box'])[1]");
    private final By Select_District = By.xpath("(//div[@class='form-select-box'])[2]");
    private final By StreetName_Text = By.cssSelector("input[formcontrolname='streetName']");
    private final By Building_Number = By.cssSelector("input[formcontrolname='buildingNo']");
    private final By Floor_Number = By.cssSelector("input[formcontrolname='floorNo']");
    private final By Apartment_Number = By.cssSelector("input[formcontrolname='appartmentNo']");




    public CheckOut_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void Click_CheckoutBtn(){
        driver.findElement(Checkout_Btn).click();
    }

    public void Click_addAddress(){

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(AddAddress_Btn));
        driver.findElement(AddAddress_Btn).click();
    }

    public void Set_The_NewAddress_Data(String streetName){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(Address_List));

              //// Select the city\\\\
        WebElement city = driver.findElement(Select_City);
        Select select_city = new Select(city);
        select_city.selectByVisibleText("Alexandria");
               //// Select the district\\\\
        WebElement district = driver.findElement(Select_District);
        Select select_district = new Select(district);
        select_district.selectByVisibleText("Seyouf");

        driver.findElement(StreetName_Text).sendKeys(streetName);
    }

    public void Enter_buildingNo(String buildingNo){
        driver.findElement(Building_Number).sendKeys(buildingNo);
    }

    public void Enter_floorNo(String floorNo){
        driver.findElement(Building_Number).sendKeys(floorNo);
    }

    public void Enter_apartmentNo(String apartmentNo){
        driver.findElement(Apartment_Number).sendKeys(apartmentNo);
    }




}
