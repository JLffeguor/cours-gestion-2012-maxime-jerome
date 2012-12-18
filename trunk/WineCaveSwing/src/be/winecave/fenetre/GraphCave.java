package be.winecave.fenetre;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GraphCave extends JFrame {
	private static final long serialVersionUID = 1L;
	
	Border border = LineBorder.createBlackLineBorder();
	Border border2 = LineBorder.createGrayLineBorder();
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GraphCave() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 455, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setContentPane(new PanneauVin());
	} 
	
}
