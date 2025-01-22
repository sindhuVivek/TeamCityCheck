@PCPolicyRewrite
Feature: PC Policy Rewrite Full Term

  @PCPolicyRewriteFullTerm
  Scenario Outline: PC Policy Full Term Rewrite "<scenariofortestdata>"
    Given User logs into "PolicyCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then User rewrites an existing policy with the type rewrite full term

    Examples:
      | scenariofortestdata   | excelPath                                             |
      | PolicyRewriteFullTerm | src/test/resources/dataExcel/pc/PC_PolicyRewrite.xlsx |