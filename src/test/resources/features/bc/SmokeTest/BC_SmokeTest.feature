@SmokeTest
Feature: BC Smoke Test

  Scenario Outline: Create Activity
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User creates a new activity
    Then activity is created successfully
    Examples:
      | scenariofortestdata | excelPath                                        |
      | BCNewAcitivity      | src/test/resources/dataExcel/bc/BC_Activity.xlsx |

  Scenario Outline: Create Trouble Ticket
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User searches for a account
    Then User get the count of existing trouble tickets
    Then User creates a new trouble ticket
    Then User searches for a account
    Then the trouble ticket is created successfully
    Examples:
      | scenariofortestdata   | excelPath                                             |
      | BCCreateTroubleTicket | src/test/resources/dataExcel/bc/BC_TroubleTicket.xlsx |

  Scenario Outline: New Disbursement
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User makes direct bill payment without distribution
    Then User searches for a account
    Then User creates a new disbursement
    Then Validate the disbursement created successfully
    Examples:
      | scenariofortestdata | excelPath                                                          |
      | BCDisbursement      | src/test/resources/dataExcel/bc/BC_SearchAccount_SearchPolicy.xlsx |

  Scenario Outline: Create Write-Off and Reverse
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User searches for a account
    Then User initiates a Write Off transaction
    Then User initiates a Reverse Write Off transaction
    Then Validate the Reverse Write Off created successfully
    Examples:
      | scenariofortestdata | excelPath                                                          |
      | BCReverseWriteOff   | src/test/resources/dataExcel/bc/BC_SearchAccount_SearchPolicy.xlsx |

  Scenario Outline: Create Negative Write-Off and Reverse
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User searches for a account
    Then User creates a negative write-off
    Then User initiates a Negative Write Off Reversal transaction
    Then the Negative Write-Off Reversal transaction is created successfully
    Examples:
      | scenariofortestdata | excelPath                                                          |
      | BCNegativeReverseWriteOff   | src/test/resources/dataExcel/bc/BC_SearchAccount_SearchPolicy.xlsx |

  Scenario Outline: Create Payment and Reverse
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User searches for a account
    Then User makes direct bill payment without distribution
    Then User searches for a account
    Then User creates a payment reverse
    Then Validate payment reverse successfully
    Examples:
      | scenariofortestdata | excelPath                                               |
      | BCReversePayment    | src/test/resources/dataExcel/bc/BC_PaymentTransfer.xlsx |

  Scenario Outline: Create Payment and Transfer
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User makes direct bill payment without distribution
    Then User transfer the payment to other account
    Then Payment should be Transfer to other account successfully
    Examples:
      | scenariofortestdata | excelPath                                              |
      | BCPaymentTransfer   | src/test/resources/dataExcel/bc/BC_PaymentTransfer.xlsx|

  Scenario Outline: Create Payment and Suspense
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User makes direct bill payment with distribution
    Then User make a payment suspense
    Then Validate the payment suspense created successfully
    Examples:
      | scenariofortestdata | excelPath                                                   |
      | BCPaymentSuspense   | src/test/resources/dataExcel/bc/BC_PaymentTransfer.xlsx     |

  Scenario Outline: Payment Recapture
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User Creates a recapture
    Then User should be able to create and validates the "Recapture"
    Examples:
      | scenariofortestdata | excelPath                                               |
      | BCRecapture         | src/test/resources/dataExcel/bc/BC_PaymentTransfer.xlsx |