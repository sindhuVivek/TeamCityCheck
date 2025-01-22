@PCPolicyRewrite
Feature: PC Policy Rewrite Remainder of the Term

  @PCPolicyRewriteRemainderOfTerm
  Scenario Outline: PC Policy Remainder of the Term Rewrite "<scenariofortestdata>"
    Given User logs into "PolicyCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then User rewrites an existing policy with the type rewrite remainder of term

    Examples:
      | scenariofortestdata          | excelPath                                             |
      | PolicyRewriteRemainderOfTerm | src/test/resources/dataExcel/pc/PC_PolicyRewrite.xlsx |