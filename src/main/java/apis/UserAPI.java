package apis;

import utils.Config;
import utils.Log;
import utils.Property;
import enums.RequestMethod;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import models.RequestModel;
import models.User;

import static io.restassured.RestAssured.given;

public class UserAPI extends API<User> {
    @Step("Send a GET request to retrieve the current user profile")
    public UserAPI getUserProfile(RequestModel request) {
        request.setAuthorization();
        Log.sendingApiRequest(logger, RequestMethod.GET, request);
        validatableResponse = given().baseUri(Config.BASE_URL_API).filter(new AllureRestAssured())
                .headers(request.getHeaders()).get(request.getEndpoint()).then();
        Log.apiRequestSent(logger, validatableResponse.extract().statusCode());

        return this;
    }

    @Override
    public void statusCodeIs(int expectedStatusCode) {
        super.statusCodeIs(expectedStatusCode);
        if (validatableResponse.extract().statusCode()==200) Property.set("USER_ID",response.getId());
    }
}