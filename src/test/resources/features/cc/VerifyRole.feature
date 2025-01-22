@verify_role
Feature: Verify Role

  @verify_role
  Scenario Outline: Verify Role
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then user should be able to verify the role details with data Provided
    And role was validated successfully


    Examples:
      | scenariofortestdata           | excelPath                                          |
      |  RolesVerificationScenario | src/test/resources/dataExcel/cc/VerifyRole.xlsx |