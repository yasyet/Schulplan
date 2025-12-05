import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ui.MainFrame mainFrame = new ui.MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
