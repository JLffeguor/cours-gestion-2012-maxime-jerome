import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InputFrame extends JFrame{
	
	private JPanel pan = new JPanel();
	private JButton bvalid = new JButton("Valider");
	
	public InputFrame()
	{
		 
		this.setTitle("encodage d'un employé");
		this.setSize(400, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setContentPane(pan);
		pan.add(bvalid,BorderLayout.SOUTH);
		bvalid.addActionListener(new class BoutonListener implements ActionListener
				{
				public void action
				})
		this.setVisible(true);
	}
	
	
	public void createFieldEmployee(String nomChamp)
	{
		JTextField ftextfiel = new JTextField("");
		JLabel nom = new JLabel(nomChamp);
		JPanel one = new JPanel();
		ftextfiel.setBackground(Color.WHITE);
		ftextfiel.setLayout(new BorderLayout());
		Font police = new Font("Arial", Font.BOLD, 14);
		ftextfiel.setFont(police);
		ftextfiel.setPreferredSize(new Dimension(180, 30));
		one.add(nom);
		one.add(ftextfiel);
		pan.add(one,BorderLayout.NORTH);
		
		pan.setBackground(Color.WHITE);
		
	}
}
