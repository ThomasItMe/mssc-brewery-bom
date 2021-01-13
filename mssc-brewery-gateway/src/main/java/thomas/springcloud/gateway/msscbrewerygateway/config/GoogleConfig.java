package thomas.springcloud.gateway.msscbrewerygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author vvthuy on 1/13/2021
 * @project mssc-beer-service
 */
@Profile("google")
@Configuration
public class GoogleConfig {

    @Bean
    public RouteLocator googleRouteConfig(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/googlesearch2")
                        .filters(f -> f.rewritePath("/googlesearch2(?<segment>/?.*)", "/${segment}"))
                .uri("https://google.com"))
                .build();
    }
}
