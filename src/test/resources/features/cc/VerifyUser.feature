@verify_user
Feature: Verified Excess claim creation

  @verify_user
  Scenario Outline: Verify User
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then user should be able to verify the user details with data Provided
    Then user was validated successfully


    Examples:
      | scenariofortestdata           | excelPath                                          |
      |  UserVerificatioScenario | src/test/resources/dataExcel/cc/VerifyUser.xlsx |