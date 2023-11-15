import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView extends JFrame {
    private JList<String> followingsList;
    private JList<String> newsFeedList;
    private JTextField tweetInput;
    private JButton postButton;

    private DefaultListModel<String> followingsListModel;
    private DefaultListModel<String> newsFeedListModel;

    public UserView() {
        setTitle("User View");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        followingsListModel = new DefaultListModel<>();
        newsFeedListModel = new DefaultListModel<>();

        followingsList = new JList<>(followingsListModel);
        newsFeedList = new JList<>(newsFeedListModel);

        tweetInput = new JTextField();
        postButton = new JButton("Post Tweet");

        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postTweet();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(followingsList)
                                        .addComponent(newsFeedList)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(tweetInput, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(postButton)))
                                .addContainerGap(200, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(followingsList, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newsFeedList, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(tweetInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(postButton))
                                .addContainerGap(100, Short.MAX_VALUE))
        );
    }

    private void postTweet() {
        String tweet = tweetInput.getText();
        if (!tweet.isEmpty()) {
            // Update news feed and notify followers
            newsFeedListModel.addElement(tweet);
            notifyFollowers(tweet);
            tweetInput.setText(""); // Clear the input field
        }
    }

    private void notifyFollowers(String message) {
        // Notify followers logic (to be implemented)
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserView userView = new UserView();
            userView.setVisible(true);
        });
    }
}
