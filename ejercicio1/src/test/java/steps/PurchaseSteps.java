package steps;

import net.thucydides.core.annotations.Steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.*;

public class PurchaseSteps {

    @Steps
    private HomePage homePage;

    @Steps
    private ProductPage productPage;

    @Steps
    private CartPage cartPage;

    @Steps
    private PurchasePage purchasePage;

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        homePage.open();
    }

    @When("I add two products to the cart")
    public void i_add_two_products_to_the_cart() {
        // Primer producto
        homePage.selectCategory("Phones");
        productPage.selectProduct("Samsung galaxy s6");
        productPage.addToCart();
        homePage.waitForRenderedElementsToDisappear(
            org.openqa.selenium.By.xpath("//div[@class='modal-footer']")
        );
        
        // Segundo producto
        homePage.selectCategory("Phones");
        productPage.selectProduct("Nexus 6");
        productPage.addToCart();
    }

    @When("I view the cart")
    public void i_view_the_cart() {
        cartPage.goToCart();
    }

    @When("I complete the purchase form")
    public void i_complete_the_purchase_form() {
        cartPage.placeOrder();
        purchasePage.fillForm("John Doe", "USA", "New York", "1234567890", "12", "2025");
    }

    @When("I finalize the purchase")
    public void i_finalize_the_purchase() {
        purchasePage.purchase();
    }

    @Then("the purchase should be successful")
    public void the_purchase_should_be_successful() {
        assert purchasePage.isPurchaseSuccessful();
    }
}