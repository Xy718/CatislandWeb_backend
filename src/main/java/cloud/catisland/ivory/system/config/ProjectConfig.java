package cloud.catisland.ivory.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class ProjectConfig {
    @Value("${xy718.ossdomain}")
    private String ossdomain;
}