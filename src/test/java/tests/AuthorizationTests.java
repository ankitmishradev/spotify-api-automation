package tests;

import apis.AuthorizationAPI;
import base.Base;
import base.Schema;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import models.AccessToken;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Feature("Refresh the access token")
public class AuthorizationTests extends Base {
    private AuthorizationAPI authorizationAPI;
    private Schema<AccessToken> schema;

    @DataProvider(name = "accessTokenTestData")
    public Object[][] provider() {
        return new Object[][]{{"validData", 200}, {"emptyRefreshToken", 400}, {"invalidHeader", 400}, {
                "invalidRefreshToken", 400}, {"invalidGrantType", 400}, {"emptyGrantType", 400}};
    }

    @BeforeTest
    public void setupAPIsAndSchema() {
        authorizationAPI = new AuthorizationAPI();
        schema = new Schema<>();
    }

    @Test(description = "Verify response of refresh token API", dataProvider = "accessTokenTestData")
    public void refreshAccessTokenTest(String testDataKey, int statusCode) {
        schema.loadTestData(testDataKey).loadRequest().loadResponse(AccessToken.class);

        authorizationAPI.refreshAccessToken(schema.request).parseResponseAs(AccessToken.class);

        authorizationAPI.statusCodeIs(statusCode);

        if (statusCode == 200) schema.response.setAccessToken(authorizationAPI.response.getAccessToken());

        authorizationAPI.validateResponseAgainst(schema.response);
    }
}