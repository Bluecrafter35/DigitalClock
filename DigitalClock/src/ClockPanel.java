
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.time.LocalTime;
import java.time.ZoneId;
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
    
    private ZoneId zoneid;
    
    public ClockPanel()
    {
        this.zoneid = ZoneId.systemDefault();
        this.setBackground(Color.BLACK);
        this.setSize((80*8)+60, 194);
        this.setLayout(new GridLayout(1, 8));
        this.setName("paClock");
        updateTime(zoneid);
        initComponents();
    }
    
    public ClockPanel(String zone)
    {
        this.zoneid= ZoneId.of(zone);
        this.setBackground(Color.BLACK);
        this.setSize((80*8)+60, 194);
        this.setLayout(new GridLayout(1, 8));
        this.setName("paClock");
        updateTime(zoneid);
        initComponents();
    }
    
    public void updateTime(ZoneId zone)
    {
        time=LocalTime.now(zone); 
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
                case 0: label.changeValue(hours/10);
                break;
                case 1: label.changeValue(hours%10);
                break;
                case 3: label.changeValue(minutes/10);
                break;
                case 4: label.changeValue(minutes%10);
                break;
                case 6: label.changeValue(seconds/10);
                break;
                case 7: label.changeValue(seconds%10);
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
            try {
                Thread.sleep(1000);
                updateTime(zoneid);
                updateComponents();
                //repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(ClockPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(true);
    }
    
}
