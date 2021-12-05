package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class OrderHistoryStepDefs extends AbstractStepDefs {

    @When("the Order History button is clicked")
    public void theOrderHistoryButtonIsClicked() {
        homePage.clickOrderHistoryButton();
    }

    @Then("the {string} order history warning message is shown")
    public void theYouHaveNotPlacedAnyOrdersMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getOrderHistoryError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }
}