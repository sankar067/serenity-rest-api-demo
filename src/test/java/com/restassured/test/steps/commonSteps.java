package com.restassured.test.steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class commonSteps {

    private EnvironmentVariables environmentVariables;

    @Step
    public void saveEndpoint(String UrlPath){
        String baseUrl= EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("url");
        Serenity.getCurrentSession().put("BaseUrl",baseUrl + UrlPath);

    }

    @Step
    public void keepUrl(String Url){
        Serenity.getCurrentSession().put("BaseUrl",Url);
    }

    public int getStatusCode(){
        return SerenityRest.then().extract().statusCode();
    }

    public void responseSatusMessage(String path,String message){
        assertThat("Wrong Status Message",SerenityRest.then().extract().response().jsonPath().get(path).toString(),equalTo(message));
    }
    @Step
    public void Captured(String msg){}
}
