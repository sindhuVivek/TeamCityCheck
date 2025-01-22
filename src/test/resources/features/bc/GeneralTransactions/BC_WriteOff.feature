@BC @WriteOff
Feature: BC Write Off Transaction

  @BCWriteOff-policylevel
  Scenario Outline: BC Write Off policy level
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User searches for a account
    Then User initiates a Write Off transaction
    Then User searches for a policy
    Then policy should be retrieved successfully
    Then the Write-Off transaction is created successfully

    Examples:
      | scenariofortestdata | excelPath                                                           |
      | BCWriteOff          |  src/test/resources/dataExcel/bc/BC_SearchAccount_SearchPolicy.xlsx |