package be.winecave.fenetre.migLayout;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;
import be.winecave.main.GUIConnector;


public abstract class MainWindow{
	
	private static JPanel topPanel;
	private static TabbedPane tabbedPanel;
	private static JPanel bottomPanel;	
	
	private static JFrame frame;

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from
	 * the event dispatch thread.
	 */
	private static void createAndShowGUI(GUIConnector connector) {
		if (frame != null) {
			throw new RuntimeException("the JFrame can be instanciate only once");
		}
		PanelHelper.setConnector(connector);
		
		//Create and set up the window.
		frame = new JFrame("TabbedPaneDemo");
		frame.setLayout(new MigLayout("","[grow, fill]","[][grow, fill][]"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Add content to the window.
		frame.add(getTopPanel(), "height 20:50:100, wrap");
		frame.add((tabbedPanel = new TabbedPane()),"wrap");
		frame.add(getBottomPanel(), "height 20:50:100, wrap");
//		frame.setResizable(false);
		frame.setMinimumSize(frame.getPreferredSize());

		//Display the window.
//		frame.pack();
		frame.setVisible(true);
	}
	
	public static void drawWindow(final GUIConnector connector) {
		//Schedule a job for the event dispatch thread:
		//creating and showing this application's GUI.
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI(connector);
			}
		});
	}
	
	private static JPanel getTopPanel() {
		if (topPanel == null) {
			topPanel = new JPanel();
			topPanel.setOpaque(true);
			topPanel.setBackground(Color.GRAY);
		}
		return topPanel;
	}
	private static JPanel getBottomPanel() {
		if(bottomPanel != null) {
			return bottomPanel;
		}
		
		bottomPanel = new PanelHelper();
		bottomPanel.setOpaque(true);
		bottomPanel.setBackground(Color.GRAY);
		
		JButton saveButton = ((PanelHelper) bottomPanel).createButton("Enregistrer");
		saveButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				saveData();
				clearData();
			}
		});
		bottomPanel.add(saveButton);
		
		JButton cancelButton = ((PanelHelper) bottomPanel).createButton("Annuler");
		cancelButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clearData();
			}
		});
		bottomPanel.add(cancelButton);
		
		return bottomPanel;
	}
	
	private static void clearData() {
		tabbedPanel.clearData();
	}

	private static void saveData() {
		tabbedPanel.saveData();
	}
}
