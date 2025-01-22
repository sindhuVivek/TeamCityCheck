@BC @reverse_write_offs
Feature: BC Reverse Write-Off Transaction

  @reverse_write_offs
  Scenario Outline: BC Reverse Write-Off
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User searches for a account
    Then User initiates a Write Off transaction
    Then User initiates a Reverse Write Off transaction
    Then Validate the Reverse Write Off created successfully

    Examples:
      | scenariofortestdata | excelPath                                               |
      | BCReverseWriteOff   | src/test/resources/dataExcel/bc/BC_SearchAccount_SearchPolicy.xlsx |