
@smoke
Feature: Test and Validate Page conetents
  As user, I want to be able to create a new account
  Background: user on the home page
    Given I navigate to the home page
 @smoke
  Scenario: Login as a unsaved user
    When I show rows by '20'
    And I capture all page content
    And I filter by 'Algorithm' - 'PoW'
    And I follow by "+ Filter"
    And I toggle "Mineable"
    And I select "All Cryptocurrencies"
    And I select "Coins" from filter options
   And I select prize and set min value to "100" and max "10000"
    Then I should see the comparisan is true




