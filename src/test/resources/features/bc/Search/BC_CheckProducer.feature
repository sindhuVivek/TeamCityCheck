@BC @BCCheckProducer
Feature: BC Check Producer scenarios

  @BCCheckProducerUsingName
  Scenario Outline: BC Check Producer using Name "<scenariofortestdata>"
    Given scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    And User logs into "BillingCenter" application
    When User searches for producer
    Then producer is retrived and validated successfully

    Examples:
      | scenariofortestdata      | excelPath                                                     |
      | BCCheckProducerUsingName | src/test/resources/dataExcel/bc/BC_SearchAccount_SearchPolicy.xlsx |
