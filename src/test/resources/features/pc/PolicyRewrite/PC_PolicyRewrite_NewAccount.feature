@PCPolicyRewrite
Feature: PC Policy Rewrite New Account

  @PCPolicyRewriteNewAccount
  Scenario Outline: PC Policy New Account Rewrite "<scenariofortestdata>"
    Given User logs into "PolicyCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then User rewrites an existing policy to new account

    Examples:
      | scenariofortestdata     | excelPath                                             |
      | PolicyRewriteNewAccount | src/test/resources/dataExcel/pc/PC_PolicyRewrite.xlsx |