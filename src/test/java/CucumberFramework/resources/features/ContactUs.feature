Feature: Submit data to webdriveruniversity.com using Contact Us form

Scenario: submit valid data via Contact Us form
	Given I access webdriveruniversity Contact Us form
	When I enter a valid first name
	And I enter a valid last name
	| woods | jackson | jones |
	And I enter a valid last email address
	And I enter a comments
	| comment1 | comment example two |
	And I click on the submit button
	Then the information should succesfully be submitted via the Contact Us form
	