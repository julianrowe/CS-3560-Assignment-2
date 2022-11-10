import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User extends Subject implements Observer, SysEntry {
    private String unique_ID;
    private List<User> followers;
    private List<User> following;
    private List<String> messages;
    private List<User_Group> userGroupList;
    private Feed personalFeed;
    private List<String> newsFeed = new ArrayList<>(Arrays.asList());
    private List<String> myTweets = new ArrayList<>();

    public User(String name) {
        unique_ID = name;
        followers = new ArrayList<>();
        following = new ArrayList<>();
        personalFeed = new Feed();
    }

    public void followUser(User user) {
        followers.add(user);
        user.getFollowersList().add(this);
    }

    public List<User_Group> getUserGroupList() {
        return userGroupList;
    }

    public List<User> getFollowersList() {
        return followers;
    }

    public List<User> getFollowingList() {
        return following;
    }

    public List<String> getMyTweets() {
        return myTweets;
    }

    public void tweetMessage (String tweet){
        myTweets.add(tweet);
        newsFeed.add("-" + this.unique_ID + " : " + tweet);
        notifyObservers(tweet);
    }

    @Override
    public void accept(Visitor visitor) {

    }

    @Override
    public String getDisplayName() {
        return unique_ID;
    }

    @Override
    public String getUnique_ID() {
        return unique_ID;
    }

    @Override
    public void update(Subject subject, String tweet) {
        if(subject instanceof User) {
            this.newsFeed.add("-" + ((User) subject).getUnique_ID() + " : " + tweet);
        }
    }
}