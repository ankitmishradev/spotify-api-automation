package apis;

import utils.Log;
import enums.RequestMethod;
import utils.Config;
import utils.Property;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import models.AccessToken;
import models.RequestModel;

import static io.restassured.RestAssured.given;

public class AuthorizationAPI extends API<AccessToken> {
    @Step("Send a POST request to refresh access token")
    public AuthorizationAPI refreshAccessToken(RequestModel request) {

        Log.sendingApiRequest(logger, RequestMethod.POST, request);
        validatableResponse = given().baseUri(Config.BASE_URL_ACC)
                .filter(new AllureRestAssured())
                .headers(request.getHeaders())
                .formParams(request.getBody())
                .post(request.getEndpoint())
                .then();
        Log.apiRequestSent(logger, validatableResponse.extract().statusCode());

        return this;
    }

    @Override
    public void statusCodeIs(int expectedStatusCode) {
        super.statusCodeIs(expectedStatusCode);
        if (validatableResponse.extract().statusCode() == 200) Property.set("ACCESS_TOKEN", response.getAccessToken());
    }
}