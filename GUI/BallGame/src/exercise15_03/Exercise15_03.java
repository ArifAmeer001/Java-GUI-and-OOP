/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercise15_03;
/**
 *
 * @author Arif
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exercise15_03 extends JFrame implements KeyListener, ActionListener {

    private static final long serialVersionUID = 1L;
    private int ballX = 100;
    private int ballY = 100;
    private JPanel panel;
    private JButton leftBtn, rightBtn, upBtn, downBtn;
    
    public Exercise15_03() {
        setTitle("Ball Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel() {
            private static final long serialVersionUID = 1L;

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillOval(ballX, ballY, 50, 50);
            }
        };
        
        panel.setFocusable(true);
        panel.addKeyListener(this);
        add(panel);
        
        leftBtn = new JButton("Left");
        leftBtn.addActionListener(this);
        rightBtn = new JButton("Right");
        rightBtn.addActionListener(this);
        upBtn = new JButton("Up");
        upBtn.addActionListener(this);
        downBtn = new JButton("Down");
        downBtn.addActionListener(this);
        
        JPanel btnPanel = new JPanel();
        btnPanel.add(leftBtn);
        btnPanel.add(rightBtn);
        btnPanel.add(upBtn);
        btnPanel.add(downBtn);
        add(btnPanel, "South");
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Exercise15_03();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            ballX -= 10;
        } else if (key == KeyEvent.VK_RIGHT) {
            ballX += 10;
        } else if (key == KeyEvent.VK_UP) {
            ballY -= 10;
        } else if (key == KeyEvent.VK_DOWN) {
            ballY += 10;
        }
        panel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leftBtn) {
            ballX -= 10;
        } else if (e.getSource() == rightBtn) {
            ballX += 10;
        } else if (e.getSource() == upBtn) {
            ballY -= 10;
        } else if (e.getSource() == downBtn) {
            ballY += 10;
        }
        panel.repaint();
    }

}
