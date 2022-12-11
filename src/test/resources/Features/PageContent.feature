
@smoke
Feature: Test and Validate Page contents

  Background: user on the home page
    Given I navigate to the home page
 @smoke
 Scenario: Login as a unsaved user
   When I show rows by "20"
   And I capture Name,Price and MarketCap for cryptocurrencies from the content of the page before applying filters
   And I filter by "Algorithm" - "PoW"
   And I follow by Add Filter
  And I toggle "Mineable"
   And I select "All Cryptocurrencies"
   And I select "Coins" from filter options
   And I select "Price" and set min value to "100" and max "10000"
  And I capture Name,Price and MarketCap for cryptocurrencies from the content of the page after applying filters
  Then I should see that number of contents is decreased






