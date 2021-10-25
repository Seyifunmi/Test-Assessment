package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckInputFormPage {
    By modal = By.xpath("/html//a[@id='at-cv-lightbox-close']");
    By inputFormDropdown = By.xpath("//ul[@id='treemenu']/li/ul/li[1]/a[@href='#']");
    By SimpleFormDemo = By.xpath("//ul[@id='treemenu']/li/ul/li[1]/ul//a[@href='./basic-first-form-demo.html']");
    By messageField = By.xpath("/html//input[@id='user-message']");
    By showMessageButton = By.xpath("//form[@id='get-input']/button[@type='button']");

    WebDriver driver = null;

    public CheckInputFormPage(WebDriver driver){
        this.driver = driver;

    }

    public void close_modal(){
        
        driver.findElement(modal).click();
    }

    public void click_inputFormDropdown(){

        List<WebElement> elements = driver.findElements(inputFormDropdown);
        elements.get(0).click();

    }

    public void click_simpleDemoDropdown(){
        driver.findElement(SimpleFormDemo).click();
    }

    public void enter_messageField(String text){
        driver.findElement(messageField).sendKeys(text);
    }

    public void click_showMessageButton(){
        driver.findElement(showMessageButton).click();
    }


}
