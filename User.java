public class User {
    private String userId;
    private long creationTime;

    public User(String userId) {
        this.userId = userId;
        this.creationTime = System.currentTimeMillis();
    }

    public long getCreationTime() {
        return creationTime;
    }

    // Other methods
}
