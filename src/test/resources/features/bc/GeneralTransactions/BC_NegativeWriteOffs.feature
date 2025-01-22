@BC @new_NegativeWrite-Off
Feature: Negative Write-Off

  @new_NegativeWrite-Off
  Scenario Outline: New Negative Write-Off
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User searches for a account
    Then User creates a negative write-off

    Examples:
      | scenariofortestdata | excelPath                                        |
      | BCNegativeWriteOff  | src/test/resources/dataExcel/bc/BC_SearchAccount_SearchPolicy.xlsx |

