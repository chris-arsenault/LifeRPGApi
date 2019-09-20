package com.ahara.liferpg.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class LifeRPGWebRouter {

    @Bean
    public RouterFunction<ServerResponse> route(LifeRPGWebHandler lifeRPGWebHandler) {

        return RouterFunctions
                .route(RequestPredicates.GET("/world")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), lifeRPGWebHandler::retrieveWorldState);
    }
}