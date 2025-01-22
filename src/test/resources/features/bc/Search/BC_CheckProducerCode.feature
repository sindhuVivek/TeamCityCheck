@BC @BCCheckProducerUsingCode
Feature: BC Check Producer scenarios

  @BCCheckProducerUsingCode
  Scenario Outline: BC Check Producer using code "<scenariofortestdata>"
    Given scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    And User logs into "BillingCenter" application
    When User searches for producer code
    Then producer code is retrived and validated successfully

    Examples:
      | scenariofortestdata      | excelPath                                                     |
      | BCCheckProducerUsingCode | src/test/resources/dataExcel/bc/BC_SearchAccount_SearchPolicy.xlsx |
