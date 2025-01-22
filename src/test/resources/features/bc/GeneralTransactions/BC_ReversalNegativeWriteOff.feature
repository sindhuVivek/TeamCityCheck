@BC @Reversal_NegativeWriteOff
Feature: BC Negative Write-Off Reversal Transaction

  @BCNegativeWriteOffReversal
  Scenario Outline: BC Negative Write-Off Reversal "<scenariofortestdata>"
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User searches for a account
    Then User creates a negative write-off
    Then User initiates a Negative Write Off Reversal transaction
    Then the Negative Write-Off Reversal transaction is created successfully

    Examples:
      | scenariofortestdata        | excelPath                                                     |
      | BCNegativeReverseWriteOff  |  src/test/resources/dataExcel/bc/BC_SearchAccount_SearchPolicy.xlsx |