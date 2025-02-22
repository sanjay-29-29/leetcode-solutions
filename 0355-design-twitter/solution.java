class Tweet implements Comparable<Tweet> {
    int tweetId;
    int time;

    Tweet(int _tweetId, int _time) {
        tweetId = _tweetId;
        time = _time;
    }

    public int compareTo(Tweet t) {
        return Integer.compare(t.time, this.time);
    }
}

class Twitter {
    Map<Integer, Set<Integer>> followersDb = new HashMap<>();
    Map<Integer, List<Tweet>> tweetsDb = new HashMap<>();

    int tweetCount = 0;

    public void postTweet(int userId, int tweetId) {
        List<Tweet> tweets = tweetsDb.getOrDefault(userId, new LinkedList<>());
        tweets.addLast(new Tweet(tweetId, tweetCount));
        tweetsDb.put(userId, tweets);
        this.tweetCount++;
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followers = followersDb.getOrDefault(userId, new HashSet<>());
        List<Tweet> currentUserTweets = tweetsDb.getOrDefault(userId, new LinkedList<>());
        List<Tweet> allTweets = new LinkedList<>(currentUserTweets);

        for (int follower : followers) {
            List<Tweet> tweets = tweetsDb.get(follower);
            if (tweets == null) {
                continue;
            }
            allTweets.addAll(tweets);
        }

        Collections.sort(allTweets);
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for (Tweet t : allTweets) {
            count++;
            res.add(t.tweetId);
            if (count == 10) {
                break;
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        Set<Integer> followers = followersDb.getOrDefault(followerId, new HashSet<>());
        followers.add(followeeId);
        followersDb.put(followerId, followers);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        Set<Integer> followers = followersDb.getOrDefault(followerId, new HashSet<>());
        followers.remove(followeeId);
        followersDb.put(followerId, followers);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
