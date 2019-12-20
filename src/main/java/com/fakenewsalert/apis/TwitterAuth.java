package com.fakenewsalert.apis;


import com.fakenewsalert.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Twitter;
import twitter4j.auth.AccessToken;


public class TwitterAuth {
    static Logger logger = LoggerFactory.getLogger(TwitterAuth.class);
    public static void authenticate(Twitter twitter){

        twitter.setOAuthConsumer(Constants.TWITTER_CONSUMER_KEY.getValue(), Constants.TWITTER_CONSUMER_SECRET.getValue());
        AccessToken accessToken = new AccessToken(Constants.ACCESS_TOKEN.getValue(), Constants.ACCESS_SECRET.getValue());
        twitter.setOAuthAccessToken(accessToken);
        logger.info("Authenticated");
    }
}
