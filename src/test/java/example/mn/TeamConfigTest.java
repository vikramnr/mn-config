package example.mn;

import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeamConfigTest {

    @Test
    void testTeamConfig() {
        List<String> names = Arrays.asList("Nirav Assar","Lionel Messi");
        Map<String, Object> items = new HashMap<>();

        items.put("team.name","evoluution");
        items.put("team.color1","yellow");
        items.put("team.player-names",names);

        ApplicationContext ctx = ApplicationContext.run(items);
        TeamConfig teamConfig = ctx.getBean(TeamConfig.class);

        assertEquals("evoluution",teamConfig.getName());
        assertEquals("yellow",teamConfig.getColor1());
        assertEquals(names.size(),teamConfig.getPlayerNames().size());
        names.forEach(name -> assertTrue(teamConfig.getPlayerNames().contains(name)));

        ctx.close();
    }

    @Test
    void testConfigBuilder() {
        List<String> names = Arrays.asList("Modi","Rahul");
        Map<String, Object> items = new HashMap<>();
        items.put("team.name","evolu");
        items.put("team.color1","grey");
        items.put("team.team-admin.manager","YTerry");
        items.put("team.team-admin.president","Mark");
        items.put("team.team-admin.coach","Ckerry");
        items.put("team.player-names",names);

        ApplicationContext ctx = ApplicationContext.run(items);
        TeamConfig teamConfig = ctx.getBean(TeamConfig.class);
        TeamAdmin teamAdmin = teamConfig.builder.build();

        assertEquals("evolu",teamConfig.getName());
        assertEquals("grey",teamConfig.getColor1());
        assertEquals("Modi",teamConfig.getPlayerNames().get(0));
        assertEquals("Rahul",teamConfig.getPlayerNames().get(1));

        assertEquals("YTerry",teamConfig.builder.getManager());
        assertEquals("Mark",teamConfig.builder.getPresident());
        assertEquals("Ckerry",teamConfig.builder.getCoach());

        ctx.close();
    }

}
