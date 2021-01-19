package com.zdw.router;

import com.zdw.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * User Router
 *
 * @author zheng dewei
 * @since 2021-01-14 17:12:16
 */
@Component
@RestController
public class UserRouter {

    /**
     * Router
     *
     * @param userHandler
     * @return RouterFunction<ServerResponse>
     * @author Canyon Warrior
     */
    @Bean
    public RouterFunction<ServerResponse> hello(UserHandler userHandler) {
        return RouterFunctions
                .route(RequestPredicates
                                .GET("/query")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_NDJSON)),
                        userHandler::query);
    }
}
