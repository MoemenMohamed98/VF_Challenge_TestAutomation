package vf.eshop.stepDefinitions;

import com.vf.eshop.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class E2_eShopSteps {
    private WebDriver driver;
    private Cart_Page CartPage_Obj;
    private CheckOut_Page CheckoutPage_Obj;
    private final SoftAssert softAssert = new SoftAssert();


//    Initialize WebDriver and Page Objects

    @Before
    public void setup(){
        driver = new ChromeDriver();
        CartPage_Obj = new Cart_Page(driver);
        CheckoutPage_Obj = new CheckOut_Page(driver);
    }

    @When("I click on the Cart button")
    public void Click_Cart(){
        CartPage_Obj.Click_On_Cart();
    }

    @Then("I validate that there are products in the cart")
    public void Validate_On_TheAdded_Products() throws IOException {

        // Validate on the presence of the added product at the cart page \\
        softAssert.assertTrue(driver.findElement(By.cssSelector("div[class='cart']")).isDisplayed());

        //Capture a Screenshot for the summary order details\\
        File summaryOrder = driver.findElement(By.cssSelector("div.cart-page")).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(summaryOrder,new File("SummaryOrder.png"));
    }

    @When("I click on the Go to checkout button")
    public void Click_on_CheckoutBtn(){
        CheckoutPage_Obj.Click_CheckoutBtn();
    }

    @When("I click on Add new Address")
    public void Click_on_AddNewAddressBtn(){
        CheckoutPage_Obj.Click_addAddress();
    }

    @When("I set the city, district, and {string}")
    public void Set_City_District_StreetName_Data(String streetName){
        CheckoutPage_Obj.Set_The_NewAddress_Data(streetName);
    }

    @When("I set an invalid {string}, {string}, and {string}")
    public void Set_Invalid_Building_floor_and_Apartment(String Building, String Floor, String Apartment){
        CheckoutPage_Obj.Enter_buildingNo(Building);
        CheckoutPage_Obj.Enter_floorNo(Floor);
        CheckoutPage_Obj.Enter_apartmentNo(Apartment);
    }

    @Then("I validate that the error message is displayed")
    public void Validate_That_Error_Messages_Appear(){

        softAssert.assertTrue(driver.findElement(By.xpath("(//p[@class='error'])[1]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("(//p[@class='error'])[2]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("(//p[@class='error'])[3]")).isDisplayed());

        softAssert.assertEquals(driver.findElement(By.xpath("(//p[@class='error'])[1]")).getText()
                ,"Max characters allowed: 4 ");
    }

    @Then("I see the save address button is dimmed")
    public void Validate_That_theSaveAddress_Btn_is_Dimmed() throws IOException {
        softAssert.assertFalse(driver.findElement(By.className("btn-primary.delievry--btn--checkout")).isEnabled());

                    //Capture a Screenshot for the summary order details\\
        File addressError = driver.findElement(By.className("address-new")).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(addressError,new File("AddressError.png"));
    }


    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot",new ByteArrayInputStream(screenshot));
        }
        driver.quit();
    }












}