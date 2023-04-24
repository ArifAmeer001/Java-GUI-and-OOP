/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Arif
 */
public class CardGame extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    
    private JButton refreshButton;
    private JLabel[] cardLabels;
    private ImageIcon[] cardImages;
    private Deck deck;

    public CardGame() {
        super("Card Game");

        // Initialize deck of cards
        deck = new Deck();

        // Set up GUI components
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel cardPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        cardLabels = new JLabel[4];
        cardImages = new ImageIcon[4];
        for (int i = 0; i < 4; i++) {
            cardLabels[i] = new JLabel();
            cardLabels[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
            cardPanel.add(cardLabels[i]);
        }
        c.add(cardPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(this);
        buttonPanel.add(refreshButton);
        c.add(buttonPanel, BorderLayout.SOUTH);

        setSize(950, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Draw four cards from the deck and display their images
        for (int i = 0; i < 4; i++) {
            Card card = deck.drawCard();
            cardImages[i] = new ImageIcon(getClass().getResource(card.getImagePath()));
            cardLabels[i].setIcon(cardImages[i]);
        }
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

class Deck {
    private Card[] cards;
    private int nextCardIndex;

    public Deck() {
        cards = new Card[52];
        int i = 0;
        for (int rank = 1; rank <= 13; rank++) {
            cards[i++] = new Card(rank, "hearts");
            cards[i++] = new Card(rank, "diamonds");
            cards[i++] = new Card(rank, "clubs");
            cards[i++] = new Card(rank, "spades");
        }
        shuffle();
    }

    public void shuffle() {
        nextCardIndex = 0;
        for (int i = 0; i < 52; i++) {
            int j = (int) (Math.random() * 52);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public Card drawCard() {
        return cards[nextCardIndex++];
    }
}

class Card {
    private int rank;
    private String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getImagePath() {
        return "/cards/"+ rank + "_" + suit + ".png";
    }
}
