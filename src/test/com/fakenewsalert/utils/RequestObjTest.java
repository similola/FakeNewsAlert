package com.fakenewsalert.utils;

import io.vertx.core.json.Json;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestObjTest {

    String json ="{"+"\"handle\""+":"+"\"@similola\""+","+"\"tweet\""+":"+"\"test\""+"}";
    RequestObj object= Json.decodeValue(json,RequestObj.class);
    @Test
    void getHandleWorks() {
        assertEquals("@similola",object.getHandle());
    }

    @Test
    void setHandleWorks() {
        object.setHandle("@someonenew");
        assertEquals("@someonenew",object.getHandle());

    }

    @Test
    void setTweetWorks() {
        object.setTweet("newTest");
        assertEquals("newTest",object.getTweet());
    }

    @Test
    void getTweetWorks() {
        assertEquals("test",object.getTweet());
    }
}