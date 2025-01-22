@search_service
Feature: Search New Service

  @search_service
  Scenario Outline: Search Service
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user should be able to search the service

    Examples:
      | scenariofortestdata | excelPath                                       |
      | SearchService    | src/test/resources/dataExcel/cc/CC_Service.xlsx |
