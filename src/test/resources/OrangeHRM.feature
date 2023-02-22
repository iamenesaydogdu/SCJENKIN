Feature: Functional testing on Orange HRM

  @LoginFunctionality @Smoke @Regression
  Scenario: Login to Orange HRM
    Given The user wants to go to OrangeHRM Website
    When The user wants to enter usurname and password
    Then The user wants to click on Login button
    And The user wants to verify that browser landed or Dashboard

    @ParameterizedDashboard @TC100 @Smoke @Regression
    Scenario: Login to Orange HRM with Parameterized message
      Given The user wants to go to OrangeHRM Website
      When The user wants to enter usurname and password
      Then The user wants to click on Login button
      And The user wants to verify that browser landed on "Dashboard"

@TC200 @Smoke @Regression
      Scenario: Adding a new employee
        Given The user wants to go to OrangeHRM Website
        When The user wants to enter usurname and password
        Then The user wants to click on Login button
        And The user wants to verify that browser landed or Dashboard
        Then The user wants to click on PIM Module
        And The user wants to go to Add Employee Page
        Then The user wants to add first name as "Bahar"
        Then The user wants to add last name as "Renastech2"
        Then The user wants to save personal information
        Then The user should be able to see "Personal Details"

  #map kullandim , istedigin kadar boslukta koyabilirsin key - value
  @TC300 @Smoke @Regression
  Scenario: Adding a new employee - different format
    Given The user wants to go to OrangeHRM Website
    When The user wants to enter usurname and password
    Then The user wants to click on Login button
    And The user wants to verify that browser landed or Dashboard
    Then The user wants to click on PIM Module
    And The user wants to go to Add Employee Page
    Then The user wants to add employee's first and last name as following
    #Key          #Value
    |Firstname|     EnesAyd|
    |Lastname| Aydogdu123|
    Then The user wants to add login details as following
     #Key          #Value
    |UserName| shahnaz1233122|
    |Password| Renastech!123@1|
    |Status  | Disabled      |
    Then The user wants to save personal information
    Then The user should be able to see "Personal Details"

#select list kullanarak
  @TC_400 @Regression
  Scenario: Adding a new employee - Third different format
    Given The user wants to go to OrangeHRM Website
    When The user wants to enter usurname and password
    Then The user wants to click on Login button
    And The user wants to verify that browser landed or Dashboard
    Then The user wants to click on PIM Module
    And The user wants to go to Add Employee Page
    Then The user wants to add employee's first and last name as Following list
    #Firstname Lastname 0-0   0-1
    |Serhat|Renastech322|
    |Bahar |Renastech#2 |
    Then The user wants to add Login in a list way
    #Username      Password        Status
      |renastech234| Renastech20222| Disabled|
      |abcRenastech | Renastech2022| Enabled |
      |abcRenastech | Renastech2022| Enabled |
    Then The user wants to save personal information
    Then The user should be able to see "Personal Details"




     #Scenario outline is the place where we implement DDT(Data Driven Testing)
        #Requirement : 8 chars + one upper case
        #In the scenario outline, it will run scenario we created and take one of rows in the examples. In this
        #scenario it will run 6 times because we have 6 rows in the examples

  #seneryo outline da expamle kullanmazsan calismaz ..
  #6 times 6 kere o assagadaki data lari giricek 6 kere ayri ayri calisicak ..
  @Scenario_Outline2
  Scenario Outline:  Adding a new employee - Using Scenario Outline
    Given The user wants to go to OrangeHRM Website
    When The user wants to enter usurname and password
    Then The user wants to click on Login button
    And The user wants to verify that browser landed or Dashboard
    Then The user wants to click on PIM Module
    And The user wants to go to Add Employee Page
    Then The user wants to add employee's first and last name as Following list
      # FirstName   LastName
      |Serhat  | Renastech322 |
      |Bahar   | Renastech#2  |
    Then The user wants to add login information "<username>" "<password>" "<status>"

    Examples:
      |username    |password      | status|
      |renastech123|Renastech2022 |Disabled|
      |renastech234| Renastech20222| Disabled|
      |abcRenastech | Renastech2022| Enabled |
      |abcRenastech | Renastech2022| Enabled |
      |Seray3212    |Abcd@!456     |Enabled  |
      |Cenkay123    |bgtrfj@!      |Disabled |


  @Scenario_Outline1
  Scenario Outline:  Adding a new employee - Using Scenario Outline
    Given The user wants to go to OrangeHRM Website
    When The user wants to enter usurname and password
    Then The user wants to click on Login button
    And The user wants to verify that browser landed or Dashboard
    Then The user wants to click on PIM Module
    And The user wants to go to Add Employee Page
    Then The user wants to add employee's as "<firstName>" "<lastName>"
    Then The user wants to add login information "<username>" "<password>" "<status>"
    # "<firstName>" whatever name we provide here it needs to match with one of below columns otherwise it will turn to grey
    #Which mmeans it will not recognize that specific column
    Examples:
      |username    |password      | status   | firstName   |lastName   |
      |renastech123|Renastech2022 |Disabled  | renastech  | renas     |
      |renastech234| Renastech20222| Disabled| Yaseen     |renastech  |
      |abcRenastech | Renastech2022| Enabled |Bahar       | renastech |
      |abcRenastech | Renastech2022| Enabled |Banu        |renastech  |
      |Seray3212    |Abcd@!456     |Enabled  |Seray       |abcdsa     |
      |Cenkay123    |bgtrfj@!      |Disabled | Huseyin    |            |
  #  Then The user wants to go to OrangeHRM Website - We cannot use steps after examples keyword because it needs to read out steps for exampelms
  #WE can leave examples empty which is going to be null by default

  #Whenever we want to automate new features we always start with typing scenarios then creating steps then locating elements

  @Scenario_outline3
  Scenario Outline: Adding new nationalities to Nationalities Page
    Given The user wants to go to OrangeHRM Website
    When The user wants to enter usurname and password
    Then The user wants to click on Login button
    And The user wants to verify that browser landed or Dashboard
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







