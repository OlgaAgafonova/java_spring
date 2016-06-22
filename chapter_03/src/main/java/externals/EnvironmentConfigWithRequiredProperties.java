package externals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvironmentConfigWithRequiredProperties {
    @Autowired
    Environment environment;

    //если не найдутся настройки, то будет выброшено исключение IllegalStateException
    @Bean
    public BlankDisc blankDisc() {
        return new BlankDisc(
                environment.getRequiredProperty("disc.title"),
                environment.getRequiredProperty("disc.artist"));
    }
}