package stepdefinitions;

import config_Requirements.ConfigReader;
import hooks.Base;
import io.cucumber.java.en.Given;
import utilities.API_Utilities.API_Methods;
import utilities.API_Utilities.Authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class API_Common_Stepdefinitions extends Base {
    @Given("The API user sends a {string} request and records the response.")
    public void the_apı_user_sends_a_get_request_and_records_the_response(String value) {
        switch (value) {
            case "GET":
                API_Methods.getResponse();
                break;
            case "POST":
                API_Methods.postResponse(requestBody.toString());
                break;
            case "PATCH":
                API_Methods.patchResponse(requestBody.toString());
                break;
            case "DELETE":
                API_Methods.deleteResponse(requestBody.toString());
                break;
            default:
                System.out.println("Invalid Method Value");
        }
    }
    @Given("The API user confirms the {string}.")
    public void the_apı_user_confirms_the(String properties) {
        assertTrue(API_Methods.tryCatchPatch(requestBody.toString()).equals(ConfigReader.getProperty("api", properties)));
    }
    @Given("The api user constructs the base url with the {string} token.")
    public void the_api_user_constructs_the_base_url_with_the_token(String token) {
        Authentication.setUpApi(token);
    }
    @Given("The api user prepares a GETBODY request containing the id = {int} and records the response.")
    public void the_api_user_prepares_a_get_request_containing_the_refund_reason_id_for_which_details_are_to_be_accessed_to_send_to_the_api_endpoint(int id) {
        requestBody.put("id", id);
        API_Methods.getBodyResponse(requestBody.toString());
    }
    @Given("The api user prepares a DELETEBODY request containing the id = {int} and records the response.")
    public void the_api_user_prepares_a_deletebody_request_containing_the_id_and_records_the_response(int id) {
        requestBody.put("id", id);
    }
    @Given("The api user verifies that updated_Id is same as the param {int}")
    public void the_api_user_verifies_that_updated_id_is_same_as_the_param_id(int id) {
        jsonPath = response.jsonPath();
        assertEquals(id, jsonPath.getInt("updated_Id"));
    }
    @Given("The api user verifies that Deleted_Id is same as the request body {int}")
    public void the_api_user_verifies_that_deleted_id_is_same_as_the_request_body(int id) {
        jsonPath = response.jsonPath();
        assertEquals(id, jsonPath.getInt("Deleted_Id"));
    }
    @Given("The api user sets {string} path parameters")
    public void the_api_user_sets_path_parameters(String rawPaths) {
        API_Methods.setParameters(rawPaths);
    }
    @Given("The api user verifies that the status code is {int}")
    public void the_api_user_verifies_that_the_status_code_is(int code) {
        API_Methods.statusCodeAssert(code);
    }
    @Given("The api user verifies that the message information in the response body is {string}")
    public void the_api_user_verifies_that_the_message_information_in_the_response_body_is(String message) {
        API_Methods.messageAssert(message);
    }
    @Given("The api user prepares a GETBODY request containing the added_item_id and records the response.")
    public void the_api_user_prepares_a_getbody_request_containing_the_added_item_id_and_records_the_response() {
        System.out.println("eklenen:" + apiId);
        requestBody.put("id", apiId);
        API_Methods.getBodyResponse(requestBody.toString());
    }
}
