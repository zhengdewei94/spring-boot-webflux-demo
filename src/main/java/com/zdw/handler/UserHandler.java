package com.zdw.handler;

import com.zdw.entity.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

/**
 * User Handler
 *
 * @author zheng dewei
 * @since 2021-01-14 17:14:02
 */
@Component
public class UserHandler {

    public Mono<ServerResponse> query(ServerRequest request) {
        Flux<User> share = Flux.interval(Duration.ofSeconds(1))
                .onBackpressureDrop()
                .map(user -> new User().setName("李四").setInstant(Instant.now()))
                .share();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_NDJSON)
                .body(share, User.class);
    }
}
