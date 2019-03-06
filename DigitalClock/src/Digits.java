
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christoph Mautner
 */
public enum Digits
{
    ZERO(".//Digits/7-segment-display-0.png"),ONE(".//Digits/7-segment-display-1.png"),TWO(".//Digits/7-segment-display-2.png"),THREE(".//Digits/7-segment-display-3.png"),FOUR(".//Digits/7-segment-display-4.png"),FIVE(".//Digits/7-segment-display-5.png"),SIX(".//Digits/7-segment-display-6.png"),SEVEN(".//Digits/7-segment-display-7.png"),EIGHT(".//Digits/7-segment-display-8.png"),NINE(".//Digits/7-segment-display-9.png"),POINT(".//Digits/7-segment-display-doublePoint.png");
    private Image img;
    
    private Digits(String path)
    {
        img = new ImageIcon(path).getImage().getScaledInstance(120, 200, Image.SCALE_SMOOTH);
    }
    
    public Image getImg()
    {
        return img;
    }
}
