@BC @create_directbillnewpayment
Feature: NewPayment_WithDistribution

  @BCDirectBillNewPaymentWithDistribution
  Scenario Outline: BC Direct Bill New Payment "<scenariofortestdata>"
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User makes direct bill payment with distribution

    Examples:
      | scenariofortestdata    | excelPath                                                     |
      | BCNewPaymentWithDistribution | src/test/resources/dataExcel/bc/BC_SearchAccount_SearchPolicy.xlsx |

