@BC @PaymentTransfer_BC
Feature: BCPaymentTransfer

  @BCPaymentTransferUnapplied
  Scenario Outline: BC Payment Transfer
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User makes direct bill payment without distribution
    Then User transfer the payment to other account
    Then Payment should be Transfer to other account successfully

    Examples:
      | scenariofortestdata | excelPath                                              |
      | BCPaymentTransfer   | src/test/resources/dataExcel/bc/BC_PaymentTransfer.xlsx|