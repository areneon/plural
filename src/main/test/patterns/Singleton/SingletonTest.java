package patterns.Singleton;

import com.tngtech.jgiven.testng.ScenarioTest;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class SingletonTest extends ScenarioTest<GivenSingletonTest, WhenSingletonTest, ThenSingletonTest>{

    @Test
    public void disconnect_db_test() throws SQLException {
        given().a_connection();
        when().disconnect_from_DB();
        then().connection_should_be_closed();
    }

    @Test
    public void connect_db_test() throws SQLException {
        given().a_connection();
        then().connection_should_be_opened();
    }


}
