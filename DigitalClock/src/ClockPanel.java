
import java.awt.GridLayout;
import java.awt.Panel;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christoph Mautner
 */
public class ClockPanel extends JPanel implements Runnable
{
    private LocalTime time;
    private int hours;
    private int minutes;
    private int seconds;
    
    private DigitsLabel[] labels = new DigitsLabel[8];
    
    public ClockPanel()
    {
        this.setSize(1920, 1080);
        this.setLayout(new GridLayout(1, 8));
        this.setName("paClock");
        updateTime();
        initComponents();
    }
    
    public void updateTime()
    {
        
        time=LocalTime.now(); 
        hours=time.getHour();
        minutes=time.getMinute();
        seconds=time.getSecond();
    }
    
    public void initComponents()
    {
        DigitsLabel label;
        for(int i =0; i<labels.length;i++)
        {
            switch(i)
            {
                case 0: label = new DigitsLabel(hours/10);
                break;
                case 1: label = new DigitsLabel(hours%10);
                break;
                case 2: label = new DigitsLabel();
                break;
                case 3: label = new DigitsLabel(minutes/10);
                break;
                case 4: label = new DigitsLabel(minutes%10);
                break;
                case 5: label = new DigitsLabel();
                break;
                case 6: label = new DigitsLabel(seconds/10);
                break;
                default: label = new DigitsLabel(seconds%10);
                break;
            }
            labels[i]=label;
            this.add(label);
        }
    }
    
    public void updateComponents()
    {
        int i =0;
        for(DigitsLabel label: labels)
        {
            switch(i)
            {
                case 0: label = new DigitsLabel(hours/10);
                break;
                case 1: label = new DigitsLabel(hours%10);
                break;
                case 3: label = new DigitsLabel(minutes/10);
                break;
                case 4: label = new DigitsLabel(minutes%10);
                break;
                case 6: label = new DigitsLabel(seconds/10);
                break;
                case 7: label = new DigitsLabel(seconds%10);
                break;
            }
            labels[i]=label;
            i++;
            
        }
    }
    
    @Override
    public void run()
    {
        do
        {
            updateTime();
            updateComponents();
            repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClockPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(true);
    }
    
}
