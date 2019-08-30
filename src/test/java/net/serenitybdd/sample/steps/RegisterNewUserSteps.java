package net.serenitybdd.sample.steps;

import net.serenitybdd.sample.helpers.Field;
import net.serenitybdd.sample.pages.RegisterNewUserPage;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterNewUserSteps {

    private RegisterNewUserPage page;

    @Step
    public RegisterNewUserSteps A01_A06_isOnTheRegistrationPage() {
        page.open();
        return this;
    }

    @Step
    public RegisterNewUserSteps A02_fillsOutAllRequiredFields() {
        page.fillOutAllFields();
        return this;
    }

    @Step
    public RegisterNewUserSteps A03_exceptFor(Field field) {
        page.clear(field);
        return this;
    }

    @Step
    public RegisterNewUserSteps A04_checksAllCheckboxes() {
        page.checkAllCheckboxes();
        return this;
    }

    @Step
    public RegisterNewUserSteps A05_savesTheForm() {
        page.clickSaveUser();
        return this;
    }

    @Step
    public RegisterNewUserSteps A07_fillsOut(Field field, String value) {
        page.fillOut(field, value);
        return this;
    }

    @Step
    public void A08_shouldSee(String expected, Field field) {
        assertThat(page.getValue(field)).isEqualTo(expected);
    }

    // Assert

    @Step
    public void shouldBeOnTheSuccessPage() {
        assertThat(page.getPageText())
                .containsIgnoringCase("Success! You have signed up.");
    }

    @Step
    public void shouldSeeTitleErrorMessage() {
        assertThat(page.getPageText())
                .containsIgnoringCase("Title can only contain letters and spaces");
    }

    @Step
    public void shouldSeeFirstNameErrorMessage() {
        assertThat(page.getPageText())
                .containsIgnoringCase("First Name cannot be blank");
    }

    @Step
    public void shouldBeOnTheRegistrationPage() {
        assertThat(page.getUrl())
                .containsIgnoringCase("shrouded-lowlands-66853.herokuapp.com");
        assertThat(page.getPageTitle())
                .containsIgnoringCase("Code Challenge");
    }
}
