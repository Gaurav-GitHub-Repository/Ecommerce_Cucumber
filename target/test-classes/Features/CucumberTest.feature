#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@tag
Feature: Verify order functionality of sauce demo application

  @FunctionalTest
  Scenario: Verification of successful order
  
    Given Open Google Chrome browser and launch application
    When User enters Username and Password
    When User click on product filter  
    Then User click on add to cart button
    When User click on cart
    When User click on checkout button
    Then User enters First Name, Last name and Zip Code
    When User click on continue button 
    When User click on Finish button
    Then Verify order placed message
    When User click on back to home button
    When User click on product button
    Then User click on logout button 
   

   
    
# @tag2
#  Scenario Outline: Title of your scenario outline
#  Given I want to write a step with <name>
#  When I check for the <value> in step
#  Then I verify the <status> in step

#  Examples: 
#  | name  | value | status  |
#  | name1 |     5 | success |
# | name2 |     7 | Fail    |
