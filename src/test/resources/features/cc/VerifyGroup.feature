@verify_group
Feature: Verify Group

  @verify_group
  Scenario Outline: Verify Group
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then user should be able to verify the group details with data Provided
    And group was validated successfully


    Examples:
      | scenariofortestdata           | excelPath                                          |
      |  GroupVerificationScenario | src/test/resources/dataExcel/cc/VerifyGroup.xlsx |