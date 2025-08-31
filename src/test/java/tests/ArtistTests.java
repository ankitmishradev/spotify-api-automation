package tests;

import apis.ArtistAPI;
import base.Schema;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import models.Artist;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Feature("Spotify Artists")
public class ArtistTests {
    private ArtistAPI artistAPI;
    private Schema<Artist> schema;

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{{"validData", 200}, {"invalidData", 404}};
    }

    @BeforeTest
    public void setupAPIsAndSchema() {
        artistAPI = new ArtistAPI();
        schema = new Schema<>();
    }

    @Test(description = "Get an artist", dataProvider = "dataProvider")
    public void getAnArtistTest(String testDataKey, int statusCode) {
        schema.loadTestData(testDataKey).loadRequest().loadResponse(Artist.class);

        artistAPI.getArtist(schema.request).parseResponseAs(Artist.class);

        artistAPI.statusCodeIs(statusCode);

        artistAPI.validateResponseAgainst(schema.response);
    }
}