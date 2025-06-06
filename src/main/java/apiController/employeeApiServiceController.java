package apiController;

import constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.configController;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class employeeApiServiceController {

    static String baseUrl = configController.get("baseUrl");
    static String endpoint = configController.get("studentsPort");

    public static Response addNewEmployee(Object empData) {
        RequestSpecification request = given().baseUri(baseUrl)
                .contentType("application/json")
                .body(empData);

        return request
                .when()
                .post(EndPoints.SING_UP);
    }
}