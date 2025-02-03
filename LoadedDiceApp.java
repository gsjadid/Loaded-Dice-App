package Practice;

import javax.swing.*;
import java.awt.*;

public class LoadedDiceApp extends JFrame {
    private int roll = 1; // Default initial dice face

    public LoadedDiceApp() {
        // Set up the JFrame
        setTitle("Loaded Dice");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the dice panel
        DicePanel dicePanel = new DicePanel();

        // Create the roll button
        JButton rollButton = new JButton("Roll Dice");
        rollButton.setFont(new Font("Arial", Font.BOLD, 18));
        rollButton.addActionListener(e -> {
            roll = LoadedDice.rollLoadedDice(); // Roll the loaded dice
            dicePanel.setRoll(roll);           // Update the roll in the panel
            dicePanel.repaint();               // Redraw the dice face
        });

        // Add components to the frame
        add(dicePanel, BorderLayout.CENTER);
        add(rollButton, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoadedDiceApp(); // Start the application
    }
}
