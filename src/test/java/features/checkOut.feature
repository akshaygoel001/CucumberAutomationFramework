Feature: Place the order for products

  Scenario Outline: User add to cart and checkout experience in home page and cart page
    Given User is on GreenKart landing page
    When User searched with shortname "<ProductName>" and extracted actual name of product
    And User add "<ProductName>" to cart with <Quantity> units
    And User proceed to checkout on cart page
    Then Validate cart page product name matches name in landing page 
    And Validate quanity <Quantity> and total price on cart page
    And Validate Apply and Place Order button
 	 Examples:
	|ProductName|Quantity	|
	|Tom				|				3	|
	|Beet				|				2 |

