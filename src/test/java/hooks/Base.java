package hooks;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import manage.Manage;
import org.json.JSONObject;

import java.sql.*;
import java.util.HashMap;
import java.util.Random;

public abstract class Base {
    public static String fullPath, query, name, customer_email, password;
    public static int id, apiId, rowCount, state_id, status;
    public static RequestSpecification spec;
    public static Date date;
    public static Response response;
    public static JSONObject requestBody;
    public static Random random;
    public static JsonPath jsonPath;
    public static Faker faker;
    public static HashMap<String, Object> reqBodyMap;
    public static Connection connection;
    public static Statement statement;
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;
    public static Manage queryManage;

    public static void initialize(){
        requestBody = new JSONObject();
        faker = new Faker();
        random = new Random();
        reqBodyMap=new HashMap<>();
        queryManage = new Manage();
    }
}
