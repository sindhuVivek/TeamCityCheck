@PCCopySubmission
Feature: PC Copy Submission

  @PCCopySubmission
  Scenario Outline: Verified Copy Submission
    Given User logs into "PolicyCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    When User searches a existing policy
    When User perform Copy Submission Transaction
    Then User should be able to copy submission and issue a Policy.

    Examples:
      | scenariofortestdata   | excelPath                                               |
      | CopySubmission        | src/test/resources/dataExcel/pc/PC_Copy_Submission.xlsx |
