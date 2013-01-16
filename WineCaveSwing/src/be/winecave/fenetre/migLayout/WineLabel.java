package be.winecave.fenetre.migLayout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class WineLabel extends PanelHelper {
	
	private JLabel lblwineLabel;
	private JButton btParcourir;
	File etiquette = new File("C:/Users/marco/workspace/WineCaveSwing/src/images/ProvenceChateauneufDuPape.jpg");
	JFileChooser chooser = new JFileChooser();
	
	public WineLabel() {
		
		super(new MigLayout("","",""));
		add(getLblWineLabel(),"wrap");
		add(getBtParcourir(),"center");
	}
	
	private JLabel getLblWineLabel() {
		if (lblwineLabel == null) {
			lblwineLabel = new JLabel("");
			lblwineLabel.setBounds(0, 0, 1044, 572);
			lblwineLabel.setIcon(new ImageIcon(etiquette.toString()));
		}
		return lblwineLabel;
	}
	
	private JButton getBtParcourir() {
		if (btParcourir == null) {
			btParcourir = new JButton("Parcourir");
			btParcourir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					chooser.showOpenDialog(null);
					etiquette = chooser.getSelectedFile();
					System.out.println(etiquette);
					lblwineLabel.setIcon(new ImageIcon(etiquette.toString()));
					
				}
			});
			btParcourir.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			btParcourir.setBounds(200, 216, 100, 23);
		}
		return btParcourir;
	}

}
