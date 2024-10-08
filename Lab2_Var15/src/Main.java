import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ImageProcessingApp app = new ImageProcessingApp();
                app.setSize(800, 370);
                app.setVisible(true);
                app.setResizable(false);
                app.setLocationRelativeTo(null);
            }
        });
    }
}
