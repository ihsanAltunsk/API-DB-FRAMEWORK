package stepdefinitions;

import hooks.Base;
import io.cucumber.java.en.Given;
import utilities.DB_Utilities.DBUtils;

import java.sql.SQLException;

public class DB_Stepdefinitions extends Base {
    @Given("Query02 Prepare and execute the query.")
    public void query02_prepare_and_execute_the_query() throws SQLException {
        preparedStatement = DBUtils.getConnection().prepareStatement(queryManage.getQueryUS02Q02());
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        System.out.println("Database Name Result: " + resultSet.getString("first_name") +
                "\nDatabase Last Name Result: " + resultSet.getString("last_name"));
    }
}
