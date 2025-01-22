@assign_remove_service
Feature: Assign and Remove Service

  @assign_service
  Scenario Outline: Assign CC Service
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  User should be able to assign a service

    Examples:
      | scenariofortestdata | excelPath                                       |
      | AssignService       | src/test/resources/dataExcel/cc/CC_Service.xlsx |

  @remove_service
  Scenario Outline: Remove CC Service
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  User should be able to remove a service

    Examples:
      | scenariofortestdata | excelPath                                       |
      | RemoveService       | src/test/resources/dataExcel/cc/CC_Service.xlsx |