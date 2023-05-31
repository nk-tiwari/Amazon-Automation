Feature: Amazon Homepage search functionality tests

Scenario: Search for an item in Amazon Homepage
Given I am on Amazon Homepage
When I search for an item
And I click on search icon
Then I am on results page