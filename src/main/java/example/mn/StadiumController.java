package example.mn;


import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Named;

@Controller("/stadiums")
public class StadiumController {

    private final TeamConfig teamConfig;
    private final StadiumConfig stadiumConfig;

    public StadiumController(@Nullable TeamConfig teamConfig,@Nullable @Named("pnc") StadiumConfig stadiumConfig) {
        this.teamConfig = teamConfig;
        this.stadiumConfig = stadiumConfig;
    }

    @Get("/team")
    public TeamConfig getTeamConfig() {
        return teamConfig;
    }

    @Get("/stadium")
    public StadiumConfig getStadiumConfig() {
        return stadiumConfig;
    }
}
