Feature: PC Search Policy

  @PCSearchPolicyNumber
  Scenario Outline: Search Policy by Number
    Given User logs into "PolicyCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then user searches for a policy using Policy number

    Examples:
      | scenariofortestdata | excelPath                                      |
      | PolicySearch        | src/test/resources/dataExcel/pc/PC_Search.xlsx |

  @PCSearchPolicyName
  Scenario Outline: Search Policy by Name
    Given User logs into "PolicyCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then user searches for a policy using name

    Examples:
      | scenariofortestdata | excelPath                                      |
      | PolicySearch        | src/test/resources/dataExcel/pc/PC_Search.xlsx |