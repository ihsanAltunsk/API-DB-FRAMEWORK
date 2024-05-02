@API-DB
Feature: API - As a user/administrator, I should be able to create a new customer record in the system via API connection.
  Scenario: TC01 User verifies whether a customer created through the API using an API connection exists in the customer list.
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/register" path parameters
    * The api user prepares a POST request body for register.
    * The API user sends a "POST" request and records the response.
    * The api user verifies that the status code is 201
    * The api user verifies that the message information in the response body is "Successfully registered"
    * The API user saves the information.