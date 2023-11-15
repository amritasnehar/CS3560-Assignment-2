import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

// UserGroup class (Composite)
public class UserGroup extends DefaultMutableTreeNode implements Subject {
    private List<Observer> observers;

    public UserGroup(String groupId) {
        super(groupId);
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
