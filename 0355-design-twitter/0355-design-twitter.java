class Tweet implements Comparable<Tweet> {
    int time;
    int tweetId;
    Tweet(int t, int id) {
        time = t;
        tweetId = id;
    }
    public int compareTo(Tweet that) {
        return that.time - this.time; // Most recent first
    }
}

class User {
    int userId;
    HashSet<Integer> following; // Users that this user follows
    List<Tweet> tweets;
    
    User(int userId) {
        this.userId = userId;
        following = new HashSet<>();
        tweets = new LinkedList<>();
        follow(userId); // User follows themselves
    }

    public void addTweet(Tweet t) {
        tweets.add(0, t); // Add at beginning for most recent
    }
    
    public void follow(int userId) {
        following.add(userId);
    }
    
    public void unfollow(int userId) {
        if (userId != this.userId) { // Can't unfollow yourself
            following.remove(userId);
        }
    }
}

class Twitter {
    int timeStamp;
    HashMap<Integer, User> userMap;
    
    public Twitter() {
        userMap = new HashMap<>();
        timeStamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeStamp++, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;
        
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        User user = userMap.get(userId);
        
        // Add the most recent tweet from each followee to the priority queue
        HashMap<Integer, Integer> indices = new HashMap<>();
        for (int followeeId : user.following) {
            if (userMap.containsKey(followeeId)) {
                List<Tweet> followeeTweets = userMap.get(followeeId).tweets;
                if (!followeeTweets.isEmpty()) {
                    indices.put(followeeId, 0);
                    pq.offer(followeeTweets.get(0));
                }
            }
        }
        
        // Get the 10 most recent tweets
        while (!pq.isEmpty() && res.size() < 10) {
            Tweet tweet = pq.poll();
            res.add(tweet.tweetId);
            
            // Find which user this tweet belongs to and get their next tweet
            for (int followeeId : user.following) {
                if (userMap.containsKey(followeeId)) {
                    List<Tweet> followeeTweets = userMap.get(followeeId).tweets;
                    Integer index = indices.get(followeeId);
                    if (index != null && !followeeTweets.isEmpty() && 
                        index < followeeTweets.size() - 1 && 
                        followeeTweets.get(index) == tweet) {
                        
                        indices.put(followeeId, index + 1);
                        pq.offer(followeeTweets.get(index + 1));
                        break;
                    }
                }
            }
        }
        
        return res;
    }
    
    // Alternative simpler implementation for getNewsFeed:
    public List<Integer> getNewsFeedSimple(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;
        
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        User user = userMap.get(userId);
        
        // Add recent tweets from all followed users (including self)
        for (int followeeId : user.following) {
            if (userMap.containsKey(followeeId)) {
                User followee = userMap.get(followeeId);
                for (Tweet tweet : followee.tweets) {
                    pq.offer(tweet);
                }
            }
        }
        
        // Get top 10 tweets
        while (!pq.isEmpty() && res.size() < 10) {
            res.add(pq.poll().tweetId);
        }
        
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        User follower = userMap.get(followerId);
        follower.follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) {
            return;
        }
        User follower = userMap.get(followerId);
        follower.unfollow(followeeId);
    }
}