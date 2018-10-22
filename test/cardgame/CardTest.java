/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author wml5
 */
public class CardTest {
    
    Card aCard = new Card();
    int suitCounts[] = {0,0,0,0};
    int cardCounts[] = {0,0,0,0,0,0,0,0,0,0,0,0,0}; //13 0's
    static JFrameCardGame theFrame;
    static DefaultListModel cards;
    static JLabel lblWin;
    static JButton btnHigh;
    static JButton btnLow;
    static Card lastCard, newCard;
    
    public CardTest() {
    }

    @Test
    public void testEquals() 
    {
        Card c1 = new Card();
        Card c2 = new Card();
        c1.setSuit("Spades");
        c2.setSuit("Spades");
        for(int x = 1; x <= 13; x++)
        {
            c1.setValue(x);
            c2.setValue(x);
            assertTrue("Cards are the same",c1.equals(c2));
        }
    } //End of testEquals
    
    @Test
    public void testPickCardSuit()
    {
        int correctSuitCount[] = {13,13,13,13};
        for(int x = 1; x <=52; x++)
        {
            aCard.pickCard();
            if(aCard.getSuit().equals("Hearts"))
            {
                suitCounts[0] ++;//0 == Hearts
            }
            else if(aCard.getSuit().equals("Clubs"))
            {
                suitCounts[1] ++;//1 == Clubs
            }
            else if(aCard.getSuit().equals("Diamonds"))
            {
                suitCounts[2] ++;//2 == Diamonds
            }
            else if(aCard.getSuit().equals("Spades"))
            {
                suitCounts[3] ++;//3 == Spades
            }
        }//end of for loop
        assertArrayEquals("Count of Suits",correctSuitCount, suitCounts);
    }//end of testPickCardSuit
    
    @BeforeClass
    public static void setupUpgame()
    {
        theFrame = new JFrameCardGame();
        btnLow = theFrame.getBtnLow();
        JButton btnNew = theFrame.getBtnDeal();
        btnNew.doClick();//deal
    }
    
    @Test
    public void testLow()
    {
        btnLow.doClick();
        lastCard = theFrame.getLastCard();
        newCard = theFrame.getNewCard();
        String expected;
        if(lastCard.getValue() > newCard.getValue())
        {
            expected = "Good";
        }
        else
        {
            expected = "Bad";
        }
        
        JLabel lblWin = theFrame.getLblWin();
        assertEquals("Win condition", expected, lblWin.getText().toString());
    }
}
