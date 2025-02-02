
Feature: Failed Login Scenarios
  @FailedLogin
  Scenario: Logging in with wrong username
    When Open Catchylabs
    And Login Username "abcTest"
    And Login Password "M3hm3t17*"
    And Click Submit Button
    Then Check Warning Box
  @FailedLogin
  Scenario: Logging in with wrong password
    When Open Catchylabs
    And Login Username "Meskici"
    And Login Password "abcTest*"
    And Click Submit Button
    Then Check Warning Box
  @FailedLogin
  Scenario:Logging in with wrong username and password
    When Open Catchylabs
    And Login Username "AbcTest"
    And Login Password "TestABC*"
    And Click Submit Button
    Then Check Warning Box
  @FailedLogin
  Scenario: Logging in with a blanck username and password
    When Open Catchylabs
    And Login Username " "
    And Login Password " "
    And Click Submit Button
    Then Check Warning Box




