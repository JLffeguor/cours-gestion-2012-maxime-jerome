package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Main;

@SuppressWarnings("serial")
public class InputPanel extends JPanel {
	
	private static final Dimension STANDARD_DIMENSION=new Dimension(180,30);

	private SubmitButton submitButton = new SubmitButton();
	
	private JTextField jtf;
	
	private ContentPanel mainContainer;
	
	
	public InputPanel(JFrame mainWindow,ContentPanel mainContainer) {
		this.setPreferredSize(new Dimension(0,20));
		this.mainContainer = mainContainer;
		jtf = new JFormattedTextField();
		jtf.setPreferredSize(STANDARD_DIMENSION);
		this.add(jtf);
	}
	
	public JButton getSubmitButton()
	{
		return submitButton.getButton();
	}
	
	
	class SubmitButton implements ActionListener{
		
		private boolean validated;
		private JButton button;

		public SubmitButton() {
			
			button = new JButton();
			
			button.setText("valider");
			button.addActionListener(this);
		}
		
		public JButton getButton(){
			return button;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			validated = true;
			int result = 0;
			try{
				result = Integer.parseInt(jtf.getText());
				if(result == 0 || Integer.toString(result).length()>4){
					validated = false;
				}
			}catch(NumberFormatException nfe){
				validated = false;
			}
			
			if(validated)
			{
				mainContainer.changeMessage("essayez encore",Color.BLACK);
			}else{
				
				mainContainer.changeMessage("mauvaise entrée",Color.RED);
				
			}
			
			Main.reloadWindow();
			
			System.out.println(result);
			
		
		}
	}
	
}
