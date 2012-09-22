import gui.InputPanel;
import gui.TitlePanel;
import gui.Window;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;


public class Main {
	
	
	public static void main(String[] args)
	{
		Window mainWindow = new Window();
		////creating the global panel
		JPanel container = new JPanel();
		container.setBackground(Color.WHITE);
		container.setLayout(new BorderLayout());
		
		/////add iner panel
		container.add(new TitlePanel("veuillez remplir les champs"),BorderLayout.NORTH);
		InputPanel input = new InputPanel();
		container.add(input,BorderLayout.CENTER);
		container.add(input.getSubmmitButton(),BorderLayout.SOUTH);
		
		////finally, drawing the window
		mainWindow.setContentPane(container);
		mainWindow.setVisible(true);
		
	}


}
