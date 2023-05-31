Feature: login Functionalities
  # to run the whole test case scenarios we click on Feature run

  @smoke
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application (Hooks will execute automatically)
    When users enters valid email and valid password
    And click on login button
    Then user is logged in successfully
    #And Close the browser (Hooks will execute automatically)

  @smoke2
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application (Hooks will execute automatically)
    When users enters valid "admin" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully
    #And Close the browser (Hooks will execute automatically)

  @scenarioOutline
  #Parameterization/ Data Driven
  Scenario Outline: Login with multiple credential using scenario outline
    #Given open the browser and launch HRMS application
    When users enters valid "<username>" and valid "<password>"
    And click on login button
    Then user is logged in successfully
    #And Close the browser
    Examples:
     |username| password|
     |admin   | Hum@nhrm123|
     |ADMIN   | Hum@nhrm123|
     |Jason   | Hum@nhrm123|

  @dataTable
  Scenario: Login with multiple credentials using data table
    When user enters username and password and verifies login
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |



    #HOOKS: For defining pre and post steps in any Cucumber framework
    #    : This is a class that will always be created inside the StepDefinitions folder

  # Cucumber Expression

  #Scenario outline
  #Browser will open and close number of times of the test data
  # we use it if we want to use parameterization
  # or if you wish to implement data driven testing
  # Scenario Outline is always used along with the keyword 'Examples
