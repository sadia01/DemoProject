package data;

import org.testng.annotations.DataProvider;

public class CredentialsDataProvider {
    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"devadmin", "dev123"},
                {"testuser", "testpass"},
                {"stageuser", "stagepass"}
        };
    }
}
