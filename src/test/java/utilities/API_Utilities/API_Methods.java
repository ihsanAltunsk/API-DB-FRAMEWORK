package utilities.API_Utilities;

import hooks.Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class API_Methods extends Base{

    public static Response getResponse() {
        response = given()
                .spec(spec)
                .when()
                .get(fullPath);

        response.prettyPrint();

        return response;
    }

    public static Response getBodyResponse(Object requestBody) {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .get(fullPath);

        response.prettyPrint();

        return response;
    }

    public static Response postResponse(Object requestBody) {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .post(fullPath);

        response.prettyPrint();

        return response;
    }

    public static Response patchResponse(Object requestBody) {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .patch(fullPath);

        response.prettyPrint();

        return response;
    }

    public static Response deleteResponse(Object requestBody) {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .delete(fullPath);

        response.prettyPrint();

        return response;
    }

    public static String tryCatchGet() {
        String exceptionMessage = null;
        try {
            response = given()
                    .spec(spec)
                    .when()
                    .get(fullPath);
        } catch (Exception e) {
            exceptionMessage = e.getMessage();
        }
        System.out.println("Exception Message : " + exceptionMessage);

        return exceptionMessage;
    }

    public static String tryCatchGetBody(Object requestBody) {
        String exceptionMessage = null;
        try {
            response = given()
                    .spec(spec)
                    .contentType(ContentType.JSON)
                    .when()
                    .body(requestBody)
                    .get(fullPath);
        } catch (Exception e) {
            exceptionMessage = e.getMessage();
        }
        System.out.println("Exception Message : " + exceptionMessage);

        return exceptionMessage;
    }

    public static String tryCatchDelete(Object requestBody) {
        String exceptionMessage = null;
        try {
            response = given()
                    .spec(spec)
                    .contentType(ContentType.JSON)
                    .when()
                    .body(requestBody)
                    .delete(fullPath);
        } catch (Exception e) {
            exceptionMessage = e.getMessage();
        }
        System.out.println("Exception Message : " + exceptionMessage);

        return exceptionMessage;
    }

    public static String tryCatchPatch(Object requestBody) {
        String exceptionMessage = null;
        try {
            response = given()
                    .spec(spec)
                    .contentType(ContentType.JSON)
                    .when()
                    .body(requestBody)
                    .patch(fullPath);
        } catch (Exception e) {
            exceptionMessage = e.getMessage();
        }
        System.out.println("Exception Message : " + exceptionMessage);

        return exceptionMessage;
    }

    public static void statusCodeAssert(int statusCode) {
        response.then()
                .assertThat()
                .statusCode(statusCode);
    }

    public static void messageAssert(String message) {
        response.then()
                .assertThat()
                .body("message", equalTo(message));
    }

    public static void setParameters(String rawPaths) {
        String[] paths = rawPaths.split("/"); // [api,refundReasonUpdate,25]

        System.out.println(Arrays.toString(paths));

        StringBuilder tempPath = new StringBuilder("/{");


        for (int i = 0; i < paths.length; i++) {

            String key = "pp" + i;
            String value = paths[i].trim();

            spec.pathParam(key, value);

            tempPath.append(key + "}/{");

            if (value.matches("\\d+")) {  // value.matches("\\d+") burada value rakam iceriyorsa dedik
                id = Integer.parseInt(value);
            }
        }
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));

        fullPath = tempPath.toString();
        System.out.println("fullPath = " + fullPath); // /{pp0}/{pp1}
        System.out.println("id : " + id);
    }

}