@create_activity
Feature: CP Quick claim creation

  @create_activity
  Scenario Outline: Verified CP claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user clicks on action menu to create a new activity

    Examples:
      | scenariofortestdata   | excelPath                                              |
      | CreateActivityScenario | src/test/resources/dataExcel/cc/CreateActivity.xlsx |
