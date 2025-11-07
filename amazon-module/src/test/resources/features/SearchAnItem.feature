@wip
Feature: As a user I should search an item to buy

  Background:
    Given The user navigates to the website

  Scenario: The user should be able to make a search
    When The user enters "Paul Klee" in search box
    And The user clicks search button