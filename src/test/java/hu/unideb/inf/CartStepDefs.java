package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class CartStepDefs extends AbstractStepDefs {

    @When("the Cart link is clicked")
    public void theCartLinkIsClicked() {
        homePage.clickCartLink();
    }

    @Then("the {string} cart warning message is shown")
    public void theYourShoppingCartIsEmptyCartWarningMessageIsShown(String msg){
        Optional<String> errorMessage = homePage.getCartWarningMessage();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }
}