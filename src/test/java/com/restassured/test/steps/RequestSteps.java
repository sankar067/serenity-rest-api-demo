package com.restassured.test.steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class RequestSteps {

    @Step
    public void doRequestEmployeeSearch(){

        SerenityRest.given().log().all()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .when().get(Serenity.getCurrentSession().get("BaseUrl").toString());
    }

    @Step
    public void doCreateEmployee(){

    String postbody="{\n" +
            "\"name\":\""+Serenity.getCurrentSession().get("name").toString()+"\",\n" +
                "\"salary\":\""+Serenity.getCurrentSession().get("salary").toString()+"\",\n" +
                "\"age\":\""+Serenity.getCurrentSession().get("age").toString()+"\"\n" +
                "}";
    System.out.println(postbody);
        SerenityRest.given().log().all()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .body(postbody)
                .when().post(Serenity.getCurrentSession().get("BaseUrl").toString());
    }
}
