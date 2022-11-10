import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

// Class
public class Subject extends DefaultMutableTreeNode {
    protected List<Observer> observerList = new ArrayList<>();

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObservers(String message) {
        for(Observer observer : observerList) {
            observer.update(this, message);
        }
    }
}
