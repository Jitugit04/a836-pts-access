# DataSOS Technologies Assignments

## Web Automation Project a836-pts-access
### Overview
This project is a web automation for testing bbl search from [https://a836-pts-access.nyc.gov](https://a836-pts-access.nyc.gov/care/search/CommonSearch.aspx?mode=PERSPROP) 
<br>It is taking care of below scenario -
* Read search data from QA_Automation_Task_Data.xlsx
* Traverse through each row from the excel sheet, fill in search params and click on search.
* Check if search results are present.
* Fill status field in the excel QA_Automation_Task_Data_Results.xlsx with "Success" if search result is found, and with "Failure" if search result not found.

### How to use
#### Few quick points -
* Used testng library with selenium to develop the automation project. 
* Project is built with maven.
* Project include one test class name TestApp which needs to be run.
  
#### How to run -
* Prerequisites - replace ./a836-pts-access/chromedriver.exe with exe compatible with current chrome browser version. 
* Build the project with maven (run 'mvn install' command)
* Execute Test Class: **AppTest.java**

#### Results -
This automation project has been run and the results also are included in Project folder a836-pts-access. Below is the location to the report -
* **a836-pts-access/QA_Automation_Task_Data_Results.xlsx**

## Prepare Test Cases for www.airbnb.co.in
Test cases are present at **other_assignments/Test_Cases_Airbnb_Reservation.xlsx**

## Create a training plan for fresher QA Engineer
Training plan is present at **other_assignments/Create TestPlan for QA Training.xlsx**

## Review SQL_Practical_Test_Fresher.pdf 
Update SQL sheet with answers is present at **other_assignments/SQL_Practical_Test_Updated_Answers.xlsx**
