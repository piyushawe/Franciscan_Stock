Feature: Stock Reports
     As a user I would like to open all the stock reports
     So that I can verify that there is no problem in report loading

  Background: 
    Given user enter "http://qaerp.franciscanecare.net"
    When user enter username "admin" and password "Admin#franciscan"
    And passes school name "qaerp"
    And click signin
    Then stock home page is opened

  #stock purchase order report
  @scenario1
  Scenario Outline: To open stock purchase order report
    Given opened stock purchase order report
    When user select from date as month "April" year "2017" and day "1" on stock purchase order report page
    And select to date as month "April" year "2017" and day "30" on stock purchase order report page
    And select item name "<item name>" on stock purchase order report page
    And select brand name "<brand name>" on stock purchase order report page
    And select vendor name "<vendor name>" on stock purchase order report page
    And select order "<order>" on stock purchase order report page
    Then stock purchase order report is opened

    Examples: 
      | item name | brand name | vendor name | order      |
      | All Item  | All Brand  | All Vendors | All Orders |

  #challan report
  @scenario2
  Scenario Outline: To open challan report
    Given opened challan report
    When user select from date as month "April" year "2017" and day "1" on challan report page
    And select to date as month "April" year "2017" and day "30" on challan report page
    And select item name "<item name>" on challan report page
    And select brand name "<brand name>" on challan report page
    And select vendor name "<vendor name>" on challan report page
    Then challan report is opened

    Examples: 
      | item name | brand name | vendor name   |
      | All Item  | All Brand  | Stock Manager |

  #purchase return report
  @scenario3
  Scenario Outline: To open purchase return report
    Given opened purchase return report
    When user select from date as month "April" year "2017" and day "1" on purchase return report
    And select to date as month "April" year "2017" and day "30" on purchase return report
    And select item name "<item name>" on purchase return report
    And select brand name "<brand name>" on purchase return report
    And select vendor name "<vendor name>" on purchase return report
    Then purchase return report is opened

    Examples: 
      | item name | brand name | vendor name |
      | All Item  | All Brand  | All Vendors |

  #stock in entry report
  @scenario4
  Scenario Outline: To open stock in entry report
    Given opened stock in entry report
    When user select from date as month "April" year "2017" and day "1" on stock in entry report
    And select to date as month "April" year "2017" and day "30" on stock in entry report
    And select item name "<item name>" on stock in entry report
    And select brand name "<brand name>" on stock in entry report
    And select vendor name "<vendor name>" on stock in entry report
    And select receipt no "<receipt no>" on stock in entry report
    Then stock in entry report is opened

    Examples: 
      | item name | brand name | vendor name   | receipt no |
      | All Item  | All Brand  | Stock Manager |          3 |

  #stock bill report
  @scenario5
  Scenario Outline: To open stock bill report
    Given opened stock bill report
    When user select from date as month "April" year "2017" and day "1" on stock bill report
    And select to date as month "April" year "2017" and day "30" on stock bill report
    And select item name "<item name>" on stock bill report
    And select brand name "<brand name>" on stock bill report
    And select vendor name "<vendor name>" on stock bill report
    Then stock bill report is opened

    Examples: 
      | item name | brand name | vendor name   |
      | All Item  | All Brand  | Stock Manager |

  #employee issue report
  @scenario6
  Scenario Outline: To open employee issue report
    Given opened employee issue report
    When user select from date as month "April" year "2017" and day "1" on employee issue report
    And select to date as month "April" year "2017" and day "30" on employee issue report
    And select item name "<item name>" on employee issue report
    And select brand name "<brand name>" on employee issue report
    And select employee name "<employee name>" on employee issue report
    Then employee issue report is opened

    Examples: 
      | item name | brand name | employee name |
      | All Item  | All Brand  | All Employee  |

  #employee return report
  @scenario7
  Scenario Outline: To open employee return report
    Given opened employee return report
    When user select from date as month "April" year "2017" and day "1" on employee return report
    And select to date as month "April" year "2017" and day "30" on employee return report
    And select item name "<item name>" on employee return report
    And select brand name "<brand name>" on employee return report
    And select employee name "<employee name>" on employee return report
    Then employee return report is opened

    Examples: 
      | item name | brand name | employee name |
      | All Item  | All Brand  | All Employee  |

  #stock issue report
  @scenario8
  Scenario Outline: To open stock issue report when employee is clicked
    Given opened stock issue report
    When user select from date as month "April" year "2017" and day "1" on stock issue report
    And select to date as month "April" year "2017" and day "30" on stock issue report
    And select item name "<item name>" on stock issue report
    And select brand name "<brand name>" on stock issue report
    And click employee on stock issue report
    And select issue to "<name>" on stock issue report
    Then stock issue report is opened

    Examples: 
      | item name | brand name | name         |
      | All Item  | All Brand  | ANITA MISHRA |

  @scenario9
  Scenario Outline: To open stock issue report when other is clicked
    Given opened stock issue report
    When user select from date as month "April" year "2017" and day "1" on stock issue report
    And select to date as month "April" year "2017" and day "30" on stock issue report
    And select item name "<item name>" on stock issue report
    And select brand name "<brand name>" on stock issue report
    And click other on stock issue report
    Then stock issue report is opened

    Examples: 
      | item name | brand name |
      | All Item  | All Brand  |

  #other return report
  @scenario10
  Scenario Outline: To open other return report
    Given opened other return report
    When user select from date as month "April" year "2017" and day "1" on other return report
    And select to date as month "April" year "2017" and day "30" on other return report
    And select item name "<item name>" on other return report
    And select brand name "<brand name>" on other return report
    Then other return report is opened

    Examples: 
      | item name | brand name |
      | All Item  | All Brand  |

  #stock opening report
  @scenario11
  Scenario Outline: To open stock opening report
    Given opened stock opening report
    When user select on dated as month "April" year "2017" and day "1" on stock opening report
    And select item name "<item name>" on stock opening report
    And select brand name "<brand name>" on stock opening report
    Then stock opening report is opened

    Examples: 
      | item name | brand name |
      | All Item  | All Brand  |

  #active stock report
  @scenario12
  Scenario Outline: To open active stock report
    Given opened active stock report
    When user select from date as month "April" year "2017" and day "1" on active stock report
    And select to date as month "April" year "2017" and day "30" on active stock report
    And select category "<category>" on active stock report
    And select sub category "<sub category>" on active stock report
    And select item name "<item name>" on active stock report
    And select brand name "<brand name>" on active stock report
    Then active stock report is opened

    Examples: 
      | item name | brand name | category     | sub category     |
      | All Item  | All Brand  | All Category | All Sub Category |

  #cucmulative stock statement value wise
  @scenario13
  Scenario Outline: To open cucmulative stock statement value wise
    Given opened cucmulative stock statement value wise
    When user select from date as month "April" year "2017" and day "1" on cucmulative stock statement value wise
    And select to date as month "April" year "2017" and day "30" on cucmulative stock statement value wise
    And select category "<category>" on cucmulative stock statement value wise
    And select sub category "<sub category>" on cucmulative stock statement value wise
    And select item name "<item name>" on cucmulative stock statement value wise
    Then cucmulative stock statement value wise  is opened

    Examples: 
      | item name | category | sub category |
      | All       | All      | All          |

  #stock ledger
  @scenario14
  Scenario Outline: To open stock ledger
    Given opened stock ledger
    When user select from date as month "April" year "2017" and day "1" on stock ledger
    And select to date as month "April" year "2017" and day "30" on stock ledger
    And select category "<category>" on stock ledger
    And select sub category "<sub category>" on stock ledger
    And select item name "<item name>" on stock ledger
    And select brand name "<brand name>" on stock ledger
    Then stock ledger is opened

    Examples: 
      | item name | category | sub category | brand name |
      | All       | All      | All          | All        |

  #max stock report
  @scenario15
  Scenario Outline: To open max stock report
    Given opened max stock report
    When user select date as month "April" year "2017" and day "1" on max stock report
    And select item name "<item name>" on max stock report
    And select brand name "<brand name>" on max stock report
    Then max stock report is opened

    Examples: 
      | item name | brand name |
      | All Item  | All Brand  |

  #min stock report
  @scenario16
  Scenario Outline: To open min stock report
    Given opened min stock report
    When user select date as month "April" year "2017" and day "1" on min stock report
    And select item name "<item name>" on min stock report
    And select brand name "<brand name>" on min stock report
    Then min stock report is opened

    Examples: 
      | item name | brand name |
      | All Item  | All Brand  |

  #item master report
  @scenario17
  Scenario Outline: To open item master report
    Given opened item master report
    And select category "<category>" on item master report
    And select sub category "<sub category>" on item master report
    Then item master report is opened

    Examples: 
      | category     | sub category     |
      | All Category | All Sub Category |
