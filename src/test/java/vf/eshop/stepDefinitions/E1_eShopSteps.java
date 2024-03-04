package vf.eshop.stepDefinitions;

import com.vf.eshop.pages.Cart_Page;
import com.vf.eshop.pages.Home_Page;
import com.vf.eshop.pages.Login_Page;
import com.vf.eshop.pages.SmartPhones_Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class E1_eShopSteps {
    private WebDriver driver;
    private Login_Page LoginPage_Obj;
    private Home_Page HomePage_Obj;
    private SmartPhones_Page SmartPhonesPage_Obj;
    private Cart_Page CartPage_Obj;
    private final SoftAssert softAssert = new SoftAssert();


    public class CustomParameterTypes {
        @ParameterType(".*")
        public String string(String value) {
            return value;
        }}


//    Initialize WebDriver and Page Objects

    @Before
    public void setup(){
        driver = new ChromeDriver();
        LoginPage_Obj = new Login_Page(driver);
        HomePage_Obj = new Home_Page(driver);
        SmartPhonesPage_Obj = new SmartPhones_Page(driver);
        CartPage_Obj = new Cart_Page(driver);
    }

    @Given("I'm on the Vodafone eShop homepage")
    public void navigateToVodafoneEShopHomepage() {
        driver.manage().window().maximize();
        driver.get("https://eshop.vodafone.com.eg/");
        HomePage_Obj.Click_on_Profile_Menu();
    }


    @Given("I'm logged in to Vodafone eShop With username and password")
    public void VF_eShop_Login(){
        LoginPage_Obj.eShop_Login("01001064285", "@M0hamed123");
    }

    @When("I search for productName and select Samsung in Smart Phones from the search list")
    public void Search_And_SelectProduct(){
        HomePage_Obj.Search_For_Product("samsung");
    }

    @When("I select the first available product from the OPPO Tab")
    public void Select_First_Product_From_OPPoTab() {
        SmartPhonesPage_Obj.Select_OppoTab();
        SmartPhonesPage_Obj.Select_FirstProduct();
    }

    @Then("I check the status of each color in the product")
    public void Check_Product_colors_Status(){
        SmartPhonesPage_Obj.Select_The_FirstColor();

        // Validate on the first color of the product is available => Add to Cart Btn will be Enabled//
        Assert.assertNotEquals(driver.findElement(By.xpath("//div/div[3]/p")).getText(),"Out Of Stock");
        Assert.assertTrue(driver.findElement(By.cssSelector("button.add-to-cart")).isEnabled());

        SmartPhonesPage_Obj.Select_The_SecColor();
        // Validate on the first color of the product is available => Add to Cart Btn will be Enabled//
        Assert.assertNotEquals(driver.findElement(By.xpath("//div/div[3]/p")).getText(),"Out Of Stock");
        Assert.assertTrue(driver.findElement(By.cssSelector("button.add-to-cart")).isEnabled());
    }

    @Then("I add the product to cart if it is available in stock")
    public void Add_To_Cart_IfAvailableInStock() throws IOException {
                 //Capture a Screenshot for the product details\\
        File src = driver.findElement(By.cssSelector("div.product-details-container")).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("ProductDetails.png"));
        SmartPhonesPage_Obj.Click_On_AddToCart();
    }

    @Then("The product should be successfully added to the cart")
    public void Product_Added_To_Cart() throws IOException {
        CartPage_Obj.ShowCart_Updated();
//        softAssert.assertEquals(driver.findElement(By.cssSelector("div.system-alert>p")).getText(),
//                "Item Added To Cart Successfully!");

                    // Validate on the cart that is displayed the number of the added product \\
        softAssert.assertTrue(driver.findElement(By.cssSelector("button.cart-btn>span")).isDisplayed());

        CartPage_Obj.Click_On_Cart();

                    // Validate on the presence of the added product at the cart page \\
        softAssert.assertTrue(driver.findElement(By.cssSelector("div[class='cart']")).isDisplayed());

                       //Capture a Screenshot for the summary order details\\
        File summaryOrder = driver.findElement(By.cssSelector("div.cart-page")).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(summaryOrder,new File("SummaryOrder.png"));
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
