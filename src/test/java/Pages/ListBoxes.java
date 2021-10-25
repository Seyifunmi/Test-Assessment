package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListBoxes {
    By modal = By.xpath("/html//a[@id='at-cv-lightbox-close']");
    By listBox = By.xpath("//ul[@id='treemenu']/li/ul/li[6]/a[@href='#']");
    By dataListFilter = By.xpath("//ul[@id='treemenu']/li/ul/li[6]/ul//a[@href='./data-list-filter-demo.html']");
    By searchField = By.xpath("/html//input[@id='input-search']");

    WebDriver driver = null;

    public ListBoxes (WebDriver driver){
        this.driver = driver;

    }

    public void close_modal(){

        driver.findElement(modal).click();
    }

    public void clickListBox (){

        driver.findElement(listBox).click();
    }
    public void click_dataListFilter (){

        driver.findElement(dataListFilter).click();
    }
    public void input_search (String text){
        driver.findElement(searchField).sendKeys(text);
    }



}
