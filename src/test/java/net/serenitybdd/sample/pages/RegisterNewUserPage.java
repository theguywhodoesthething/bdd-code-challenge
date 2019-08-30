package net.serenitybdd.sample.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.sample.helpers.Field;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

@DefaultUrl("https://shrouded-lowlands-66853.herokuapp.com/")
public class RegisterNewUserPage extends PageObject {

    String[] domains = {"com", "net", "org"};
    Random random = new Random();

    @FindBy(css = "input[type=\"checkbox\"]")
    private List<WebElementFacade> checkboxes;

    @FindBy(css = "input[type=\"submit\"]")
    private WebElementFacade submit;

    public String getUrl() {
        return getDriver().getCurrentUrl();
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }

    public void fillOutAllFields() {
        for(Field field : Field.values()) {
            WebElementFacade element = element(By.id(field.getId()));

            if(field == Field.SUFFIX || field == Field.STATE) {
                int index = random.nextInt(element.getSelectOptions().size() - 1) + 1;   // don't get 0 index./
                element.selectByIndex(index);
            } else if (field == Field.EMAIL) {
                element.type(
                  String.format("%s@%s.%s",
                          RandomStringUtils.randomAlphabetic(5),
                          RandomStringUtils.randomAlphabetic(5),
                          domains[random.nextInt(domains.length)])
                );
            } else {
                element.type(RandomStringUtils.randomAlphabetic(10));
            }
        }
    }

    public void clear(Field field) {
        WebElementFacade element = element(By.id(field.getId()));
        if(field == Field.SUFFIX || field == Field.STATE) {
            element.selectByIndex(0);    // empty value is 0 index in select fields
        } else {
            element.clear();
        }
    }

    public void checkAllCheckboxes() {
        for(WebElementFacade box : checkboxes) {
            if (!box.isSelected()) {
                box.click();
            }
        }
    }

    public void clickSaveUser() {
        submit.click();
    }

    public void fillOut(Field field, String value) {
        element(By.id(field.getId())).type(value);
    }

    public String getValue(Field field) {
        return element(By.id(field.getId())).getValue();
    }

    public String getPageText() {
        return getDriver().findElement(By.tagName("body")).getText();
    }
}
