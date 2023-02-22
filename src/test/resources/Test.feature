Feature: This feature is about login fuctionality of Amazon
  #!
  #This is how we comment or feature files
  # Gherkin language Given , Then , And , But

  #This is positive scenario
  Scenario: Login to Amazon with correct username and correct password
    Given The user wants to go to Amazon's website
    When The user wants to enter correct username
    Then The user wants to enter correct password
    And The user wants to click on login button
    #This is negative scenario
  Scenario: Login to Amazon with correct username and incorrect password
    Given The user wants to go to Amazon's Website
    When The user wants to enter correct username
    Then The user wants to incoreect password
    And The user wants to click on login button
    And The user wants to verify that login was unsuccessful

    #This is negative scenario
  Scenario: Login to Amazon with incorrect username and incorrect password
    Given The use wants to go to Amazon Website
    When The user wants to enter incorrect username
    Then The use wants to enter incorrect password
    And The user wants to click on login button
    And The user wants to verify that login was unseccesful

