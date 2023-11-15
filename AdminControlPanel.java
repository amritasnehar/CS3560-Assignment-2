import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(addButton)
                                        .addComponent(userTree))
                                .addContainerGap(200, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(addButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userTree)
                                .addContainerGap(100, Short.MAX_VALUE))
        );
    }

    public void addUserOrGroup(String name) {  // Make the method public
        DefaultMutableTreeNode newUserGroup = new DefaultMutableTreeNode(name);
        root.add(newUserGroup);
        ((DefaultTreeModel) userTree.getModel()).reload();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminControlPanel adminControlPanel = new AdminControlPanel();
            adminControlPanel.setVisible(true);
        });
    }
}
