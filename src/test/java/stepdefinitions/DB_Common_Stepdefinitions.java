package stepdefinitions;

import hooks.Base;
import io.cucumber.java.en.Given;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class DB_Common_Stepdefinitions extends Base{
    @Given("Process the results for update {int}.")
    public void process_the_results_for_update(int row ) throws SQLException {
        rowCount = preparedStatement.executeUpdate();
        assertEquals(row, rowCount);
        System.out.println("Updated Name: Java Tandır");
    }
}
