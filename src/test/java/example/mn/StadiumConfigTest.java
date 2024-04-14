package example.mn;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.Qualifier;
import io.micronaut.inject.qualifiers.Qualifiers;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StadiumConfigTest {

    @Test
    void testForEachProperty() {
        Map<String , Object> items = new HashMap<>();
        items.put("stadium.fenway.city","Boston");
        items.put("stadium.fenway.size",2000);
        items.put("stadium.calis.city","LosAngles");
        items.put("stadium.calis.size",20012);

        ApplicationContext ctx = ApplicationContext.run(items);

        StadiumConfig fenwayConfig = ctx.getBean(StadiumConfig.class, Qualifiers.byName("fenway"));
        StadiumConfig calisConfig = ctx.getBean(StadiumConfig.class, Qualifiers.byName("calis"));

        assertEquals("Boston", fenwayConfig.getCity());
        assertEquals("LosAngles",calisConfig.getCity());
        assertEquals(2000, fenwayConfig.getSize());
        assertEquals(20012, calisConfig.getSize());

        ctx.close();
    }
}
