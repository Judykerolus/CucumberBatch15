package APIReview;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class APIexamples {

    String baseURI = RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    String token ="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUwNTg0ODAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTEwMTY4MCwidXNlcklkIjoiNTI1MiJ9.Swovk0UTaB6r-eXCq6uMk19SdcvjjjHMBtR_ggqtheY";

    @Test
    public void createAnEmployee(){
     RequestSpecification preparedRequest = given().header("Content-Type","application/json").header("Authorization",token).body("{\n" +
             "  \"emp_firstname\": \"Leonard\",\n" +
             "  \"emp_lastname\": \"Ring\",\n" +
             "  \"emp_middle_name\": \"Ma\",\n" +
             "  \"emp_gender\": \"F\",\n" +
             "  \"emp_birthday\": \"2001-05-20\",\n" +
             "  \"emp_status\": \"Confirmed\",\n" +
             "  \"emp_job_title\": \"QA\"\n" +
             "}");

     //prepared request ---> attached all the data for the request
     Response response = preparedRequest.when().post("/createEmployee.php");
     response.prettyPrint();

        //        verification of status
        response.then().assertThat().statusCode(201);

     // verify that "emp_job_title" is cloud Architect
        //actual = coming from response
        //expected= "QA"
        String expected = "QA";
        String actual = response.jsonPath().getString("Employee.emp_job_title");
        Assert.assertEquals(expected,actual);
        // other way
       // response.then().assertThat().body("Employee.emp_job_title",equalTo("QA"));

    }
}
