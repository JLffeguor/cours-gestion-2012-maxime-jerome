package be.winecave.fenetre.migLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListDataListener;
import javax.swing.text.MaskFormatter;

import com.sun.xml.internal.bind.v2.model.impl.ModelBuilder;

import be.winecave.main.GUIConnector;

import net.miginfocom.layout.AC;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.ConstraintParser;
import net.miginfocom.layout.IDEUtil;
import net.miginfocom.layout.LC;
import net.miginfocom.layout.PlatformDefaults;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class PanelHelper extends JPanel{
	private static GUIConnector guiConnector;
	public static final int INITIAL_INDEX = 0;
	private static final boolean OPAQUE = false;
	
	private static boolean buttonOpaque = true;
	private static boolean contentAreaFilled = true;

	public PanelHelper(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout,isDoubleBuffered);
	}
	public PanelHelper(LayoutManager layout) {
		super(layout, true);
	}
	public PanelHelper(boolean isDoubleBuffered) {
		super(new FlowLayout(), isDoubleBuffered);
	}
	public PanelHelper() {
		super(true);
	}
	
	static GUIConnector getGuiConnector(){
		System.out.println("is it thread safe? " + SwingUtilities.isEventDispatchThread());
		return guiConnector;
	}	
	static void setConnector(GUIConnector connector) {
		guiConnector = connector;	
	}
	
	//***********************************************************
	//* helper class
	//***********************************************************
	class DisabledJCombobox<E> extends JComboBox<E> {
		DisabledJCombobox() {
			super();
			this.setEnabled(false);
		}
		
		void enableWithData(List<? extends E> dataList){
			this.setEnabled(true);
			this.setModel(new DefaultComboBoxModel<>(new Vector<E>(dataList)));
		}
	}
	
	class UnselectedJCombobox<E> extends JComboBox<E> {
		UnselectedJCombobox() {
			super();
			this.setSelectedIndex(-1);
		}
		
		UnselectedJCombobox(List<E> dataList) {
			super(new Vector<E>(dataList));
			this.setSelectedIndex(-1);
		}
	}
	
	class EditableUnselectedJCombobox<E> extends UnselectedJCombobox<E> {
		EditableUnselectedJCombobox() {
			super();
			this.setEditable(true);
		}
		
		EditableUnselectedJCombobox(List<E> dataList) {
			super(dataList);
			this.setEditable(true);
		}
	}
	
	class SimpleJFormattedTextField extends JFormattedTextField {
		SimpleJFormattedTextField(String maskFormatter, String validCharacters) {
			super();
			MaskFormatter mask = null;
			try {
				mask = new MaskFormatter(maskFormatter);
			} catch (ParseException e) {
				//TODO handle when save event
				System.out.println("i get exception");
				e.printStackTrace();
			}
			if(validCharacters != null) {
				mask.setValidCharacters(validCharacters);
			}
			this.setFormatter(mask);
		}
		
		SimpleJFormattedTextField(String maskFormatter) {
			this(maskFormatter,null);
		}
	}

	// **********************************************************
	// * Helper Methods
	// **********************************************************

	JLabel createLabel(String text)
	{
		return createLabel(text, SwingConstants.LEADING);
	}

	JLabel createLabel(String text, int align)
	{
		final JLabel b = new JLabel(text, align);
		return b;
	}

	JTextField createTextField(int cols)
	{
		return createTextField("", cols);
	}

	JTextField createTextField(String text)
	{
		return createTextField(text, 0);
	}

	JTextField createTextField(String text, int cols)
	{
		final JTextField b = new JTextField(text, cols);

		return b;
	}

	private static final Font BUTT_FONT = new Font("monospaced", Font.PLAIN, 12);
	JButton createButton()
	{
		return createButton("");
	}

	JButton createButton(String text)
	{
		return createButton(text, false);
	}

	JButton createButton(String text, boolean bold)
	{
		@SuppressWarnings("serial")
		JButton b = new JButton(text) {
			public void addNotify()
			{
				super.addNotify();
				if (getText().length() == 0) {
					String lText = (String) ((MigLayout) getParent().getLayout()).getComponentConstraints(this);
					setText(lText != null && lText.length() > 0 ? lText : "<Empty>");
				}
			}
		};

		if (bold)
			b.setFont(b.getFont().deriveFont(Font.BOLD));

		b.setOpaque(buttonOpaque); // Or window's buttons will have strange border
		b.setContentAreaFilled(contentAreaFilled);

		return b;
	}

	JToggleButton createToggleButton(String text)
	{
		JToggleButton b = new JToggleButton(text);
		//			configureActiveComponet(b);
		b.setOpaque(buttonOpaque); // Or window's buttons will have strange border
		return b;
	}

	JCheckBox createCheck(String text)
	{
		JCheckBox b = new JCheckBox(text);

		b.setOpaque(OPAQUE); // Or window's checkboxes will have strange border
		return b;
	}

	JTextArea createTextArea(String text, int rows, int cols)
	{
		JTextArea ta = new JTextArea(text, rows, cols);
		ta.setBorder(UIManager.getBorder("TextField.border"));
		ta.setFont(UIManager.getFont("TextField.font"));
		ta.setWrapStyleWord(true);
		ta.setLineWrap(true);

		return ta;
	}

	JScrollPane createTextAreaScroll(String text, int rows, int cols, boolean hasVerScroll)
	{
		JTextArea ta = new JTextArea(text, rows, cols);
		ta.setFont(UIManager.getFont("TextField.font"));
		ta.setWrapStyleWord(true);
		ta.setLineWrap(true);

		JScrollPane scroll = new JScrollPane(
				ta,
				hasVerScroll ? ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED : ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		return scroll;
	}

	static final Color LABEL_COLOR = new Color(0, 70, 213);
	void addSeparator(JPanel panel, String text)
	{
		JLabel l = createLabel(text);
		l.setForeground(LABEL_COLOR);

		panel.add(l, "gapbottom 1, span, split 2, aligny center");
		panel.add(new JSeparator(), "gapleft rel, growx");
	}
}
