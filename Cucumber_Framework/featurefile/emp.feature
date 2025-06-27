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

