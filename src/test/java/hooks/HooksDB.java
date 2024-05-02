package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utilities.DB_Utilities.DBUtils;

import java.sql.SQLException;

public class HooksDB extends DBUtils{
    @Before("@DB")
    public void establish_a_database_connection() {
        DBUtils.createConnection();
    }
    @After("@DB")
    public void close_the_database_connection() throws SQLException {
        DBUtils.closeConnection();
    }
}
