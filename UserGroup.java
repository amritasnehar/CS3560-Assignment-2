public class UserGroup {
    private String groupId;
    private long creationTime;

    public UserGroup(String groupId) {
        this.groupId = groupId;
        this.creationTime = System.currentTimeMillis();
    }

    public long getCreationTime() {
        return creationTime;
    }

    // Other methods
}
