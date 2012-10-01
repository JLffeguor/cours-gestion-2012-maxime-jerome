package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TitlePanel extends JPanel{

	private String titleContent;
	
	public TitlePanel(String title) {
		this.setPreferredSize(new Dimension(0,30));
		this.titleContent=title;
	}

	public void paintComponent(Graphics g) {
		Font font = new Font("Courier", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.GRAY);  
		g.drawString(titleContent, 150, 20);
	}

}
