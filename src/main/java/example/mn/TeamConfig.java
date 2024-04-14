package example.mn;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micronaut.context.annotation.ConfigurationBuilder;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
@JsonIgnoreProperties("builder")
@ConfigurationProperties("team")
public class TeamConfig {
    private String name;
    private String color1;

    private List<String> playerNames;

    public TeamConfig(){}

    @ConfigurationBuilder(prefixes = "with", configurationPrefix = "team-admin")
    protected TeamAdmin.Builder  builder = TeamAdmin.builder();

    public TeamAdmin.Builder getBuilder() {
        return builder;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public void setPlayerNames(List<String> playerNames) {
        this.playerNames = playerNames;
    }
}
