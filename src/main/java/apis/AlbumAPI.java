package apis;

import utils.Config;
import utils.Log;
import enums.RequestMethod;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import models.Album;
import models.RequestModel;

import static io.restassured.RestAssured.given;

public class AlbumAPI extends API<Album> {
    @Step("Send a GET request to retrieve and album")
    public AlbumAPI getAlbum(RequestModel request) {
        request.setAuthorization();

        Log.sendingApiRequest(logger, RequestMethod.GET, request);
        validatableResponse =
                given().baseUri(Config.BASE_URL_API).filter(new AllureRestAssured()).headers(request.getHeaders())
                        .get(request.getEndpoint()).then();
        Log.apiRequestSent(logger,validatableResponse.extract().statusCode());

        return this;
    }
}