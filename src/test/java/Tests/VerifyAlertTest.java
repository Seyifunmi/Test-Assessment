package Tests;

import Pages.VerifyAlert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyAlertTest {
    WebDriver driver;

    @BeforeTest
    public void SetUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


    }
    @Test
    public void verifyAlert (){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        VerifyAlert check = new VerifyAlert( driver);

        driver.get("https://demo.seleniumeasy.com/");
        driver.manage().window().maximize();
        boolean present;
        try {
            driver.findElement(By.xpath("//div[@id='at-cv-lightbox-content']/div[@class='at-cv-lightbox-layout-content']"));
            present = true;
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='at-cv-lightbox-content']/div[@class='at-cv-lightbox-layout-content']")));
            check.close_modal();
        } catch (NoSuchElementException e) {
            present = false;
        }

        check.click_alertAndModals();
        check.click_bootstrapAlert();
        check.click_firstAlert();
        //Verify alert text
        WebElement message = driver.findElement(By.xpath("/html/body/div[@class='container-fluid text-center']//div[@class='col-md-6']/div[1]"));
        Assert.assertEquals("I'm an autocloseable success message. I will hide in 5 seconds.", message.getText());


    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
