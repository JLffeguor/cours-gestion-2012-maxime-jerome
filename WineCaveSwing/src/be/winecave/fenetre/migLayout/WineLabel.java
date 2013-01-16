package be.winecave.fenetre.migLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class WineLabel extends PanelHelper {
	
	private JLabel lblwineLabel;
	
	public WineLabel() {
		
		add(getLblWineLabel());
		
	}
	
	private JLabel getLblWineLabel() {
		if (lblwineLabel == null) {
			lblwineLabel = new JLabel("");
			lblwineLabel.setBounds(0, 0, 1044, 572);
			lblwineLabel.setIcon(new ImageIcon(WineLabel.class.getResource("/images/ProvenceChateauneufDuPape.jpg")));
		}
		return lblwineLabel;
	}

}
