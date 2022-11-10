public class Tweet {
    private static int idCounter = 0;
    private int tweetId;
    private User author;
    private String message;

    public Tweet(User user, String text) {
        tweetId = idCounter;
        author = user;
        message = text;
    }

    public int getTweetId() {
        return tweetId;
    }
}
