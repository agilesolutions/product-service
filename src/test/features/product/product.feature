Feature: Managing products

   @basis
   Scenario Outline: Retrieve product assortment by identifier
        When I search product assortment by identifier <id>
        Then the product assortment is found
        And its assortment title is '<title>'
        
   Examples:
   
    | id             | title                             |
    | 9              | Fantastic                         |
    | 8              | methodical                        |
    | 3 		     | Centers Steel Credit Card Account |
   
   @critical 
   Scenario Outline: Retrieve product rating by identifier
        When I search product rating by id <id>
        Then the product rating is found
        And its rating level is <rating>
        
   Examples:
   
    | id             | rating |
    | 9              | 77577  |
    | 8              | 79521  |
    | 3 		     | 54662  |     