package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class BasePage {

    protected WebDriver driver;
    protected Actions action;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);

    }

    public void click(WebElement element) throws Exception {
        try {
            element.click();
        } catch (Exception e) {
            throw new Exception("No se pudo hacer click en el elemento " + element);
        }
    }

    public boolean isDisplayed(WebElement element) throws Exception {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            throw new Exception("No se pudo encontrar el elemento " + element);
        }
    }

    public String getTitle() throws Exception {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            throw new Exception("No se pudo obtener el titulo del driver");
        }
    }

    public void sendKeys(String inputText, WebElement element) throws Exception {
        try {
            element.sendKeys(inputText);
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new Exception("No se pudo encontrar el elemento");
        }

    }

}