package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Users;
import service.UserService;

@SuppressWarnings("serial")
public class InputPanel extends JPanel {
	
	private int width;
	private int height;
	
	private UserService userservice = new UserService();
	
	private static final Dimension STANDARD_DIMENSION=new Dimension(180,30);

	private ArrayList<Component> ComponentList = new ArrayList<>();
	
	private SubmitButton submitButton = new SubmitButton();
	
	public InputPanel() {
		
		width = this.getWidth();
		height = this.getHeight();
		
		JLabel label = null;
		JTextField textField = null;
		
		for(Field field :Users.class.getDeclaredFields()){
			
			label = new JLabel(field.getName());
			label.setPreferredSize(STANDARD_DIMENSION);
			textField =  new JTextField();
			textField.setPreferredSize(STANDARD_DIMENSION);
			textField.setName(field.getName());
			this.add(label);this.add(textField);
		}
		
		label = null;
		textField = null;
		for(Component component : this.getComponents()){
			ComponentList.add(component);
		}
	}
	
	public JButton getSubmmitButton()
	{
		return submitButton.getButton();
	}
	
	public boolean isValidated()
	{
		return submitButton.validated;
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

			String name = null;
			Users user = new Users();
			JTextField text = null;
			String value = null;

			for(Component component : ComponentList){

				if((name=component.getName()) != null && component instanceof JTextField){

					text = (JTextField) component;
					value = text.getText();
					switch (name) {
					case "firstname":
						user.setFirstName(value);
						break;
					case "name":
						user.setName(value);
						break;
					case "matricule":
						user.setMatricule(value);
						break;
					case "adress":
						user.setAdress(value);
						break;
					case "childrenCount":
						user.setChildrenCount(Integer.parseInt(value));
						break;
					case "phone":
						user.setPhone(Integer.parseInt(value.trim()));
						break;
					default:
						break;
					}
				}
			}

			userservice.registerUser(user);
			
			validated=true;

		}
	}
	
}
