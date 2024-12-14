Feature: As Admin Need to add Employee

  Scenario Outline: Verify Employee creation with multiple Set data
    Given User navigates url in a Browser
    When User logs with username as "Admin" and password as "Qedge123!@#"
    When User click Login buton
    When User CLick PIM button  and CLick Add button
    When User Enter Firstname as "<Fname>"
    When User Enter Middlename as "<Middlename>"
    When User Enter Lastname as "<Lastname>"
    When user Capture Employee ID in runtime before Adding Save button
    When User CLick Save as button
    When User Capture Employee ID after Adding in personal info
    Then User Validates with Employee ID
    Then User Added Successfully can close browser

    Examples: 
      | Fname      | Middlename | Lastname |
      | Shraddha1  | Testing2   | Rajput3  |
      | Shraddha4  | Testing5   | Rajput6  |
     
