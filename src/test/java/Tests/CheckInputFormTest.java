package Tests;

import Pages.CheckInputFormPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckInputFormTest {

    WebDriver driver;

    @BeforeTest
    public void SetUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void checkInputForm() {

        WebDriverWait wait = new WebDriverWait(driver, 5);

        CheckInputFormPage input = new CheckInputFormPage(driver);
        driver.get("https://demo.seleniumeasy.com/");
        driver.manage().window().maximize();
        boolean present;
        try {
            driver.findElement(By.xpath("//div[@id='at-cv-lightbox-content']/div[@class='at-cv-lightbox-layout-content']"));
            present = true;
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='at-cv-lightbox-content']/div[@class='at-cv-lightbox-layout-content']")));
            input.close_modal();
        } catch (NoSuchElementException e) {
            present = false;
        }

        input.click_inputFormDropdown();
        input.click_simpleDemoDropdown();
        input.enter_messageField("quality assurance");
        input.click_showMessageButton();
        //verify message
         wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("/html//div[@id='easycont']//div[@id='user-message']/label[.='Your Message: ']")));
        WebElement text = driver.findElement(By.xpath("/html//span[@id='display']"));
        System.out.println(text.getText());


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
