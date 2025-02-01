Feature: Success Login and Logout

Scenario: Successful login and check status
  When Open Catchylabs For Login
  And Login Username "Meskici" For Login
  And Login Password "M3hm3t17*" For Login
  And Click Submit Button For Login
  And Check Info
  Then Before Click Logout Button Click Open Button