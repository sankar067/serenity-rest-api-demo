package com.restassured.test.stepdefinations;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import com.restassured.test.steps.RequestSteps;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class stepDefination {

    @Steps
    RequestSteps requeststeps;

    @Steps
    com.restassured.test.steps.commonSteps commonSteps;

    @Given("Create employee Url path $urlpath")
    public void saveUrl(String urlpath){
        commonSteps.saveEndpoint(urlpath);
    }

    @Given("Search all employee $url")
    public void searchEmployees(String url){
        commonSteps.keepUrl(url);
        requeststeps.doRequestEmployeeSearch();

    }

    @Then("Verify response status code $code")
    public void verifyStatusCode(int code){
        assertThat("Wrong Status Code",commonSteps.getStatusCode(),equalTo(code));
    }

    @Given("Search all employees by uri $urlpath")
    public void searchEmployeesBypath(String urlpath){
        commonSteps.saveEndpoint(urlpath);
        requeststeps.doRequestEmployeeSearch();
    }

    @When("Create employee record: $isValues")
    public void WhenCreateEmployee(ExamplesTable isValues) throws Exception{
        Map<String,String> expected = isValues.getRowAsParameters(0).values();
        for (String key: expected.keySet() ) {
            Serenity.getCurrentSession().put(key,expected.get(key));
        }
        requeststeps.doCreateEmployee();
    }

    @Then("verify $path: $msg")
    public void ThenVerifyStatus(String path,String msg){
        commonSteps.responseSatusMessage(path,msg);
    }
}
