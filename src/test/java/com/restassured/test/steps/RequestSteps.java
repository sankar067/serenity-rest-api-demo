package com.restassured.test.steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class RequestSteps {



    @Step
    public void doRequestEmployeeSearch(){

//        #1	/employee	GET	JSON	http://dummy.restapiexample.com/api/v1/employees	Get all employee data	Details
//        2	/employee/{id}	GET	JSON	http://dummy.restapiexample.com/api/v1/employee/1	Get a single employee data	Details
//        3	/create	POST	JSON	http://dummy.restapiexample.com/api/v1/create	Create new record in database	Details
//        4	/update/{id}	PUT	JSON	http://dummy.restapiexample.com/api/v1/update/21	Update an employee record	Details
//        5	/delete/{id}	DELETE	JSON	http://dummy.restapiexample.com/api/v1/delete/2	Delete an employee record	Details

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
