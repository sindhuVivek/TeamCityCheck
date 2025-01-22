  @BC  @BCPaymentSuspense
  Feature: BCPaymentSuspense

    @BCPaymentSuspense
    Scenario Outline: BC Payment Suspense
      Given User logs into "BillingCenter" application
      When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
      Then User makes direct bill payment with distribution
      Then User make a payment suspense
      Then Validate the payment suspense created successfully
      Examples:
        | scenariofortestdata | excelPath                                                   |
        | BCPaymentSuspense   | src/test/resources/dataExcel/bc/BC_PaymentTransfer.xlsx     |
