# language: en
Feature:As an administrator
  I want to be able to create and modify pets
  So that I can manage the pets of the system


  @petCreated
  Scenario: Successfully sending a request to create a new pet
    When the administrator sends a request to create a new pet
    Then the response status code should be success


  @petModified
  Scenario: Successfully sending a request to modify a  pet
    When the administrator sends a request to modify pet
    Then the response status code should be success

  @InvalidModification
  Scenario: Successfully sending a request to modify a  pet
    When the administrator sends a request to modify pet invalid
    Then the response status code should be a error