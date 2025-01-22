@search_activity
Feature: CP Quick claim creation

  @search_activity
  Scenario Outline: Verified CP claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user should be able to search created activity

    Examples:
      | scenariofortestdata   | excelPath                                              |
      | SearchActivityScenario | src/test/resources/dataExcel/cc/CreateActivity.xlsx |
