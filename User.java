public class User implements Observer {
    private String userId;

    public User(String userId) {
        this.userId = userId;
    }

    @Override
    public void update(String message) {
        System.out.println("User " + userId + " received message: " + message);
    }
}
