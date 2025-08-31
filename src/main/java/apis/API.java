package apis;

import utils.Log;
import base.Base;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class API<R> extends Base {
    private final HashMap<String, R> responses=new HashMap<>();
    public R response;
    public ValidatableResponse validatableResponse;

    @Step("Validate the response status code is {expectedStatusCode}")
    public void statusCodeIs(int expectedStatusCode) {
        validatableResponse.statusCode(expectedStatusCode);
        Log.responseCodeValidation(logger, expectedStatusCode);
    }

    @Step("Parse the response body as {typeReference}")
    public API<R> parseResponseAs(Class<R> typeReference){
        try {
            response = objectMapper.readValue(validatableResponse.extract().asString(), typeReference);
            Log.responseParsedAs(logger, typeReference.getSimpleName());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Couldn't parse the response as " + typeReference.getSimpleName() + e.getMessage(), e);
        }

        return this;
    }

    @Step("Validate actual response against expected response")
    public void validateResponseAgainst(R expectedResponse) {
        assertThat(expectedResponse, is(response));
        Log.responseValidatedAgainst(logger);
    }

    @Step("Validate actual response against expected response")
    public void validateResponseAgainst(String key, R expectedResponse) {
        assertThat(expectedResponse, is(getResponse(key)));
        Log.responseValidatedAgainst(logger);
    }

    public void saveResponseAs(String key) {
        responses.put(key, response);
        logger.info("Saved the current response as {}", key);
    }

    public R getResponse(String key) {
        if (responses.containsKey(key)) return responses.get(key);
        else {
            logger.error("There is no saved response as {}", key);
            throw new RuntimeException("There is no saved response as " + key);
        }
    }
}