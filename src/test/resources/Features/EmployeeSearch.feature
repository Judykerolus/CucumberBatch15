Feature: Searching the employee

  Background:
    # Background : This is used to define all the common steps that multiple
    # scenario have in the same feature file, till the time flow is not broken
    When users enters valid email and valid password
    And click on login button
    When user clicks on PIM option

  @smoke1
  Scenario: Search Employee by Id
    #Given open the browser and launch HRMS application (Hooks will execute automatically)
    #When users enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    When  user enters valid employee id
    And Clicks on search button
    And user see employee information is displayed
    #And Close the browser (Hooks will execute automatically)

    @smoke1
    Scenario: Search Employee by Job Title
      #Given open the browser and launch HRMS application (Hooks will execute automatically)
      #When users enters valid email and valid password
      #And click on login button
      #When user clicks on PIM option
      When user select Job Title
      And Clicks on search button
      And user see employee information is displayed
      #And Close the browser (Hooks will execute automatically)