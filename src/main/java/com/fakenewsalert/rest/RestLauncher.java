package com.fakenewsalert.rest;

import com.fakenewsalert.apis.TwitterAuth;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestLauncher {
    static Logger logger = LoggerFactory.getLogger(RestLauncher.class);
    public static void main(String[] args) {

        logger.info("Attempting to start Fake News Alert Service");
        try{
            Vertx vertx = Vertx.vertx();
            vertx.deployVerticle(new RestService());
            logger.info("Verticle deployed successfully");
        }
        catch (Exception ex){
            logger.error(ex.getMessage());
        }

    }
}
