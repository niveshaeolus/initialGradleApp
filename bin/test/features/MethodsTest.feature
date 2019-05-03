@TestHttpMethods
Feature: testing all http methods

Scenario Outline: testing get Scenario
	Given the endpoint to hit "<api>"
	When the endpoint is hit
	Then the endpoint should list all Cars with statuscode "<statusCode>"
	
	Examples:
	|	api	|	statusCode	|
	|	cars	|	200	|	
