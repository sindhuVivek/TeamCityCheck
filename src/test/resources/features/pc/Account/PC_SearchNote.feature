Feature: PC Search Note

  @PCSearchNote
  Scenario Outline: Search Note
    Given User logs into "PolicyCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    When User searches a existing policy in PC
    Then user searches for a note with data

    Examples:
      | scenariofortestdata | excelPath                                      |
      | NoteSearch          | src/test/resources/dataExcel/pc/PC_Search.xlsx |
