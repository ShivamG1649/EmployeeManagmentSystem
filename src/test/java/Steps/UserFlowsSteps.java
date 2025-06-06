package Steps;

import apiController.employeeApiServiceController;
import data.EmployeeData;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class UserFlowsSteps {


    public EmployeeData empData ;

    String studentId;

    public UserFlowsSteps() {
        this.empData=new EmployeeData();
    }



    List<HashMap<String,Object>> allEmpList=new ArrayList<>();

//    HashMap<String,Object> employeeDetails=new HashMap<>();

    @Given("^Adding the new employee into the store after successful login of user into the system$")
    public void AddingTheNewEmployeeIntoTheStoreAfterSuccessfulLoginOfUserIntoTheSystem()
    {
        String skills[] = {"C","C++"};

        empData.setId("1");
        empData.setName("Scott12");
        empData.setLocation("France");
        empData.setPhone("12345");
        empData.setSkills(skills);


        Long uniqueIdentifier=System.nanoTime();
//
//        employeeDetails.put("id", "1");
//        employeeDetails.put("name", "Scott12");
//        employeeDetails.put("location","France");
//        employeeDetails.put("phone","12345");
//        employeeDetails.put("Skills",skills);

//
//        studentId=given()
//                .contentType("application/json")
//                .body(empData)
//                .when()
//                .post("http://localhost:3000/students")
//                .then()
//                .statusCode(201)
//                .body("name", equalTo(empData.getName()))
//                .body("location", equalTo(empData.getLocation()))
//                .body("phone", equalTo(empData.getPhone()))
//                .header("Content-Type","application/json")
//                .log().body()
//                .extract().jsonPath().getString("id");

        Response response = employeeApiServiceController.addNewEmployee(empData);


        String studentId = response
                .then()
                .statusCode(201)
                .body("name", equalTo(empData.getName()))
                .body("location", equalTo(empData.getLocation()))
                .body("phone", equalTo(empData.getPhone()))
                .header("Content-Type", "application/json")
                .log().body()
                .extract()
                .jsonPath()
                .getString("id");



    }




}
