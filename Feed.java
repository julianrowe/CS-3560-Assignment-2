import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Feed {
    Map<Integer, Tweet> tweetMap;
    
    public Feed() {
        tweetMap = new HashMap<>();
    }

    public void addToFeed(Tweet tweet) {
        int tweetId = tweet.getTweetId();
        try {
            if (tweetMap.containsKey(tweetId)) {
                throw new IllegalStateException(
                    "Duplicate TweetId found"
                );
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        tweetMap.put(tweetId, tweet);
    }

    public List<Tweet> getRevChronoTweetList() {
        List<Tweet> tweetList = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Tweet>> maxHeap = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());

        for(Map.Entry<Integer, Tweet> entry : tweetMap.entrySet()) {
            maxHeap.offer(entry);
        }

        while(!maxHeap.isEmpty()) {
            tweetList.add(maxHeap.poll().getValue());
        }

        return tweetList;
    }
}
