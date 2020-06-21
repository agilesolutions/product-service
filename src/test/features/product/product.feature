Feature: Category management

   Scenario Outline: Retrieve transmit product
        When I search product <id>
        Then the product is found
        And its description is '<title>'
        
   Examples:
   
    | id             | title                             |
    | 9              | Fantastic                         |
    | 8              | methodical                        |
    | 3 		     | Centers Steel Credit Card Account |        