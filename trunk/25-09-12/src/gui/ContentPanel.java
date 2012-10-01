package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContentPanel extends JPanel{
	
	InputPanel input;
	ResultPanel result;
	JPanel message;
	
	public ContentPanel(JFrame window) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		input = new InputPanel(window,this);
		input.setBackground(Color.yellow);
		this.add(input);
		
		result = new ResultPanel();
		result.setBackground(Color.green);
		result.setPreferredSize(new Dimension(0,80));
		this.add(result);
		
		message = new JPanel();
		result.setPreferredSize(new Dimension(0,210));
		changeMessage(" ", Color.white);
		this.add(message);
	}
	
	public InputPanel getInput() {
		return input;
	}

	public void setInput(InputPanel input) {
		this.input = input;
	}

	public ResultPanel getResult() {
		return result;
	}

	public void setResult(ResultPanel result) {
		this.result = result;
	}
	
	public void changeMessage(String mes,Color color){
		
		//remove label before
		Component comp;
		
		if(message.getComponents().length>0 && (comp = message.getComponent(0)) != null){
			message.remove(comp);
		}
		
		//and add a new
		JLabel label = new JLabel(mes);
		message.add(label);
		
		this.revalidate();
	}
}
