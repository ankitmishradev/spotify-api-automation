package tests;

import apis.UserAPI;
import base.Base;
import base.Schema;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import models.User;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Feature("User Information")
public class UserTests extends Base {
    private UserAPI userAPI;
    private Schema<User> schema;

    @DataProvider(name = "userProfileDataProvider")
    public Object[][] provider() {
        return new Object[][]{{"validData", 200}};
    }

    @BeforeTest
    public void setupAPIsAndSchema() {
        userAPI = new UserAPI();
        schema = new Schema<>();
    }

    @Test(description = "Verify user details", dataProvider = "userProfileDataProvider")
    public void getUserProfileTest(String testDataKey, int statusCode) {
        schema.loadTestData(testDataKey).loadRequest().loadResponse(User.class);

        userAPI.getUserProfile(schema.request).parseResponseAs(User.class);

        userAPI.statusCodeIs(statusCode);

        userAPI.validateResponseAgainst(schema.response);
    }
}