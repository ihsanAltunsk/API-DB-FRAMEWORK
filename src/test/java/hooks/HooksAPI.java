package hooks;

import config_Requirements.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utilities.API_Utilities.Authentication;

public class HooksAPI {
    public static RequestSpecification spec;

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
}
