package mixedconfigwiring.soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(CDPlayerConfig.class)
@ImportResource("classpath:META-INF/spring/cd-config.xml")
public class SoundSystemConfig {

}
