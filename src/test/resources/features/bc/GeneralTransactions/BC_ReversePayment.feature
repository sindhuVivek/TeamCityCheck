@BC @reversePayment
Feature: Disbursement

  @reversePayment
  Scenario Outline: Reverse Payment
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User searches for a account
    Then User creates a payment reverse
    Then Validate payment reverse successfully

    Examples:
    | scenariofortestdata | excelPath                                               |
    | BCReversePayment    | src/test/resources/dataExcel/bc/BC_PaymentTransfer.xlsx |