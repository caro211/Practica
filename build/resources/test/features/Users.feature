# language: en
  Feature:As an administrator
    I want to be able to create users
    So that I can manage the users of the system

    @userCreated
    Scenario: Successfully sending a request to create a new user
      Given the administrator wants to access the user creation API
      When the administrator sends a request to create a new user
      Then the response status code should be success

      @listUser
    Scenario: Consult created users
      When the administrator wants to retrieve users
      |Username|
      |theUser|
      Then the response status code should be success

        @invalidUser
        Scenario: Consult non-created user
          When the administrator consults non-created user
            |Username|
            |theUser1|
          Then the response status code should be fail
