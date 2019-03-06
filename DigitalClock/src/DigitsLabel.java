
import java.time.LocalTime;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christoph Mautner
 */
public class DigitsLabel extends JFrame implements Runnable
{
    private LocalTime time = LocalTime.now();
    private int hours;
    private int minits;
    private int seconds;
    
    public DigitsLabel()
    {
        time = LocalTime.now();
        hours = time.getHour();
        minits = time.getMinute();
        seconds = time.getSecond();
    }
    
    @Override
    public void run()
    {
        do
        {
            
        }while(true);
    }
    
}
