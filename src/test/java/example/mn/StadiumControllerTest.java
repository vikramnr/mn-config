package example.mn;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class StadiumControllerTest {

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void testTeamEndpointReturnsTeamConfig() {
        TeamConfig teamConfig = httpClient.toBlocking().retrieve("/stadiums/team",TeamConfig.class);
        assertEquals("Steelers", teamConfig.getName());
        assertEquals("Red",teamConfig.getColor1());
        List<String> expectedPlayers = Arrays.asList("Mason","Jason");
        assertEquals(expectedPlayers.size(), teamConfig.getPlayerNames().size());
        expectedPlayers.forEach(name -> assertTrue(teamConfig.getPlayerNames().contains(name)));
    }

    @Test
    void testStadiumEndpointReturnStadiumConfig() {

        StadiumConfig stadiumConfig = httpClient.toBlocking().retrieve("/stadiums/stadium",StadiumConfig.class);

        assertEquals("pnc", stadiumConfig.getName());
        assertEquals("NewYork",stadiumConfig.getCity());
        assertEquals(20002, stadiumConfig.getSize());

    }
}
