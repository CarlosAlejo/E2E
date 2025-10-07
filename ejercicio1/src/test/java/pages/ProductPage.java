package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class ProductPage extends PageObject {

    @FindBy(linkText = "Samsung galaxy s6")
    private WebElementFacade productSamsungS6;

    @FindBy(linkText = "Nexus 6")
    private WebElementFacade productNexus6;

    @FindBy(linkText = "Add to cart")
    private WebElementFacade addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectProduct(String productName) {
        switch (productName) {
            case "Samsung galaxy s6":
                productSamsungS6.click();
                break;
            case "Nexus 6":
                productNexus6.click();
                break;
        }
    }

    public void addToCart() {
        addToCartButton.click();
    }
}
