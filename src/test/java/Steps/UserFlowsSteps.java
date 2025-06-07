package Steps;

import apiController.employeeApiServiceController;
import data.EmployeeData;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static apiController.employeeApiServiceController.generateEmployeeId;
import static apiController.employeeApiServiceController.generateRandomEmail;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class UserFlowsSteps {


    public EmployeeData empData;
    Response response;
    String empID;

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

         response = employeeApiServiceController.addNewEmployee(empData);


        String employeeID = response
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

    @Given("^Signup employee Management system with new email and password$")
    public void createUserWithNewMailID()
    {
        String emilid=generateRandomEmail();
        String skills[] = {"RestAssured","Java"};
        empData.setId("1");
        empData.setName("Scott12");
        empData.setLocation("France");
        empData.setPhone("12345");
        empData.setSkills(skills);
        empData.setEmailID(emilid);
    }

    @Given("^user tries to signup the store with new credentials$")
    public void signUpWithNewCredentials()
    {
        response = employeeApiServiceController.addNewEmployee(empData);
        System.out.println("Debug");

    }

    @Given("^validate whether a new user is created with response code 200 and response message User created successfully after signup$")
    public void validateStatusCodeAfterCreationOfNewUser()
    {
        // Here we have to create test case with New Email ID
        int StatusCode = response.statusCode();
        Assert.assertEquals(StatusCode,201,"Status code does not match so failing the test case");
    }

    @Given("^Get all employee list from get api call$")
    public void getAllEmployeesByGetAPICall()
    {
        response = employeeApiServiceController.getAllEmployees();


    }

    @Given("^Verify that status code is 200$")
    public void verifyStatusCode()
    {
        int StatusCode = response.statusCode();
        Assert.assertEquals(StatusCode,200,"Status code does not match so failing the test case");
    }

    @Given("^Verify that status code is 201$")
    public void verifyStatusCode201()
    {
        int StatusCode = response.statusCode();
        Assert.assertEquals(StatusCode,201,"Status code does not match so failing the test case");
    }

    @Given("^Get employee by id$")
    public void getEmployeeByiD()
    {
        response = employeeApiServiceController.getEmployeeById("1");
    }

    @Given("^Get employee by id in flow$")
    public void getEmployeeByiDInflow()
    {
        response = employeeApiServiceController.getEmployeeById(empID);
    }

    @Given("^Add an employee for a given employee ID$")
    public void addEmployeeWithNewEmpID()
    {
        String emilid=generateRandomEmail();
        String skills[] = {"RestAssured","Java"};
        empData.setId(empID);
        empData.setName("Scott12");
        empData.setLocation("France");
        empData.setPhone("12345");
        empData.setSkills(skills);
        empData.setEmailID(emilid);

        // Create a new employee with the help of same employee id

        response = employeeApiServiceController.addNewEmployee(empData);
    }

    @Given("^I delete same employee$")
    public void deleteEmployeeById()
    {
        response = employeeApiServiceController.deleteEmployeeById(empID);

    }

    @Given("^generate a four digit random employee id$")
    public void generateFourDigitRandomId()
    {
        empID = generateEmployeeId();

    }

    @Given("^Verify that status code is 404$")
    public void verifyStatusCodeAs404()
    {
        int StatusCode = response.statusCode();
        Assert.assertEquals(StatusCode,404,"Status code does not match so failing the test case");
    }


    @Given("^I update employee details using put api call$")
    public void updateEmployeeDetails()
    {

        String emilid=generateRandomEmail();
        String skills[] = {"RestAssured","python"};
        empData.setName("Scott12");
        empData.setLocation("France");
        empData.setPhone("12345");
        empData.setSkills(skills);
        empData.setEmailID(emilid);

        response = employeeApiServiceController.updateEmployeeDetails(empID,empData);

    }
}
