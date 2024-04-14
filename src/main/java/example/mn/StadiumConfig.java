package example.mn;


import io.micronaut.context.annotation.Configuration;
import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@EachProperty("stadium")
public class StadiumConfig {
    private String name;
    private String city;
    private Integer size;

    public StadiumConfig(@Parameter String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
