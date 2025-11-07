@wip
Feature: As a user I should search about anything

  Background:
    Given The user navigates to the website

  Scenario: The user should be able to make a search
    When The user enters "Hermann Hesse" in search box
    And The user clicks Google Search button
