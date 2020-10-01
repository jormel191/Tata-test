package pom;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private String titleHomePage = "Compare Laptops - Latest laptop Comparison by Price, Specification, Features, Performance & Reviews | Gadgets Now";

    @FindBy(id = "tvsearchkey")
    private WebElement firstAddDeviceLocator;

    @FindBy(className = "bl_btn")
    private WebElement btnCompareLocator;


    public HomePage(WebDriver driver) {
        super(driver);

    }

    public boolean homePageIsDisplayed() throws Exception {

        return this.getTitle().equals(titleHomePage);
    }

    public void typeFirstDevice(String product) throws Exception {
        this.sendKeys(product, firstAddDeviceLocator);
        firstAddDeviceLocator.sendKeys(Keys.TAB);
    }


    public void typeSecondDevice(String product) throws Exception {
        WebElement SecondAddDevices = driver.findElements(By.className("srchbox")).get(1);
        this.sendKeys(product, SecondAddDevices);
        SecondAddDevices.sendKeys(Keys.TAB);

    }

    public void clickOnCompare() throws Exception {
        if (isDisplayed(btnCompareLocator)) {
            this.click(btnCompareLocator);
        }
    }
}
