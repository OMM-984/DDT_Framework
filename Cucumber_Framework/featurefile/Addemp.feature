@tag
Feature: add multiple emp functionality
@addemp
Scenario Outline:
as admin user i want to add multiple emploees
Given user navigates url"http://orangehrm.qedgetech.com/"in browser
Then i verify login button displayed
When i enter "Admin" in username
And i enter "Qedge123!@#"in password
When i click login button
When i navigate to add employee page
When i enter as "<FirstName>" in first name
And i enter as "<Middlename>" in middle name
And i enter as "<lastname>"in last name
And i capture empid
And i click save button
And i search employee id
Then i validate empid in table
When i close browser
Examples:
|FirstName|Middlename|lastname|
|raja|radhe2|litu|
|test9|hari54|raja|
|radhe|team|cricket21|
|management78|football4|hockey|
|indian|money3|bank|
|try|test|team22|
