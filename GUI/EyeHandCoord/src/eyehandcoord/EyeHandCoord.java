/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eyehandcoord;

/**
 *
 * @author Arif
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EyeHandCoord extends JFrame implements MouseListener {

    private JPanel panel;
    private int numClicks;
    private long startTime;
    private long endTime;

    public EyeHandCoord() {
        super("Click Circle GUI");

        // Create panel and set properties
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.addMouseListener(this);

        // Add panel to frame
        add(panel);

        // Set frame properties
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Start timer
        numClicks = 0;
        startTime = System.currentTimeMillis();

        // Display first circle
        displayCircle();
    }

    public void mouseClicked(MouseEvent e) {
        // Check if click is within circle
        int x = e.getX();
        int y = e.getY();
        Circle circle = (Circle) panel.getComponent(0);
        int circleX = circle.getX() + circle.getRadius();
        int circleY = circle.getY() + circle.getRadius();
        int distance = (int) Math.sqrt(Math.pow(x - circleX, 2) + Math.pow(y - circleY, 2));
        if (distance <= circle.getRadius()) {
            // Increment click count
            numClicks++;

            // Remove circle and display new one
            panel.removeAll();
            if (numClicks < 20) {
                displayCircle();
            } else {
                // Stop timer and display time spent
                endTime = System.currentTimeMillis();
                long timeSpent = (endTime - startTime) / 1000;
                JOptionPane.showMessageDialog(this, "Time spent: " + timeSpent + " seconds");
            }

            // Refresh panel
            panel.revalidate();
            panel.repaint();
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    private void displayCircle() {
        // Generate random color and location
        Color color = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        int x = (int)(Math.random() * (panel.getWidth() - 40));
        int y = (int)(Math.random() * (panel.getHeight() - 40));

        // Create circle component and add to panel
        Circle circle = new Circle(x, y, 20, color);
        panel.add(circle);
    }

    public static void main(String[] args) {
        new EyeHandCoord();
    }

    // Custom Circle component
    private static class Circle extends JComponent {

        private int x;
        private int y;
        private int radius;
        private Color color;

        public Circle(int x, int y, int radius, Color color) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.color = color;
            setPreferredSize(new Dimension(radius * 2, radius * 2));
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getRadius() {
            return radius;
        }

        public Color getColor() {
            return color;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.fillOval(0, 0, radius * 2, radius * 2);
        }
    }
}






