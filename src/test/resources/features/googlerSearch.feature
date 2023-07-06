Feature: Google search

  Background:
    Given I am on the Google search page

  Scenario Outline: Finding some cheese
    When I search for "<query>"
    Then the page title should start with "<expectedTitle>"
    Examples:
      | query | expectedTitle |
      | Cheese! | cheese      |
      | Milk!   | milk        |

  Scenario: Finding some qwe
    When I search for "qwe!"
    Then the page title should start with "qwe"