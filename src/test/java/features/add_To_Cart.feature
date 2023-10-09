Feature: Test suite for Add to Cart functionality
  @TC04 @ATC01 @add_to_cart @all
  @parallelrun
  Scenario: Verify user is able to add product to the cart
    Given user opens sauce labs website
    When user successfully login to the website
    Then user clicks on Sauce Labs Backpack product
    Then user adds Sauce Labs Backpack product to cart
    Then user clicks on menu button
    Then user perform logout
    Then user close Browser

  @TC05 @ATC02 @add_to_cart @all
  @parallelrun
  Scenario: Verify user is able to remove product from the cart
    Given user opens sauce labs website
    When user successfully login to the website
    Then user clicks on Sauce Labs Backpack product
    Then user adds Sauce Labs Backpack product to cart
    Then user click on cart
    Then user verify that the product should be added to the cart
    Then user remove product from shopping cart
    Then user verify that product is removed from the cart
    Then user clicks on menu button
    Then user perform logout
    Then user close Browser


