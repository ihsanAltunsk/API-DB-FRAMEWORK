package utilities.API_Utilities;

import config_Requirements.ConfigReader;
import hooks.Base;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Authentication extends Base {
    public static void setUpApi(String userType) {
        String token;
        if (userType.equals("admin")) {
            token = Authentication.generateToken(userType);
        } else if (userType.equals("customer")) {
            token = Authentication.generateToken(userType);
        } else if (userType.equals("newCustomer")) {
            token = Authentication.generateToken(userType);
        } else {
            token = ConfigReader.getProperty( "api","invalidToken");
        }

        spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty( "api","base_url"))
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }
    public static String generateToken(String user) {

        JSONObject reqBody = null;

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("api","base_url")).build();

        switch (user) {
            case "admin":
                spec.pathParams("pp1", "api", "pp2", "login");
                reqBody = new JSONObject();
                reqBody.put("email", ConfigReader.getProperty("api","adminEmail"));
                reqBody.put("password", ConfigReader.getProperty("api","Password"));
                break;
            case "customer":
                spec.pathParams("pp1", "api", "pp2", "login");
                reqBody = new JSONObject();
                reqBody.put("email", ConfigReader.getProperty("api","customerEmail"));
                reqBody.put("password", ConfigReader.getProperty("api","Password"));
                break;
        }

        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .when()
                .body(reqBody.toString())
                .post("/{pp1}/{pp2}");


        JsonPath repJP = response.jsonPath();

        String token = repJP.getString("token");
        System.out.println("token = " + token);

        return token;
    }
}