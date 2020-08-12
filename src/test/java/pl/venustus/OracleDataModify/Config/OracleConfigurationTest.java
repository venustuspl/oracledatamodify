package pl.venustus.OracleDataModify.Config;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OracleConfigurationTest {

    OracleConfiguration oracleConfiguration = new OracleConfiguration();
    String username = "usernameTest";
    String password = "passwordTest";
    String url = "urlTest";

    @Test
    void dataSource() throws Exception {

        Whitebox.setInternalState(oracleConfiguration, "username", username);
        Whitebox.setInternalState(oracleConfiguration, "password", password);
        Whitebox.setInternalState(oracleConfiguration, "url", url);
        System.out.println(oracleConfiguration.toString());
        Assert.assertTrue(oracleConfiguration.dataSource() != null);

    }
}
