package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODQ5NzIzMDAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTAxNTUwMCwidXNlcklkIjoiNTI1MiJ9.0Gc8bnc5_y6U_Lm-MWkbutpWJ0XuvvXhr3oLPzpkwxA";
    static String employee_id;


    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification preparedRequest = given().header("Content-Type","application/json").
                header("Authorization", token).queryParam("employee_id",employee_id);

        // hitting the endpoint
        Response response= preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        //verify the response
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void acreateEmployee(){
        //prepare the request
        RequestSpecification preparedRequest = given().header("Content-Type","application/json").
                header("Authorization",token).body("{\n" +
                        "  \"emp_firstname\": \"Leonard\",\n" +
                        "  \"emp_lastname\": \"Ring\",\n" +
                        "  \"emp_middle_name\": \"Ma\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2001-05-20\",\n" +
                        "  \"emp_status\": \"Confirmed\",\n" +
                        "  \"emp_job_title\": \"QA\"\n" +
                        "}");

        //hitting the endpoint / send the request
        Response response = preparedRequest.when().post("/createEmployee.php");
        //to print the output in the console
        response.prettyPrint();

        //verifying the assertions / get response
        response.then().assertThat().statusCode(201);

       // we are capturing employee from the response
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        // verifying the firstname in the response body
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Leonard"));
        response.then().assertThat().body("Employee.emp_lastname", equalTo("Ring"));

        //verify the response headers
        response.then().assertThat().header("Content-Type","application/json");
        System.out.println("My test case is passed");
    }
}
