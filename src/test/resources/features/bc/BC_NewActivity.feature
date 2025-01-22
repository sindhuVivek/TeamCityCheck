@BC @new_activity
Feature: New Activity

  @DesignatedFunction @new_activity
  Scenario Outline: New Activity
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User creates a new activity
    Then activity is created successfully

    Examples:
      | scenariofortestdata | excelPath                                        |
      | BCNewAcitivity      | src/test/resources/dataExcel/bc/BC_Activity.xlsx |

