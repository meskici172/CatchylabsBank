@AllTransfer
Feature: Success Login and Transfer Money

  @TransferMoney
  Scenario: Successful login and Transfer Money with Testinium 1 Recevier
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Check My Account Information
    And Click Transfer Money Button
    And Write Amount "100"
    And Click Send Button
    Then Check My Account Information Again
    Then Check Transaction Information
  @TransferMoney
  Scenario: Successful login and Transfer Money with Testinium 2 Recevier
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Check My Account Information
    And Click Transfer Money Button
    And Write Amount "100.88"
    And Click Recevier Testinium2 Account
    And Click Send Button
    Then Check My Account Information Again
    Then Check Transaction Information
  @TransferMoney
  Scenario: Successful login and Transfer Money with Testinium 3 Recevier
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Check My Account Information
    And Click Transfer Money Button
    And Write Amount "250.42"
    And Click Recevier Testinium3 Account
    And Click Send Button
    Then Check My Account Information Again
    Then Check Transaction Information
  @TransferMoney
  Scenario: Successful login and Transfer Money with Testinium 4 Recevier
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Check My Account Information
    And Click Transfer Money Button
    And Write Amount "300.70"
    And Click Recevier Testinium4 Account
    And Click Send Button
    Then Check My Account Information Again
    Then Check Transaction Information
  @TransferMoney
  Scenario: Successful login and Transfer Money with Testinium 5 Recevier
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Check My Account Information
    And Click Transfer Money Button
    And Write Amount "400"
    And Click Recevier Testinium5 Account
    And Click Send Button
    Then Check My Account Information Again
    Then Check Transaction Information
  @NegativeAmount
  Scenario: Successful login and Transfer Money with Negative Amount
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Check My Account Information
    And Click Transfer Money Button
    And Write Amount "-500"
    And Click Send Button
    Then Check My Account Information Again
    Then Check Transaction Information