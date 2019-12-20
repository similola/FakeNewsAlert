package com.fakenewsalert.rest;

import com.fakenewsalert.apis.TwitterSearchAPI;
import com.fakenewsalert.utils.RequestObj;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RestService extends AbstractVerticle {
    static Logger logger = LoggerFactory.getLogger(RestService.class);
    @Override
    public void start(Future<Void> fut) {
        Router router = Router.router(vertx);
        router.route("/test").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response
                    .putHeader("content-type", "text/html")
                    .setStatusCode(200)
                    .end("Service up");
            logger.info("Fake News Alert Service up and running");
        });

        router.route("/verify*").handler(BodyHandler.create());
        router.post("/verify").handler(this::checkTweet);

        vertx
                .createHttpServer()
                .requestHandler(router::accept)
                .listen(
                        // Retrieve the port from the configuration,
                        // default to 8080.
                        config().getInteger("http.port", 8080),
                        result -> {
                            if (result.succeeded()) {
                                fut.complete();
                                logger.info("Service returned response");
                            } else {
                                fut.fail(result.cause());
                                logger.info("Service failed to return response");
                            }
                        }
                );
    }

    private void checkTweet(RoutingContext routingContext) {
        logger.info("Using Twitter API to validate if tweet is valid for user handle");
        RequestObj requestObj= Json.decodeValue(routingContext.getBodyAsString(),RequestObj.class);
        routingContext.response()
                .setStatusCode(200)
                .putHeader("content-type", "text/html")
                .end(TwitterSearchAPI.checker(requestObj.getHandle(),requestObj.getTweet()));
    }
}


