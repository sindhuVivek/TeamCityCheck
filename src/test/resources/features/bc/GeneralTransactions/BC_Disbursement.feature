@BC @new_disbursement
Feature: Disbursement

  @new_disbursement
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
