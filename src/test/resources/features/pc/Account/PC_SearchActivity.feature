Feature: PC Search Activity

  @PCSearchActivity
  Scenario Outline: Search Activity
    Given User logs into "PolicyCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then user searches for a activity with data

    Examples:
      | scenariofortestdata | excelPath                                      |
      | ActivitySearch      | src/test/resources/dataExcel/pc/PC_Search.xlsx |