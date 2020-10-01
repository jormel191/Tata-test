package seleniumgluecode;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;


public class test extends TestBase {
    @Given("user is on the page Gadget snow")
    public void UserIsOnPage() throws Exception {
        Assert.assertTrue(homePage.homePageIsDisplayed());

    }

    @When("User selects two pc to compare {string} and {string}")
    public void comparePc(String product1, String product2) throws Exception {
        homePage.typeFirstDevice(product1);
        homePage.typeSecondDevice(product2);
        homePage.clickOnCompare();
    }


    @Then("User is redirected to the result page")
    public void RedirectSection() throws Exception {
        resultPage.resultPageIsDisplayed();
    }

    @Then("User extracts summary information to the Excel file")
    public void exportInformation() throws Exception {
        resultPage.writeExcel();
    }
}




