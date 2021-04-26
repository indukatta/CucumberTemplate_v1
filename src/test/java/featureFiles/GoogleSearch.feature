@googleSearch
Feature: Google Search
  Perform user search

  Scenario: Google search for OneFamily keyword
    Given I access Google website
    When I search with OneFamily keyword
    Then the search results are displayed

  Scenario: Google search for Cucumber keyword
    Given I access Google website
    When I search with Cucumber keyword
    Then the search results are displayed