@create_reserve
Feature: Adding reserves for claim

  @create_reserve
  Scenario Outline: Create Reserve
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  User should able to search the claim
    When  user create reserve and validate reserve is created successfully

    Examples:
      | scenariofortestdata   | excelPath                                    |
      | CreateReserve         | src/test/resources/dataExcel/cc/Reserve.xlsx |