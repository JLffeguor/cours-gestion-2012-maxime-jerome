package be.winecave.main;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class ProgressDialog extends JFrame 
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JProgressBar progressbar;

    public ProgressDialog() 
    {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());
        progressbar = new JProgressBar(0, 100);
        progressbar.setValue(0);
        progressbar.setStringPainted(true);
        pane.add(progressbar);
        setContentPane(pane);
    }

    /**
     * Afficher la progression de tache
     */

    public void loop1() 
    {
        int position = 0;
        while (position < 10) 
        {
            progressbar.setValue(position);
            try 
            {
                Thread.sleep(500);
            } catch (InterruptedException e) 
            {
            }
            position += 5;
        }
    }
    
    public void loop2() 
    {
        int position = 0;
        while (position < 20) 
        {
            progressbar.setValue(position);
            try 
            {
                Thread.sleep(500);
            } catch (InterruptedException e) 
            {
            }
            position += 5;
        }
    }
    
    public void loop3() 
    {
        int position = 0;
        while (position < 100) 
        {
            progressbar.setValue(position);
            try 
            {
                Thread.sleep(500);
            } catch (InterruptedException e) 
            {
            }
            position += 5;
        }
    }
    
    public void loop4() 
    {
        int position = 0;
        while (position < 90) 
        {
            progressbar.setValue(position);
            try 
            {
                Thread.sleep(500);
            } catch (InterruptedException e) 
            {
            }
            position += 5;
        }
    }
    
    public void loop5() 
    {
        int position = 0;
        while (position < 80) 
        {
            progressbar.setValue(position);
            try 
            {
                Thread.sleep(500);
            } catch (InterruptedException e) 
            {
            }
            position += 5;
        }
    }
    
   
}