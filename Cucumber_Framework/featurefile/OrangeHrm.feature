@tag
Feature: login functionality feature
in order to ensure login functionality works,
i want to run the cucumber test to verify its working
@loginwithvalid
Scenario: login functionality
Given user navigates url"http://orangehrm.qedgetech.com/"in browser
Then i verify login button displayed
When i enter "Admin" in username
And i enter "Qedge123!@#"in password
When i click login button
Then i verify url contains dashboard text
When i close browser 
@multipledata
Scenario Outline:
login functionality with multiple data 
Given user navigates url"http://orangehrm.qedgetech.com/"in browser
Then i verify login button displayed
When i enter "<username>" in username
And i enter "<password>"in password 
When i click login button 
Then i verify url contains dashboard text
When i close browser 
Examples:
|username|password|
|Admin|Qedge123!@#|
|Admin|Qedge|
|Test|Qedge123!@#|
||Qedge123!@#|
|Admin||
|||
|admin|Qedgr75|


