Feature:  Employee
  # you use more than one tag name for same scenario for grouping test cases
  Background:
    When users enters valid email and valid password
    And click on login button
    When user clicks on PIM option
    And user clicks on add employee button

  @testcase2 @smoke
  Scenario: Adding a new Employee
    #Given open the browser and launch HRMS application
    #When users enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    #And user clicks on add employee button
    And user enters firstname and middlename and lastname
    #And user clicks on save button
    #And Close the browser
@smoke513
Scenario: Adding the employee from front end and verifying it from back end
  #Given open the browser and launch HRMS application
    #When users enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    #And user clicks on add employee button
    And user enters "nesha" and "sania" and "standart"
    And user captures the employee id
    And user clicks on save button
    And query the information in backend
    Then verify the results from frontend and backend