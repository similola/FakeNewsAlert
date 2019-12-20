package com.fakenewsalert.apis;

import org.junit.jupiter.api.Test;
import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwitterSearchAPITest {

    @Test
    void checkTweetMatchFails() {
        List<Status> tweetList= new ArrayList<>();
       assertEquals(false,TwitterSearchAPI.checkTweetMatch("",tweetList));
    }

    @Test
    void extractUsernameCorrect() {
        assertEquals("testName",TwitterSearchAPI.extractUsername("@testName"));
    }

    @Test
    void extractUsernameCorrectWithoutAtSymbol() {
        assertEquals("testName",TwitterSearchAPI.extractUsername("testName"));
    }

}