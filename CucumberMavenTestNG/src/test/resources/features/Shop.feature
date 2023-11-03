Feature: Shop page and Cart functionality for Jupiter Toys website

 As a user of the Jupiter Toys website
 I want to be able to add items to cart
 So that I can verify the price
 	
 Scenario: Successfully added to cart and validate price
  Given I am on the Shop page
  When I take note of the price and buy 2 "Stuffed Frog"
  And I take note of the price and buy 5 "Fluffy Bunny"
  And I take note of the price and buy 3 "Valentine Bear"
  Then I should be able to verify if the price and total is correct

  