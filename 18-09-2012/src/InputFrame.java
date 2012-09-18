import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class InputFrame extends JFrame{
	
	public InputFrame()
	{
		this.setTitle("encodage d'un employé");
		this.setSize(400, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JPanel pan = new JPanel();
		pan.setBackground(Color.WHITE);
		this.setContentPane(pan);
		
		
		this.setVisible(true);
	}
}
