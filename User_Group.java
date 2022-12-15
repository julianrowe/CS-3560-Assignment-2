import java.util.ArrayList;
import java.util.List;

public class User_Group implements SysEntry{
    private String unique_ID;
    private List<User> userList;
    private List<User_Group> userGroupList;
    private long creationTime;

    public User_Group(String name, User... users) {
        userList = new ArrayList<>();
        userGroupList = new ArrayList<>();
        for(User user : users) {
            userList.add(user);
        }
        unique_ID = name;
        creationTime = System.currentTimeMillis();
    }

    public void addMemeber(User user) {
        if(!userList.contains(user) && user.getUserGroupList().size() == 0) {
            userList.add(user);
        }
    }

    public List<User_Group> getUserGroupList() {
        return userGroupList;
    }

    public void addGroupUsers(User_Group newGroup){
        this.userGroupList.add(newGroup);
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

    public long getCreationTime() {
        return creationTime;
    }
}