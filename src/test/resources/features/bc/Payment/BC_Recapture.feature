@BC @Recapture_BC
Feature: BCRecaptureTransaction

  @DesignatedFunction @BCRecapture
  Scenario Outline: BC Payment Recapture
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User Creates a recapture
    Then User should be able to create and validates the "Recapture"

    Examples:
      | scenariofortestdata | excelPath                                               |
      | BCRecapture         | src/test/resources/dataExcel/bc/BC_PaymentTransfer.xlsx |
