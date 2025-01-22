@create_check
Feature: Adding checks for claim

  @create_check
  Scenario Outline: Create check
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  User should able to search the claim
    When  user create check and validate check is created successfully

    Examples:
      | scenariofortestdata | excelPath                                  |
      | CreateCheck         | src/test/resources/dataExcel/cc/Check.xlsx |