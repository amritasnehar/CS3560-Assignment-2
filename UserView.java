import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView extends JFrame {
    private JTextField tweetInput;
    private JButton postButton;
    private JLabel userCreationLabel;
    private JLabel groupCreationLabel;

    public UserView() {
        setTitle("User View");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        tweetInput = new JTextField();
        postButton = new JButton("Post Tweet");
        userCreationLabel = new JLabel();
        groupCreationLabel = new JLabel();

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
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(tweetInput, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(postButton))
                                        .addComponent(userCreationLabel)
                                        .addComponent(groupCreationLabel))
                                .addContainerGap(200, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(tweetInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(postButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userCreationLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(groupCreationLabel)
                                .addContainerGap(100, Short.MAX_VALUE))
        );

        // Creating a User and displaying creationTime
        User newUser = new User("exampleUserID");
        long userCreationTime = newUser.getCreationTime();
        userCreationLabel.setText("User Creation Time: " + userCreationTime); // Update label with creation time

        // Creating a UserGroup and displaying creationTime
        UserGroup newGroup = new UserGroup("exampleGroupID");
        long groupCreationTime = newGroup.getCreationTime();
        groupCreationLabel.setText("Group Creation Time: " + groupCreationTime); // Update label with creation time

        add(userCreationLabel);
        add(groupCreationLabel);
    }

    private void postTweet() {
        // Logic to post a tweet
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserView userView = new UserView();
            userView.setVisible(true);
        });
    }
}
