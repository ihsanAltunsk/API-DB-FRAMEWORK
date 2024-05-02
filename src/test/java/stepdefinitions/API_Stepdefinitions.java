package stepdefinitions;

import hooks.Base;
import io.cucumber.java.en.Given;
import utilities.API_Utilities.API_Methods;

public class API_Stepdefinitions extends Base {
    @Given("The api user prepares a POST request body for register.")
    public void the_api_user_prepares_a_post_request_body_for_register() {
        customer_email=faker.internet().emailAddress();
        password= faker.internet().password();
        requestBody.put("first_name", faker.name().firstName());
        requestBody.put("last_name", faker.name().lastName());
        requestBody.put("email", customer_email);
        requestBody.put("password", password);
        requestBody.put("password_confirmation", password);
        requestBody.put("user_type", "customer");
        requestBody.put("referral_code", "java candır");
    }
    @Given("The API user saves the information.")
    public void the_api_user_saves_the_information() {
        jsonPath= API_Methods.response.jsonPath();
        id = jsonPath.getInt("user.id");
        System.out.println("Email: " + jsonPath.getString("user.email") + "\nPassword: " + password + "\nID: " + id);
    }
}
