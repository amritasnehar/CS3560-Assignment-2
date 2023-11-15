import javax.swing.*;

// Driver class (main method)
public class TwitterDriver {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> extracted());
    }

    private static void extracted() {
        AdminControlPanel adminControlPanel = new AdminControlPanel();
        adminControlPanel.setVisible(true);
        // For testing purposes, let's add a user and show UserView
        adminControlPanel.addUserOrGroup("JohnDoe");
        UserView userView = new UserView();
        userView.setVisible(true);
    }
}
