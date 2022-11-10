public class TotalMessageVisitor implements UserGroupVisitor {
    private int TotalMessage = 0;
    
    @Override
    public void visitUser(User user) {
        setMessageTotal(getMessageTotal() + user.getMyTweets().size());
    }

    @Override
    public void visitGroup(User_Group group) {
       
    }

    public int getMessageTotal() {
        return TotalMessage;
    }

    public void setMessageTotal(int totalMessage) {
        TotalMessage = totalMessage;
    }
    
}