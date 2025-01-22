Feature: PC Search Account

  @PCSearchAccountNumber
  Scenario Outline: Search Account
    Given User logs into "PolicyCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then user searches the account using account number

    Examples:
      | scenariofortestdata | excelPath                                      |
      | AccountSearch       | src/test/resources/dataExcel/pc/PC_Search.xlsx |

  @PCSearchAccountName
  Scenario Outline: Search Account
    Given User logs into "PolicyCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then user searches the account using account number

    Examples:
      | scenariofortestdata | excelPath                                      |
      | AccountSearch       | src/test/resources/dataExcel/pc/PC_Search.xlsx |

  @PCSearchAccountCompany
  Scenario Outline: Search Account
    Given User logs into "PolicyCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then user searches the account using account number

    Examples:
      | scenariofortestdata | excelPath                                      |
      | AccountSearch       | src/test/resources/dataExcel/pc/PC_Search.xlsx |