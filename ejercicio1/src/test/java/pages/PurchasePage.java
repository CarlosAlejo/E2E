package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class PurchasePage extends PageObject {

    @FindBy(id = "name")
    private WebElementFacade nameField;

    @FindBy(id = "country")
    private WebElementFacade countryField;

    @FindBy(id = "city")
    private WebElementFacade cityField;

    @FindBy(id = "card")
    private WebElementFacade cardField;

    @FindBy(id = "month")
    private WebElementFacade monthField;

    @FindBy(id = "year")
    private WebElementFacade yearField;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElementFacade purchaseButton;

    @FindBy(className = "sweet-alert")
    private WebElementFacade successAlert;

    public PurchasePage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(String name, String country, String city, String card, String month, String year) {
        nameField.type(name);
        countryField.type(country);
        cityField.type(city);
        cardField.type(card);
        monthField.type(month);
        yearField.type(year);
    }

    public void purchase() {
        purchaseButton.click();
    }

    public boolean isPurchaseSuccessful() {
        return successAlert.isVisible() && successAlert.getText().contains("Thank you for your purchase");
    }
}