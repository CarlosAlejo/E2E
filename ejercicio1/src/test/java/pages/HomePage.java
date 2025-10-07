package pages;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {

    @FindBy(linkText = "Laptops")
    private WebElementFacade laptopsCategory;

    @FindBy(linkText = "Phones")
    private WebElementFacade phonesCategory;

    @FindBy(linkText = "Monitors")
    private WebElementFacade monitorsCategory;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selectCategory(String category) {
        switch (category) {
            case "Laptops":
                laptopsCategory.click();
                break;
            case "Phones":
                phonesCategory.click();
                break;
            case "Monitors":
                monitorsCategory.click();
                break;
        }
    }
}