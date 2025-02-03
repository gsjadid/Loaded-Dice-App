package Practice;

import javax.swing.*;
import java.awt.*;

public class DicePanel extends JPanel {
    private int roll = 1; // Default dice face to display

    // Setter to update the dice roll
    public void setRoll(int roll) {
        this.roll = roll;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set background color
        g.setColor(new Color(230, 230, 230));
        g.fillRect(0, 0, getWidth(), getHeight());

        // Centering calculation
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int diceSize = 200;
        int xOffset = (panelWidth - diceSize) / 2;
        int yOffset = (panelHeight - diceSize) / 2;

        // Draw the dice background
        g.setColor(Color.WHITE);
        g.fillRoundRect(xOffset, yOffset, diceSize, diceSize, 30, 30);

        g.setColor(Color.BLACK);
        g.drawRoundRect(xOffset, yOffset, diceSize, diceSize, 30, 30);

        // Draw pips based on the roll
        drawPips(g, roll, xOffset, yOffset, diceSize);

        // Add your name as a watermark
        g.setColor(Color.GRAY);
        g.setFont(new Font("Arial", Font.ITALIC, 12));
        g.drawString("Jadid Practice Program", 10, panelHeight - 10);
    }

    private void drawPips(Graphics g, int roll, int xOffset, int yOffset, int diceSize) {
        g.setColor(Color.BLACK);
        int pipSize = 20;

        // Calculate pip positions relative to the dice center
        int centerX = xOffset + diceSize / 2;
        int centerY = yOffset + diceSize / 2;
        int offset = 50;

        // Pip positions for each face of the dice
        int[][] positions = {
                {}, // No 0 face
                {0, 0}, // 1
                {-offset, -offset, offset, offset}, // 2
                {-offset, -offset, 0, 0, offset, offset}, // 3
                {-offset, -offset, offset, -offset, -offset, offset, offset, offset}, // 4
                {-offset, -offset, offset, -offset, 0, 0, -offset, offset, offset, offset}, // 5
                {-offset, -offset, 0, -offset, offset, -offset, -offset, offset, 0, offset, offset, offset} // 6
        };

        // Draw each pip for the current roll
        for (int i = 0; i < positions[roll].length; i += 2) {
            int pipX = centerX + positions[roll][i] - pipSize / 2;
            int pipY = centerY + positions[roll][i + 1] - pipSize / 2;
            g.fillOval(pipX, pipY, pipSize, pipSize);
        }
    }
}
