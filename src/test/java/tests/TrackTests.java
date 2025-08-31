package tests;

import apis.TrackAPI;
import base.Schema;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import models.Track;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Feature("Spotify Tracks")
public class TrackTests {
    private TrackAPI trackAPI;
    private Schema<Track> schema;

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{{"validData", 200}, {"invalidData", 404}};
    }

    @BeforeTest
    public void setupAPIsAndSchema() {
        trackAPI = new TrackAPI();
        schema = new Schema<>();
    }

    @Test(description = "Create a new playlist", dataProvider = "dataProvider")
    public void getATrackTest(String testDataKey, int statusCode) {
        schema.loadTestData(testDataKey).loadRequest().loadResponse(Track.class);

        trackAPI.getTrack(schema.request).parseResponseAs(Track.class);

        trackAPI.statusCodeIs(statusCode);

        trackAPI.validateResponseAgainst(schema.response);
    }
}