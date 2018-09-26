package com.algorithm.hash

import com.algorithm.AlgorithmQuestion
import java.util.HashSet
import java.util.ArrayList
import java.util.Comparator
import java.util.PriorityQueue
import java.util.Queue
import java.util.HashMap



class DesignTwitter : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:\n" +
                "\n" +
                "postTweet(userId, tweetId): Compose a new tweet.\n" +
                "getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.\n" +
                "follow(followerId, followeeId): Follower follows a followee.\n" +
                "unfollow(followerId, followeeId): Follower unfollows a followee.\n" +
                "Example:\n" +
                "\n" +
                "Twitter twitter = new Twitter();\n" +
                "\n" +
                "// User 1 posts a new tweet (id = 5).\n" +
                "twitter.postTweet(1, 5);\n" +
                "\n" +
                "// User 1's news feed should return a list with 1 tweet id -> [5].\n" +
                "twitter.getNewsFeed(1);\n" +
                "\n" +
                "// User 1 follows user 2.\n" +
                "twitter.follow(1, 2);\n" +
                "\n" +
                "// User 2 posts a new tweet (id = 6).\n" +
                "twitter.postTweet(2, 6);\n" +
                "\n" +
                "// User 1's news feed should return a list with 2 tweet ids -> [6, 5].\n" +
                "// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.\n" +
                "twitter.getNewsFeed(1);\n" +
                "\n" +
                "// User 1 unfollows user 2.\n" +
                "twitter.unfollow(1, 2);\n" +
                "\n" +
                "// User 1's news feed should return a list with 1 tweet id -> [5],\n" +
                "// since user 1 is no longer following user 2.\n" +
                "twitter.getNewsFeed(1);")
    }

    inner class Post(id: Int) {
        var id = 0
        var time: Long = 0
        var next: Post? = null

        init {
            this.id = id
            time = count++.toLong()
            println("add $id time is $time")
        }
    }

    var count = 0
    var twitMap: MutableMap<Int, Post> = HashMap()
    var followMap: MutableMap<Int, MutableSet<Int>> = HashMap()

    /** Compose a new tweet.  */
    fun postTweet(userId: Int, tweetId: Int) {
        var p: Post? = twitMap[userId]
        val temp = Post(tweetId)
        if (p == null) {
            p = temp
        } else {
            temp.next = p
            p = temp
        }
        twitMap[userId] = p
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.  */
    fun getNewsFeed(userId: Int): List<Int> {
        val followees = HashSet(followMap.getOrDefault(userId, HashSet()))
        followees.add(userId)
        val queue = PriorityQueue(Comparator<Post> { p1, p2 -> (p2.time - p1.time).toInt() })
        for (fId in followees) {
            if (twitMap[fId] != null) {
                queue.offer(twitMap[fId])
            }
        }
        val res = ArrayList<Int>()
        while (!queue.isEmpty() && res.size < 10) {
            val p = queue.poll()
            if (p!!.next != null) {
                queue.offer(p.next)
            }
            res.add(p.id)
        }
        return res
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op.  */
    fun follow(followerId: Int, followeeId: Int) {
        val set = followMap.getOrDefault(followerId, HashSet())
        set.add(followeeId)
        followMap[followerId] = set
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op.  */
    fun unfollow(followerId: Int, followeeId: Int) {
        val set = followMap.getOrDefault(followerId, HashSet())
        set.remove(followeeId)
        followMap[followerId] = set
    }
}