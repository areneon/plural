package patterns.Singleton;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.impl.util.AssertionUtil;

import java.sql.Connection;
import java.sql.SQLException;

import static com.tngtech.jgiven.impl.util.AssertionUtil.assertTrue;

public class ThenSingletonTest extends Stage<ThenSingletonTest>{

    @ExpectedScenarioState
    Connection connection;

    public ThenSingletonTest connection_should_be_opened() throws SQLException {
        AssertionUtil.assertFalse(connection.isClosed(),"false");
        return self();
    }

    public ThenSingletonTest connection_should_be_closed() throws SQLException {

        assertTrue(connection.isClosed(),"true");
        return self();
    }
}
