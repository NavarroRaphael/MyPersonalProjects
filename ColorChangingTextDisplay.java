import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChangingTextDisplay {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InputFrame());
    }
}

// Frame for user input
class InputFrame extends JFrame {
    private JTextField inputField;
    private JButton displayButton;

    public InputFrame() {
        setTitle("Text Input");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        inputField = new JTextField(15);
        displayButton = new JButton("Display");

        displayButton.addActionListener(e -> {
            String text = inputField.getText();
            if (!text.isEmpty()) {
                new DisplayFrame(text);
            }
        });

        add(new JLabel("Enter text:"));
        add(inputField);
        add(displayButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// Frame for displaying text with color changes
class DisplayFrame extends JFrame {
    private JLabel textLabel;
    private final Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.BLACK, Color.CYAN};
    private int colorIndex = 0;
    private Timer colorTimer;

    public DisplayFrame(String text) {
        setTitle("Color Changing Text");
        setSize(400, 200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textLabel = new JLabel(text, SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 22));
        textLabel.setForeground(colors[colorIndex]);
        add(textLabel, BorderLayout.CENTER);

        startColorTimer();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startColorTimer() {
        colorTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorIndex = (colorIndex + 1) % colors.length;
                textLabel.setForeground(colors[colorIndex]);
            }
        });
        colorTimer.start();
    }
}
