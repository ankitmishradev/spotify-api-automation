package apis;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;

import utils.Config;
import utils.Log;
import enums.RequestMethod;
import models.Playlist;
import models.RequestModel;

import static io.restassured.RestAssured.given;

public class PlaylistAPI extends API<Playlist> {
    @Step("Send a POST request to create a playlist")
    public PlaylistAPI createAPlaylist(RequestModel request) {
        request.setAuthorization();

        Log.sendingApiRequest(logger, RequestMethod.POST, request);
        validatableResponse =
                given().baseUri(Config.BASE_URL_API).filter(new AllureRestAssured()).headers(request.getHeaders())
                        .body(request.getBody()).post(request.getEndpoint()).then();
        Log.apiRequestSent(logger, validatableResponse.extract().statusCode());

        return this;
    }

    @Step("Send a get request to get the information of given playlist")
    public PlaylistAPI getPlaylistInformation(RequestModel request) {
        request.setAuthorization();

        Log.sendingApiRequest(logger, RequestMethod.GET, request);
        validatableResponse =
                given().baseUri(Config.BASE_URL_API).filter(new AllureRestAssured()).headers(request.getHeaders())
                        .get(request.getEndpoint()).then();
        Log.apiRequestSent(logger,validatableResponse.extract().statusCode());

        return this;
    }
}