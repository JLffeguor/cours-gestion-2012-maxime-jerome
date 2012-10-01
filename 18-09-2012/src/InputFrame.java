import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Users;
import service.UserService;



@SuppressWarnings("serial")
public class InputFrame extends JFrame implements ActionListener{
	
	private JPanel pan;
	private JButton bouton = new JButton("valider");
	JTextField jtfprenom = new JTextField("");
	JTextField jtfmatricule = new JTextField("");
	JTextField jtfnom = new JTextField("");
	Users user = new Users();
	UserService userservice = new UserService();
	
	public InputFrame()
	{
		 
		this.setTitle("encodage d'un employé");
		this.setSize(400, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		bouton.addActionListener(this);
		
		pan = new JPanel();
	    pan.setBackground(Color.ORANGE); 
	    
		this.setContentPane(pan);
		
//		bvalid.addActionListener(new class BoutonListener implements ActionListener
//				{
//				public void action
//				}
		
		JLabel labprenom = new JLabel("prénom");
		JPanel panprenom = new JPanel();
		jtfprenom.setPreferredSize(new Dimension(180,30));
		panprenom.add(labprenom);panprenom.add(jtfprenom);
		
		JLabel labnom = new JLabel("nom");
		JPanel pannom = new JPanel();
		jtfnom.setPreferredSize(new Dimension(180,30));
		panprenom.add(labnom);panprenom.add(jtfnom);
		
		JLabel labmatricule = new JLabel("matricule");
		JPanel panmatricule = new JPanel();
		jtfmatricule.setPreferredSize(new Dimension(180,30));
		panmatricule.add(labmatricule);panmatricule.add(jtfmatricule);
		
		pan.add(panmatricule,BorderLayout.NORTH);pan.add(pannom,BorderLayout.NORTH);pan.add(panprenom,BorderLayout.NORTH);
		this.add(bouton,BorderLayout.SOUTH);
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
		pan.add(one,BorderLayout.PAGE_START);
		
		pan.setBackground(Color.WHITE);		
	}
	

	public void actionPerformed(ActionEvent arg0) {

		user.setMatricule(jtfmatricule.getText());

		System.out.println(this.getClass().getName()+" matricule vaut "+jtfmatricule.getText());

		userservice.registerUser(user);
	}

	
}
