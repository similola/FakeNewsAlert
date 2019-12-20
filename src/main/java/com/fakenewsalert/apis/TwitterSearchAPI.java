package com.fakenewsalert.apis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.*;


import java.util.List;
import java.util.function.Consumer;

public class TwitterSearchAPI {

    static Logger logger = LoggerFactory.getLogger(TwitterSearchAPI.class);
    public static String checker(String userhandle, String text){

        //remove @ from userhandle
        String username=extractUsername(userhandle);
        Twitter twitter = new TwitterFactory().getInstance();
        TwitterAuth.authenticate(twitter);

        Query query = new Query(text);
        //query.setQuery("filter:verified");

        QueryResult result = null;
        try {
            result = twitter.search(query);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        List<Status> tweetList=result.getTweets();

        //is tweet true?
        //first print all tweets that match the tweet text
        Consumer<Status> style = (Status s) -> logger.info("USERHANDLE:@"+s.getUser().getScreenName() +" // TWEET:"+s.getText());
        logger.info("-----BEFORE-----");
        tweetList.forEach(style);

        //remove tweets that aren't by the user of interest
        boolean removed = tweetList.removeIf(s->!s.getUser().getScreenName().equals(username));

        logger.info("-----AFTER-----");
        tweetList.forEach(style);



        Boolean status = checkTweetMatch(text, tweetList);
        if(status){
            return "real";
        }
        else{
            return "fake";
        }

    }

    public static boolean checkTweetMatch(String text, List<Status> tweetList) {
        //need more verification but for now lets check that the tweet list has a size of 1
        if(tweetList.size()==1){
            for(Status status:tweetList){
                //check text match exactly, aka the user has been found AND the tweet matches exactly
                if(status.getText().equals(text)){
                    logger.info("REAL TWEET");
                    return true;
                }
                else{
                    //this user didnt tweet this- someone has definitely made a fake tweet
                    logger.info("FAKE TWEET");
                    return false;
                }
            }

        }
        if(tweetList.size()==0){
            //no tweets returned by the user
            logger.info("FAKE TWEET");
            return false;
        }
        logger.info("FAKE TWEET");
        return false;
    }

    public static String extractUsername(String userHandle) {
        return userHandle.replace("@","");
    }

}
