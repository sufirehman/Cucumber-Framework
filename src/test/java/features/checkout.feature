Feature: Test suite for checkout functionality
    @TC06 @ATC01 @checkout @all
    @parallelrun
    Scenario: Verify user is able to remove product from the cart
    Given user opens sauce labs website
    When user successfully login to the website
    Then user clicks on Sauce Labs Backpack product
    Then user adds Sauce Labs Backpack product to cart
    Then user click on cart
    Then user verify that the product should be added to the cart
    Then user click on checkout button
    Then user fill shipping information
    Then user click on continue button
    Then user click on finish button
    Then user should able to successfully place an order
    Then user close Browser