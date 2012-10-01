package main;

import gui.ContentPanel;
import gui.TitlePanel;
import gui.Window;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	
	private static JFrame mainWindow;
	private static JPanel container;
	private static ContentPanel content;
	
	
	
	public static void main(String[] args) {
		
		
		mainWindow = new Window();
		
		container = new JPanel();
		container.setBackground(Color.WHITE);
		container.setLayout(new BorderLayout());
		
		content = new ContentPanel(mainWindow);

		container.add(new TitlePanel("Entrez 4 chiffres"),BorderLayout.NORTH);
		container.add(content,BorderLayout.CENTER);
		container.add(content.getInput().getSubmitButton(),BorderLayout.SOUTH);
		
		mainWindow.revalidate();
		
		////drawing the window
		mainWindow.setContentPane(container);
		mainWindow.setVisible(true);
		
	}
	
	public static void reloadWindow(){
		mainWindow.revalidate();
	}

}
