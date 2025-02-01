Feature: Edit Account Name

Scenario: Update account name after successful login
  When Open Catchylabs For Login
  And Login Username "Meskici" For Login
  And Login Password "M3hm3t17*" For Login
  And Click Submit Button For Login
  And Click Open Money Transfer Button
  And Click Edit Account Button
  And Write Account Name "Eskici"
  And Click Update Button
  Then Check Account Name of "Eskici" After The Update

  Scenario: Update Blancked account name after successful login
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Click Edit Account Button
    And Write Account Name "   "
    And Click Update Button
    Then Check Account Name of "   " After The Update

  Scenario: Update With a Number account name after successful login
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Click Edit Account Button
    And Write Account Name "123"
    And Click Update Button
    Then Check Account Name of "123" After The Update

  Scenario: Update With a Number and account name after successful login
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Click Edit Account Button
    And Write Account Name "123Mehmet"
    And Click Update Button
    Then Check Account Name of "123Mehmet" After The Update
