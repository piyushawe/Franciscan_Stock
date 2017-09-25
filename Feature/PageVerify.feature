Feature: Franciscan Stock
      As a user I would like to verify that 
      The page is loaded successfully

  Background:
    Given user enter "http://erptraining.franciscanecare.net/Secure/"
    When user enter username "admin" and password "fspl@12345"
    And passes school name "erptraining"
    And click signin
    Then stock home page is opened

  #notification scheduler
  @scenario1
  Scenario: To verify notification scheduler page
    When user open notification scheduler page
    Then verify notification scheduler page

  #define item unique entity
  @scenario2
  Scenario: To verify define item unique entity page
    When user open define item unique entity page
    Then verify define item unique entity page

  #stock master setting
  @scenario3
  Scenario: To verify stock master setting page
    When user open stock master setting page
    Then verify stock master setting page

  #define item category
  @scenario4
  Scenario: To verify define item category page
    When user open define item category page
    Then verify define item category page

  #define unit
  @scenario5
  Scenario: To verify define unit page
    When user open define unit page
    Then verify define unit page

  #define items
  @scenario6
  Scenario: To verify define items page
    When user open define items page
    Then verify define items page

  #define items sub category
  @scenario7
  Scenario: To verify define items sub category page
    When user open define items sub category page
    Then verify define items sub category page

  #define brand name
  @scenario8
  Scenario: To verify define brand name page
    When user open define brand name page
    Then verify define brand name page

  #define academic year
  @scenario9
  Scenario: To verify define academic year page
    When user open define academic year page
    Then verify define academic year page

  #define financial year
  @scenario10
  Scenario: To verify define financial year page
    When user open define financial year page
    Then verify define financial year page

  #define sms template
  @scenario11
  Scenario: To verify define sms template page
    When user open define sms template page
    Then verify define sms template page

  #requisition order
  @scenario12
  Scenario: To verify requisition order page
    When user open requisition order page
    Then verify requisition order page

  #purchase order
  @scenario13
  Scenario: To verify purchase order page
    When user open purchase order page
    Then verify purchase order page

  #stock in entry
  @scenario14
  Scenario: To verify stock in entry page
    When user open stock in entry page
    Then verify stock in entry page

  #stock bill entry
  @scenario15
  Scenario: To verify stock bill entry page
    When user open stock bill entry page
    Then verify stock bill entry page

  #purchase return entry
  @scenario16
  Scenario: To verify purchase return entry page
    When user open purchase return entry page
    Then verify purchase return entrypage

  #stock issue
  @scenario17
  Scenario: To verify stock issue page
    When user open stock issue page
    Then verify stock issue page

  #stock return
  @scenario18
  Scenario: To verify stock return page
    When user open stock return page
    Then verify stock return page

  #asset opening entry
  @scenario19
  Scenario: To verify asset opening entry page
    When user open asset opening entry page
    Then verify asset opening entry page

  #opening quantity
  @scenario20
  Scenario: To verify opening quantity page
    When user open opening quantity page
    Then verify opening quantity page

  #stock return item wise
  @scenario21
  Scenario: To verify stock return item wise page
    When user open stock return item wise page
    Then verify stock return item wise page

  #multiple stock issue
  @scenario22
  Scenario: To verify multiple stock issue page
    When user open multiple stock issue page
    Then verify multiple stock issue page

  #stock destroy
  @scenario23
  Scenario: To verify stock destroy page
    When user open stock destroy page
    Then verify stock destroy page
