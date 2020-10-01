package pom;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    private String titleHomePage = "Compare Laptops - Latest laptop Comparison by Price, Specification, Features, Performance & Reviews | Gadgets Now";

    @FindBy(id = "tvsearchkey")
    private WebElement firstAddDeviceLocator;

    @FindBy(className = "bl_btn")
    private WebElement btnCompareLocator;

    @FindBy(className = "srchbox")
    private List<WebElement> SecondAddDevices;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSecondAddDevices() {
        return SecondAddDevices.get(1);
    }

    public boolean homePageIsDisplayed() throws Exception {
        return this.getTitle().equals(titleHomePage);
    }

    public void typeFirstDevice(String product) throws Exception {
        this.sendKeys(product, firstAddDeviceLocator);
        firstAddDeviceLocator.sendKeys(Keys.TAB);
    }

    public void typeSecondDevice(String product) throws Exception {
        this.sendKeys(product, getSecondAddDevices());
        this.sendKeys(getSecondAddDevices());

    }

    public void clickOnCompare() throws Exception {
        if (isDisplayed(btnCompareLocator)) {
            this.click(btnCompareLocator);
        }
    }
}
