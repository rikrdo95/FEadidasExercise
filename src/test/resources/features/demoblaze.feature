@Regression @PetStore
Feature: Demoblaze - front-end automated testing 

    Scenario Outline: Demoblaze test
        Given I am in "home" page
        Given I navigate to the section "<Section1>"
        And I navigate to the section "<Section2>"
        And I navigate to the section "<Section3>"
        Then I navigate to the section "<Section2>"
        And I add to the cart the product "<product1>"
        Given I am in "home" page
        Then I navigate to the section "<Section2>"
        And I add to the cart the product "<product2>"
        Given I am in "cart" page
        Then I delete from the cart the product "<product2>"
        When I want to place the order
        And I fill the form fields
        And I click on "<finishAction>"
        Then I check the fields
        | <field1> |
        | <field2> |
        And I click on OK to finish the purchase
        Examples:
        | Section1 | Section2 | Section3 | product1     | product2    | finishAction | field1 | field2 |
        | Phones   | Laptops  | Monitors | Sony vaio i5 | Dell i7 8gb | Purchase     | Id     | Amount |