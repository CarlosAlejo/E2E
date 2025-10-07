Feature: Purchase Flow DemoBlaze

  Scenario: Complete purchase flow with two products
    Given I am on the home page
    When I add two products to the cart
    And I view the cart
    And I complete the purchase form
    And I finalize the purchase
    Then the purchase should be successful