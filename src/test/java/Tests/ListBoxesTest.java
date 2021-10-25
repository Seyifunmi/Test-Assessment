package Tests;

import Pages.ListBoxes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ListBoxesTest {
    WebDriver driver;

    @BeforeTest
    public void SetUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @Test
    public void ListBoxesTest(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        ListBoxes search = new ListBoxes(driver);
        driver.get("https://demo.seleniumeasy.com/");
        driver.manage().window().maximize();
        boolean present;
        try {
            driver.findElement(By.xpath("//div[@id='at-cv-lightbox-content']/div[@class='at-cv-lightbox-layout-content']"));
            present = true;
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='at-cv-lightbox-content']/div[@class='at-cv-lightbox-layout-content']")));
            search.close_modal();
        } catch (NoSuchElementException e) {
            present = false;
        }
        search.clickListBox();
        search.click_dataListFilter();
        search.input_search("manager");

        //Verify Search Result
        List <WebElement> results = driver.findElements(By.cssSelector(".searchable-container"));

        for (int i = 0; i < results.size(); i++) {

            var tn = results.get(i).getText();
            Assert.assertTrue(tn.contains("Manager"), "Search validation failed");


        }

    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
