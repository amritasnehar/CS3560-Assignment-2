import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class AdminControlPanel extends JFrame {
    private JButton addButton;
    private JTree userTree;

    private DefaultMutableTreeNode root;

    public AdminControlPanel() {
        setTitle("Admin Control Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        root = new DefaultMutableTreeNode("Root");
        userTree = new JTree(root);
        addButton = new JButton("Add User/Group");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter user/group name:");
                if (input != null && !input.isEmpty()) {
                    addUserOrGroup(input);
                }
            }
        });

        JButton verifyButton = new JButton("Verify IDs");
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = verifyUniqueIDs();
                if (result) {
                    JOptionPane.showMessageDialog(null, "All IDs are valid.");
                } else {
                    JOptionPane.showMessageDialog(null, "Some IDs are not unique or contain spaces.");
                }
            }
        });

        JButton lastUpdatedButton = new JButton("Last Updated User");
        lastUpdatedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lastUpdatedUser = getLastUpdatedUser();
                JOptionPane.showMessageDialog(null, "Last updated user: " + lastUpdatedUser);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(addButton)
                                        .addComponent(userTree)
                                        .addComponent(verifyButton)
                                        .addComponent(lastUpdatedButton))
                                .addContainerGap(200, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(addButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userTree)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(verifyButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastUpdatedButton)
                                .addContainerGap(100, Short.MAX_VALUE))
        );
    }

    private void addUserOrGroup(String name) {
        DefaultMutableTreeNode newUserGroup = new DefaultMutableTreeNode(name);
        root.add(newUserGroup);
        ((DefaultTreeModel) userTree.getModel()).reload();
    }

    public boolean verifyUniqueIDs() {
        Set<String> idSet = new HashSet<>();

        Enumeration<?> e = root.breadthFirstEnumeration();
        while (e.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
            String nodeId = node.toString().trim();

            if (idSet.contains(nodeId) || nodeId.contains(" ")) {
                return false;
            }

            idSet.add(nodeId);
        }

        return true;
    }

    public String getLastUpdatedUser() {
        // Implement logic to find the user with the latest lastUpdateTime
        // Iterate through users and compare their lastUpdateTime
        // Return the ID of the user with the latest lastUpdateTime
        return "ExampleUser";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminControlPanel adminControlPanel = new AdminControlPanel();
            adminControlPanel.setVisible(true);
        });
    }
}
