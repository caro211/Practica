# language: en
Feature:As an administrator
  I want to be able to create and delete stores
  So that I can manage the stores of the system


  @storeCreated
  Scenario: Successfully sending a request to create a new store
    When the administrator sends a request to create a new store
    Then the response status code should be success

  @storeDeleted
  Scenario: Successfully sending a request to delete a store
    When the administrator sends a request to delete a store
      |OrderID|
      |8|
    Then the response status code should be success