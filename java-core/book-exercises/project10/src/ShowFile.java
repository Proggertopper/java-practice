import javax.swing.*;
import java.awt.*;

public class ShowFile extends JFrame {
    public ShowFile() {
        setTitle("Show File");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new JLabel("Hello from Swing!"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ShowFile().setVisible(true);
        });
    }
}
