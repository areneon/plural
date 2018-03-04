package patterns.Singleton;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import java.sql.Connection;
import java.sql.SQLException;

public class WhenSingletonTest extends Stage<WhenSingletonTest> {

    @ExpectedScenarioState
    Connection connection;



    protected WhenSingletonTest disconnect_from_DB() throws SQLException {

        connection.close();
        return self();
    }
}
