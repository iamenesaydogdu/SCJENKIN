

Feature: We are testing background keyword in this file
#We are predefining the steps below for each scenario in this feature file
  #Which means it will run these steps before each scenario we run in this class
  #We must place Background keyword before all scenarios in file and after Feature keyword. It will not work otherwise.
  #Background keyword works like hooks
  #We cannot have background keyword twice
  #Important Interview questions? What is the difference between Hooks and Background keyword
  # and why you use background keyword

  #Hooks are global throughout the framework and Background keyword is local to Feature file
  # seneryolari run ederken yukardaki once devreye girer sonra seneroylara  gelir  .. ama unutma @background ile yaz
  Background: The user wants to go to OrangeHRM Website
    Given The user wants to go to OrangeHRM Website
    When The user wants to enter usurname and password
    Then The user wants to click on Login button
    And The user wants to verify that browser landed or Dashboard

  @TC200 @Smoke @Regression @BackgroundKeyword
  Scenario: Adding a new employee
    Then The user wants to click on PIM Module
    And The user wants to go to Add Employee Page
    Then The user wants to add first name as "Yaseen"
    Then The user wants to add last name as "Renastech2"
    Then The user wants to save personal information
    Then The user should be able to see "Personal Details"



      #In this scenario we are using Map to provide Multiple pieces of information
  @TC300 @Smoke @Regression @BackgroundKeyword
  Scenario: Adding a new employee - different format using Map
    Then The user wants to click on PIM Module
    And The user wants to go to Add Employee Page
    Then The user wants to add employee's first and last name as following
      # Key             Value
      |FirstName|      Shahnaz121 |
      |LastName |      Renastech121|
    Then The user wants to add login details as following
      # Key            Value
      |UserName|     shahnaz12331|
      |Password| Renastech!123@|
      |Status  | Disabled      |
    Then The user wants to save personal information
    Then The user should be able to see "Personal Details"

  @BackgroundKeyword @Regression
  Scenario: Adding a new employee - Third format using List
    Then The user wants to click on PIM Module
    And The user wants to go to Add Employee Page
    Then The user wants to add employee's first and last name as Following list
      # FirstName   LastName
      |Serhat  | Renastech322 |
      |Bahar   | Renastech#2  |
    Then The user wants to add Login in a list way
      #Username       Password       Status
      |renastech234| Renastech20222| Disabled|
      |abcRenastech | Renastech2022| Enabled |
      |abcRenastech | Renastech2022| Enabled |
    Then The user wants to save personal information
    Then The user should be able to see "Personal Details"


  @Scenario_outline3
  Scenario Outline: Adding new nationalities to Nationalities Page
    And The user wants to go to Admin Module
    Then The user wants to go to Nationalities Section
    And The user wants to click on add new nationality
    Then The user wants to add new nationalities as "<Nationalities>"

    #In the last step above, it will apply a different nationality each time it runs
    #This scenario will run 8 times
    Examples:
      |Nationalities|
      |Aramaic      |
      |American     |
      |Italian      |
      |Kurdish      |
      |Haitian      |
      |Yemenese     |
      |French       |
      |Turkish      |



