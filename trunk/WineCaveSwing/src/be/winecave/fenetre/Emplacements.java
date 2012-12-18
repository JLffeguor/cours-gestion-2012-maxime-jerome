package be.winecave.fenetre;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Emplacements extends JPanel {
	private static final long serialVersionUID = 1L;
	
	Border border = LineBorder.createBlackLineBorder();
	Border border2 = LineBorder.createGrayLineBorder();
	
	private JButton btnTest;

	/**
	 * Create the panel.
	 */
	public Emplacements() {
		setLayout(null);
		setBounds(5, 55, 484, 567);
		setBorder(border2);
		add(getBtnTest());
	}

	private JButton getBtnTest() {
		if (btnTest == null) {
			btnTest = new JButton("TEST");
			btnTest.setBounds(186, 265, 89, 23);
			btnTest.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					GraphCave frame = new GraphCave();
					frame.setVisible(true);
				}
			});
		}
		return btnTest;
	}
}

