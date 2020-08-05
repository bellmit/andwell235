package com.andawell.gateway.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * SwaggerResourceHandler
 */
@Component
public class SwaggerResourceHandler implements HandlerFunction<ServerResponse> {
	private final static Logger logger = LoggerFactory.getLogger(SwaggerResourceHandler.class);
	@Autowired
	private SwaggerResourcesProvider swaggerResources;
	/**
	 * Handle the given request.
	 *
	 * @param request the request to handler
	 * @return the response
	 */
	@Override
	public Mono<ServerResponse> handle(ServerRequest request) {
		return ServerResponse.status(HttpStatus.OK)
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.body(BodyInserters.fromObject(swaggerResources.get()));
	}
}
