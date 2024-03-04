
    Feature: Verify stock and checkout functionality on Vodafone eShop

      Background:
        Given I'm on the Vodafone eShop homepage
        And   I'm logged in to Vodafone eShop With username and password
        


        Scenario:  Validate out-of-stock and "Add to Cart" functionality
          When  I search for productName and select Samsung in Smart Phones from the search list
          And   I select the first available product from the OPPO Tab
          Then  I check the status of each color in the product
          And   I add the product to cart if it is available in stock
          Then  The product should be successfully added to the cart



        Scenario Outline: Check Checkout details error while missing data happening
          When I click on the Cart button
          Then I validate that there are products in the cart
          When I click on the Go to checkout button
          And  I click on Add new Address
          And  I set the city, district, and "<streetName>"
          And  I set an invalid "<Building>", "<Floor>", and "<Apartment>"
          Then I validate that the error message is displayed
          And  I see the save address button is dimmed
          Examples:
            | streetName      | Building | Floor | Apartment |
            | Yasser Bn Amer  | 12345    |12345  |  12345    |



