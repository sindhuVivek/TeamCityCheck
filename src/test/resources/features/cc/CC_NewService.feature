@create_new_service
Feature: Create New Service

  @create_new_service
  Scenario Outline: Create New Service
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user create a new service from action menu

    Examples:
      | scenariofortestdata | excelPath                                       |
      | CreateNewService    | src/test/resources/dataExcel/cc/CC_Service.xlsx |
