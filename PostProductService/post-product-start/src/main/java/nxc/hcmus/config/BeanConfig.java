package nxc.hcmus.config;

import nxc.hcmus.domain.annotation.Domain;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration(proxyBeanMethods = false)
@ComponentScan(
        basePackages = {
                "nxc.hcmus"
        },
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Domain.class)
)
public class BeanConfig {
}
