@AllAddMoney
Feature: Add Money Scenarios

  @TrueAddMoney
Scenario: Add Money Scenarios [Happy Path]
  When Open Catchylabs For Login
  And Login Username "Meskici" For Login
  And Login Password "M3hm3t17*" For Login
  And Click Submit Button For Login
  And Click Open Money Transfer Button
  And Click Add Money Button
  And Write Card Number "1234123412341234"
  And Write Card Holder "123432"
  And Write Card Expire Date "1225"
  And Write Card Cvv "123"
  And Write Card Amount "100.23"
  And Click Add Button
  Then Check My Account Information Again
  @FalseAddMoney
  Scenario: Add Money Scenarios [Misssing card number and Blank card Number]
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Click Add Money Button
    And Write Card Number "1234 1234"
    And Check Card Number
    And Write Card Holder "123432"
    And Write Card Expire Date "1225"
    And Write Card Cvv "123"
    And Write Card Amount "100"
    And Click Add Button
  @FalseAddMoney
  Scenario: Add Money Scenarios [Misssing card Holder and Blank card Holder]
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Click Add Money Button
    And Write Card Number "1234123412341234"
    And Write Card Holder "123"
    And Check Card Holder
    And Write Card Holder ""
    And Check Card Holder For Blank
    And Write Card Expire Date "1225"
    And Write Card Cvv "123"
    And Write Card Amount "100"
    And Click Add Button
  @FalseAddMoney
  Scenario: Add Money Scenarios [Wrong Expire Date and Blank Expire Date ]
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Click Add Money Button
    And Write Card Number "1234123412341234"
    And Write Card Holder "12345"
    And Write Card Expire Date "2425"
    And Check Expire Date
    And Write Card Expire Date ""
    And Check Expire Date For Blank
    And Write Card Cvv "123"
    And Write Card Amount "100"
    And Click Add Button

  @FalseAddMoney
  Scenario: Add Money Scenarios [Wrong Cvv and Blank Cvv ]
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Click Add Money Button
    And Write Card Number "1234123412341234"
    And Write Card Holder "12345"
    And Write Card Expire Date "1225"
    And Write Card Cvv "12"
    And Check Wrong Cvv
    And Write Card Cvv ""
    And Check Cvv For Blank
    And Write Card Amount "100"
    And Click Add Button

  @FalseAddMoney
  Scenario: Add Money Scenarios [Blank Amount ]
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Click Add Money Button
    And Write Card Number "1234123412341234"
    And Write Card Holder "12345"
    And Write Card Expire Date "1225"
    And Write Card Cvv "123"
    And Write Card Amount ""
    And Check Card Amount For Blank
    And Click Add Button

  @FalseAddMoney
  Scenario: Add Money Scenarios [Negative Amount ]
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Click Add Money Button
    And Write Card Number "1234123412341234"
    And Write Card Holder "12345"
    And Write Card Expire Date "1225"
    And Write Card Cvv "123"
    And Write Card Amount "-100"
    And Check Card Amount For Negative
    And Click Add Button

  @FalseAddMoney
  Scenario: Add Money Scenarios [Too Much Amount ]
    When Open Catchylabs For Login
    And Login Username "Meskici" For Login
    And Login Password "M3hm3t17*" For Login
    And Click Submit Button For Login
    And Click Open Money Transfer Button
    And Click Add Money Button
    And Write Card Number "1234123412341234"
    And Write Card Holder "12345"
    And Write Card Expire Date "1225"
    And Write Card Cvv "123"
    And Write Card Amount "99999999999999"
    And Check Card Amount For Too Much Amount
    And Click Add Button
