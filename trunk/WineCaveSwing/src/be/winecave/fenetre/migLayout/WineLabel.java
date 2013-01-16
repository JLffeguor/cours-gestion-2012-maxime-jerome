package be.winecave.fenetre.migLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class WineLabel extends PanelHelper {
	
	private JLabel lblwineLabel;
	private JButton btParcourir;
	
	public WineLabel() {
		
		super(new MigLayout("","",""));
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
