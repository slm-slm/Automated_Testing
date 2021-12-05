package hu.unideb.inf;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class NewsletterStepDefs extends AbstractStepDefs {

    @When("the Newsletter button is clicked")
    public void theNewsletterButtonIsClicked() {
        homePage.clickNewsLetterButton();
    }

    @Then("the {string} newsletter error message is shown")
    public void theNewsletterErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getNewsletterError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }
}