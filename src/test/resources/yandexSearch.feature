Feature: Yandex search
  Background:
    Given pre condition
  Scenario Outline: Search Yandex for TeachMeSkills
    Given Word for search is "<searchWord>"
    When I navigate to yandex.by
    And I enter search word
    And  I press search button
    Then First result contains search word in title
    Examples:
    |searchWord|
    |TeachMeSkills|
    |Iphone|
    |Selenium|
  Scenario: Verify search results count
    Given Word for search is "TeachMeSkills"
    When I navigate to yandex.by
    And I enter search word
    And  I press search button
    Then There are 10 results are present