Feature: Ebay Application add to cart functionality

  Scenario: Verify item can be added to Cart
    Given User enters "book" in search field
    And User click on the search button
    And User clicks on the link
    And User clicks on AddToCart button
    And users verifies that the checkout page is visible
    Then user validate the cart image is updated