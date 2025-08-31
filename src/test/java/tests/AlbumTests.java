package tests;

import apis.AlbumAPI;
import base.Schema;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import models.Album;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Feature("Spotify Albums")
public class AlbumTests {
    private AlbumAPI albumAPI;
    private Schema<Album> schema;

    @DataProvider(name = "getAlbumDataProvider")
    public Object[][] getAlbumDataProvider() {
        return new Object[][]{{"validData", 200}, {"invalidData", 404}};
    }

    @BeforeTest
    public void setupAPIsAndSchema() {
        albumAPI = new AlbumAPI();
        schema = new Schema<>();
    }

    @Test(description = "Get an album", dataProvider = "getAlbumDataProvider")
    public void getAnAlbumTest(String testDataKey, int statusCode) {
        schema.loadTestData(testDataKey).loadRequest().loadResponse(Album.class);

        albumAPI.getAlbum(schema.request).parseResponseAs(Album.class);

        albumAPI.statusCodeIs(statusCode);

        albumAPI.validateResponseAgainst(schema.response);
    }
}