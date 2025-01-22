@PCAuditScedule
Feature: PC Audit Schedule

  @PCNewAudit
  Scenario Outline: PC Audit Schedule
    Given User logs into "PolicyCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then I begin to audit the policy

    Examples: 
      | scenariofortestdata | excelPath                                            |
      | Audit   | src/test/resources/dataExcel/pc/PC_AuditSchedule.xlsx |


