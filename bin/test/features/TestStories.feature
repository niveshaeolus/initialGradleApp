@TestAllMethods
Feature: Feature file to test all Http Methods

Scenario outline: To Test Generic methods
	Given the endpoint to hit "<api>"
	When the endpoint is hit
	Then the endpoint should list all Cars with statuscode "<statusCode>"
	
	Examples:
	|	api	|	statusCode	|
	|	cars	|	200	|	