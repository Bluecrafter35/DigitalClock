
import java.time.LocalTime;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christoph Mautner
 */
public class DigitsLabel extends JLabel
{
    private int value;
    private Digits digit;
    
    public DigitsLabel(int value)
    {
        this.setOpaque(true);
        this.value=value;
        switch(value)
        {
            case 0: digit=Digits.ZERO;
            break;
            case 1: digit=Digits.ONE;
            break;
            case 2: digit=Digits.THREE;
            break;
            case 3: digit=Digits.THREE;
            break;
            case 4: digit=Digits.FOUR;
            break;
            case 5: digit=Digits.FIVE;
            break;
            case 6: digit=Digits.SIX;
            break;
            case 7: digit=Digits.SEVEN;
            break;
            case 8: digit=Digits.EIGHT;
            break;
            default: digit=Digits.NINE;
        }
        this.setIcon(new ImageIcon(digit.getImg()));
        repaint();
    }
    
    public DigitsLabel()
    {
        this.value=-1;
        this.digit=Digits.POINT;
        this.setIcon(new ImageIcon(digit.getImg()));
        repaint();
    }
    
    
}
