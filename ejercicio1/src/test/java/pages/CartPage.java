package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;
import org.openqa.selenium.WebDriver;


public class CartPage extends PageObject {

    @FindBy(id = "cartur")
    private WebElementFacade cartLink;

    @FindBy(linkText = "Place Order")
    private WebElementFacade placeOrderButton;

    @FindBy(xpath = "//tr[@class='success']")
    private List<WebElementFacade> cartItems;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void goToCart() {
        cartLink.click();
    }

    public void placeOrder() {
        placeOrderButton.click();
    }

    public int getCartItemsCount() {
        return cartItems.size();
    }
}
