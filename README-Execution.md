# simpleFlightSearch
The application package simpleFlightSearch consists of following 2 parts:
1. REST API developed using Spring MVC: The src folder contains the src files.
2. Angular 6.0: The source code for angular app is located within flight-search-angular folder. 

Other Environments Used:
• Java 8
• Tomcat 9
• Eclipse JEE 2019-03

Steps to execute Spring MVC application: simpleFlightSearch
1. Import War file into Eclipse environment:
2. Run the Project on Tomcat Server
3. Go to http://localhost:8080/simpleFlightSearch/ to start the REST api.

Steps to execute Angular application: 
1. Open terminal
2. cd flight-search-angular
3. ng serve -o
4. Go to http://localhost:4200/ to start the main search page within Angular.

Application Details:
The initial page loads the initial search by flight number form by default. The radio buttons allow the user to choose between Search by Flight Number or Search By City. All fields in each form are required. The search button is disabled initially, until the user enters valid data for all form fields. 

Results: The results are displayed in a tabular format as described below:
Flight Info: This column lists the carrier, flight Number and aircraft details.
Origin: This column lists the source and departure date and time.
Destination: This column lists the destination and arrival date and time.
Travel Time: This column lists travel time.
Total Miles: This column lists total miles.
Status: This column lists flight status.
