package tests;

import apis.PlaylistAPI;
import base.Schema;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import models.Playlist;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

@Feature("Spotify Playlist")
public class PlaylistTests {
    private PlaylistAPI playlistAPI;
    private Schema<Playlist> schema;

    @DataProvider(name = "createPlaylistDataProvider")
    public Object[][] createPlaylistDataProvider() {
        return new Object[][]{{"createPlaylistMissingRequiredField", 400}, {"createPlaylistValidData", 201}};
    }

    @DataProvider(name = "getPlaylistInformationDP")
    public Object[][] getPlaylistInformationDP() {
        return new Object[][]{{"getPlaylistInfoValidData", 200}, {"getPlaylistInfoInvalidData", 502}};
    }

    @BeforeTest
    public void setupAPIsAndSchema() {
        playlistAPI = new PlaylistAPI();
        schema = new Schema<>();
    }

    @Test(description = "Create a new playlist", dataProvider = "createPlaylistDataProvider")
    public void createAPlaylistTest(String testDataKey, int statusCode, ITestContext context) {
        schema.loadTestData(testDataKey).loadRequest().loadResponse(Playlist.class);

        playlistAPI.createAPlaylist(schema.request).parseResponseAs(Playlist.class);

        playlistAPI.statusCodeIs(statusCode);

        playlistAPI.validateResponseAgainst(schema.response);

        context.setAttribute("playlist", playlistAPI.response);
    }

    @Description("Get playlist information")
    @Test(description = "Create a new playlist", dataProvider = "getPlaylistInformationDP", dependsOnMethods = {"createAPlaylistTest"})
    public void getPlaylistInformationTest(String testDataKey, int statusCode, ITestContext context) {
        schema.loadTestData(testDataKey).loadRequest().loadResponse(Playlist.class);

        Playlist playlist = (Playlist) context.getAttribute("playlist");
        schema.request.setEndpoint(schema.request.getEndpoint()
                .concat("/" + (statusCode == 200 ? playlist.getId() : playlist.getId().replaceAll(".$",Integer.toString(new Random().nextInt(10))))));

        playlistAPI.getPlaylistInformation(schema.request).parseResponseAs(Playlist.class);

        playlistAPI.statusCodeIs(statusCode);

        playlistAPI.validateResponseAgainst(schema.response);
    }
}