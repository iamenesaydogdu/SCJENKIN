Feature: Login to Gmail , Google seacrh
  Scenario: Verify that login to gmail with positive credentials is succesful
    Given The user wants to go to Google
    When The user wants to click on Gmail
    Then The user wants to verify if Gmail page is opened succesfully
    And The user wants to click Sign In button
    And The user wants to enter correct email adress
    And The user wants to coreect password
    And The user wants to clcik Login button
    Then The user wants to verify that signing was succesful


  Scenario: Verify that login to gmail with positive credentials is succesful
    Given The user wants to go to Google
    When The user wants to click on Gmail
    Then The user wants to verify if Gmail page is opened succesfully
    And The user wants to click Sign In button
    And The user wants to enter correct email adress
    And The user wants to coreect password
    And The user wants to clcik Login button
    Then The user wants to verify that signing was succesful
    And The user wants to search for Renastech in emails
    Then The user wants to verify that seacrh was succesful
    #and make sure website opened succesfully
    Scenario: Verify that the user is able to go to Renastech using google search
      Given The user wants to go to Google
      When The user  wants to search for Renastech
      And The user wants to click on Google search button
      And The user wants to click on Renastech in results
      Then The user wants to verify that Renastech Website is opened
  #Each step is sentence sensitive
  Scenario: Verify that the user is able to go to Renastech by clickling Im Feeling Luckly button
    Given The user wants to go to Google
    When The user  wants to search for Renastech
    And The user wants to click on I'm Feeling Luckly Button
    Then The user wants tp verify that Browser is directed to renastech.com


  #you can use steps here when providing details on how to reproduce a bug in jira ticket
    #The tools that we use in this framework
  # This framework is cucumber BDD with Junit
  #Selenium -- automation tool for web browser
  #Junit -- this is for testing framework . For asserstion / instead of Junit we can use Tesntg as Well
  #Cucumber -- Type of framework
