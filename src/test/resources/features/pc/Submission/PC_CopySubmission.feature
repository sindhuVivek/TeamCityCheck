@CopySubmission
Feature: PC Copy Submission

  Background:
    Given I am a user with the Producer role

  @PC_CopySubmission
  Scenario Outline: PC Copy Submission "<scenariofortestdata>"
    Given scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    When User perform Copy Submission Transaction
    Then User should be able to copy submission and issue a Policy.

    Examples:
      | scenariofortestdata | excelPath                                         |
      | CopySubmission      | ui/modularizedExcelData/pc/PC_Copy_Submission.xlsx |
