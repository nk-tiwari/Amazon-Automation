Feature: Operations on search results

Scenario: Filter, sort and carts 
Given I am on Search results page
When I filter items by max and min price
And sort the items in descending order
And Pick 2nd and 4th item and add it to cart
And navigate to carts section
Then I have 2 items in the cart
And Print the total cart value