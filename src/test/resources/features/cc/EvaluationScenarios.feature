@evaluation_scenarios
Feature: Evaluation Scenarios

  @add_evaluation
  Scenario Outline: Add Evaluation
    Given User logs into "ClaimsCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then user should be able to add a new evaluation successfully

    Examples:
      | scenariofortestdata              | excelPath                                                   |
      | AddNewEvaluation                 | src/test/resources/dataExcel/cc/CC_AddEvaluation.xlsx       |



  @edit_evaluation
  Scenario Outline: Edit Evaluation
    Given User logs into "ClaimsCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then user should be able to edit the existing evaluation successfully

    Examples:
      | scenariofortestdata              | excelPath                                                     |
      | EditEvaluation                   | src/test/resources/dataExcel/cc/CC_EditEvaluation.xlsx        |



  @delete_evaluation
  Scenario Outline: Delete Evaluation
    Given User logs into "ClaimsCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then user should be able to delete the evaluation successfully

    Examples:
      | scenariofortestdata              | excelPath                                                       |
      | EditEvaluation                   | src/test/resources/dataExcel/cc/CC_DeleteEvaluation.xlsx        |



