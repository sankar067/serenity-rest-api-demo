Feature: Dummy API Test

Meta:
@Test1

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Scenario_01 Dummy API Search All employees

Meta:
@Scenario_01

Given Search all employee http://dummy.restapiexample.com/api/v1/employees
Then Verify response status code 429


Scenario: Scenario_02 Dummy API Search All employees

Meta:
@Scenario_02

Given Search all employees by uri /v1/employees
Then Verify response status code 429

Scenario: Scenario_03 Dummy API Search employee

Meta:
@Scenario_03

Given Search all employees by uri /v1/employee/1
Then Verify response status code 429


Scenario: Scenario_04 Dummy API create employee(post)

Meta:
@Scenario_04
Given Create employee Url path /v1/create
When Create employee record:
    |name|salary|age|
    |Test|12345|30|
Then Verify response status code 200
And verify status: success
And verify message: Successfully! Record has been added.
