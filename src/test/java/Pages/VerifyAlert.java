package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VerifyAlert {
    By modal = By.xpath("/html//a[@id='at-cv-lightbox-close']");
    By alertAndModals = By.xpath("//ul[@id='treemenu']/li/ul/li[5]/a[@href='#']");
    By bootstrapAlert = By.xpath ("//ul[@id='treemenu']/li/ul/li[5]/ul//a[@href='./bootstrap-alert-messages-demo.html']");
    By firstAlert = By.xpath("/html//button[@id='autoclosable-btn-success']");


    WebDriver driver = null;


    public VerifyAlert (WebDriver driver){
        this.driver = driver;

    }

    public void close_modal(){

        driver.findElement(modal).click();
    }

    public void click_alertAndModals(){

        List<WebElement> elements = driver.findElements(alertAndModals);
        elements.get(0).click();

    }

    public void click_bootstrapAlert(){

        driver.findElement(bootstrapAlert).click();

    }

    public void click_firstAlert(){

        driver.findElement(firstAlert).click();
    }




}
