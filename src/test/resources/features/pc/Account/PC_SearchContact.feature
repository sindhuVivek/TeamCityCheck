Feature: PC Search Contact

  @PCSearchContactName
  Scenario Outline: Search Contact By Name
    Given User logs into "PolicyCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then user searches the contact by Name

    Examples:
      | scenariofortestdata | excelPath                                      |
      | ContactSearch       | src/test/resources/dataExcel/pc/PC_Search.xlsx |

  @PCSearchContactCompany
  Scenario Outline: Search Contact By Name
    Given User logs into "PolicyCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then user searches the contact by Company

    Examples:
      | scenariofortestdata | excelPath                                      |
      | ContactSearch       | src/test/resources/dataExcel/pc/PC_Search.xlsx |