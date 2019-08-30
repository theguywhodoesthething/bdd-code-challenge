package net.serenitybdd.sample.scenarios;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.sample.helpers.Field;
import net.serenitybdd.sample.steps.RegisterNewUserSteps;
import net.thucydides.core.annotations.Steps;

public class RegisterNewUserScenarios {

    @Steps RegisterNewUserSteps user;

    @Given("^there is a user on the registration page$")
    public void thereIsAUserOnTheRegistrationPage() {
        user.A01_A06_isOnTheRegistrationPage();
    }

    @Then("^the register new user page should be displayed$")
    public void theRegisterNewUserPageShouldBeDisplayed() {
        user.shouldBeOnTheRegistrationPage();
    }

    @Given("^all required fields are filled out except for the first name field$")
    public void allRequiredFieldsAreFilledOutExceptForTheFirstNameField() {
        user.A02_fillsOutAllRequiredFields().A03_exceptFor(Field.FIRST_NAME);
    }

    @Given("^all checkboxes are checked$")
    public void allCheckboxesAreChecked() {
        user.A04_checksAllCheckboxes();
    }

    @When("^the user saves the form$")
    public void theUserSavesTheForm() {
        user.A05_savesTheForm();
    }

    @Then("^an error message should display indicating that the first name field requires a value$")
    public void anErrorMessageShouldDisplayIndicatingThatTheFirstNameFieldRequiresAValue() {
        user.shouldSeeFirstNameErrorMessage();
    }

    @When("^the user fills in the first name field with (.*)$")
    public void theUserFillsInTheFirstNameFieldWith(String firstName) {
        user.A07_fillsOut(Field.FIRST_NAME, firstName);
    }

    @Then("^the first name field should contain (.*)$")
    public void theFirstNameFieldShouldContain(String firstName) {
        user.A08_shouldSee(firstName, Field.FIRST_NAME);
    }

    @Given("^all required fields are filled out except for the suffix field$")
    public void allRequiredFieldsAreFilledOutExceptForTheSuffixField() {
        user.A02_fillsOutAllRequiredFields().A03_exceptFor(Field.SUFFIX);
    }

    @Then("^the user should be redirected to the success page$")
    public void theUserShouldBeRedirectedToTheSuccessPage() {
        user.shouldBeOnTheSuccessPage();
    }

    @Given("^all required fields are filled out except for the title field$")
    public void allRequiredFieldsAreFilledOutExceptForTheTitleField() {
        user.A02_fillsOutAllRequiredFields().A03_exceptFor(Field.TITLE);
    }

    @When("^the user fills in the title field with (.*)$")
    public void theUserFillsInTheTitleFieldWith(String title) {
        user.A07_fillsOut(Field.TITLE, title);
    }

    @Then("^an error message should display indicating that the title field does not accept numbers$")
    public void anErrorMessageShouldDisplayIndicatingThatTheTitleFieldDoesNotAcceptNumbers() {
        user.shouldSeeTitleErrorMessage();
    }
}
