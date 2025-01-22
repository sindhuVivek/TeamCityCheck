@BC @create_troubleticket
Feature: Create Trouble Ticket

@create_troubleticket
  Scenario Outline: Create Trouble Ticket
    Given User logs into "BillingCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then User searches for a account
    Then User get the count of existing trouble tickets
    Then User creates a new trouble ticket
    Then User searches for a account
    Then the trouble ticket is created successfully

    Examples:
      | scenariofortestdata   | excelPath                                             |
      | BCCreateTroubleTicket | src/test/resources/dataExcel/bc/BC_TroubleTicket.xlsx |

