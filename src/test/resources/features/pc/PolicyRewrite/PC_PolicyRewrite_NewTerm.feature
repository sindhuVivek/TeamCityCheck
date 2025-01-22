@PCPolicyRewrite
Feature: PC Policy Rewrite New Term

  @PCPolicyRewriteNewTerm
  Scenario Outline: PC Policy New Term Rewrite "<scenariofortestdata>"
    Given User logs into "PolicyCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then User rewrites an existing policy with the type rewrite new term

    Examples:
      | scenariofortestdata  | excelPath                                             |
      | PolicyRewriteNewTerm | src/test/resources/dataExcel/pc/PC_PolicyRewrite.xlsx |