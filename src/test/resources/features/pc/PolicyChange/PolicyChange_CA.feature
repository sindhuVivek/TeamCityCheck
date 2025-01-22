@PolicyChangeCA
Feature: PC_PolicyChange_CA

  @PolicyChangeCA
  Scenario Outline: Policy Change for CA with existing policy with Excel Modularization
    Given User logs into "PolicyCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    When User searches a existing policy
    Then User initiates policy change
    And Updates the CA policy

    Examples:
      | scenariofortestdata | excelPath                                                 |
      | CA_PolicyChange     | src/test/resources/dataExcel/pc/PC_New_Submission_CA.xlsx |
