Feature: Contact page functionality for Jupiter Toys website

 As a user of the Jupiter Toys website
 I want to be able to submit a message
 So that Jupiter Toys recieves a message with my information
 
 Background:
 	Given I am on the Jupiter Toys contact page
 
 Scenario Outline: Unsuccessful submission of info and message
 	Given I have entered invalid "<forename>", "<email>", "<message>"
 	When I click Submit button
 	Then I should see the following error messages indicating "<header_err_msg>", "<forename_err_msg>", "<email_err_msg>", "<msg_err_msg>"

Examples:
	| forename	| email	| message | header_err_msg 																																				 | forename_err_msg 		 | email_err_msg              | msg_err_msg         |
	|	          |       |         | We welcome your feedback - but we won't get it unless you complete the form correctly. | Forename is required  | Email is required          | Message is required |
	|	          | test  |         | We welcome your feedback - but we won't get it unless you complete the form correctly. | Forename is required  | Please enter a valid email | Message is required |
	
	
 Scenario: Successful submission of info and message
 	Given I have entered valid information and message
 	When I click Submit button
 	Then I should be able to send the feedback successfully 
 	
Examples:
	| forename	 | email	           | message   | 
	|	Forename01 | Email01@email.com | Message01 |
	|	Forename02 | Email02@email.com | Message02 |
	|	Forename03 | Email03@email.com | Message03 |
	|	Forename04 | Email04@email.com | Message04 |
	|	Forename05 | Email05@email.com | Message05 |