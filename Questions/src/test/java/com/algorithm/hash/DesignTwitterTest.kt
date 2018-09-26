package com.algorithm.hash

import junit.framework.Assert.assertEquals
import org.junit.Test

class DesignTwitterTest {
    @Test
    fun test() {
        val designTwitter = DesignTwitter();
        designTwitter.printDescription()

        // User 1 posts a new tweet (id = 5).
        designTwitter.postTweet(1, 5)

        // User 1's news feed should return a list with 1 tweet id -> [5].
        assertEquals(listOf(5), designTwitter.getNewsFeed(1))

        // User 1 follows user 2.
        designTwitter.follow(1, 2)

        // User 2 posts a new tweet (id = 6).
        designTwitter.postTweet(2, 6)

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        assertEquals(listOf(6, 5), designTwitter.getNewsFeed(1))

        // User 1 unfollows user 2.
        designTwitter.unfollow(1, 2)

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        assertEquals(listOf(5), designTwitter.getNewsFeed(1))
    }
}