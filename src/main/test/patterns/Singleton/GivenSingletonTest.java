package patterns.Singleton;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import patterns.singleton.DBLazySingleton;

import java.sql.Connection;

public class GivenSingletonTest extends Stage<GivenSingletonTest>{

    @ProvidedScenarioState
    Connection connection;

    protected GivenSingletonTest a_connection(){
        this.connection= DBLazySingleton.getInstance().getConnection();
        return self();
    }
}
