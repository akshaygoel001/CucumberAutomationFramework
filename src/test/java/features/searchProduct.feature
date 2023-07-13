Feature: Search Product and Place the order

  Scenario Outline: Search experience for product search in home page and offers page
    Given User is on GreenKart landing page
    When User searched with shortname "<ProductName>" and extracted actual name of product
    Then User searched for "<ProductName>" shortname in offers page 
    And Validate offer page product name matches name in landing page
	Examples:
	|ProductName|
	|Tom				|
	|Beet				|
  
