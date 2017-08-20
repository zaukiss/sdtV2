package speedDeleveryTime.utils;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScrollPaneLine extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private String _content;
	private int _numLine = 0;
	private JButton _iconDelete;
	private JButton _iconValidate;
	private JLabel _name;
	
	public ScrollPaneLine(String content, int numLine) {
		
		super();
		
		this.setLayout(new BorderLayout());
		this._content = content+"_"+numLine;
		this._numLine = numLine;

		JPanel rightPan = new JPanel(); 		
		_iconDelete = new JButton();
		_iconValidate = new JButton();
		_name = new JLabel(content);
		
		this.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH - (speedDeleveryTime.view.MainScreen.getShared().get_floatLeftPanelWidth() + 30),64));
		
		_iconDelete.setPreferredSize(new Dimension(48, 48));
		_iconValidate.setPreferredSize(new Dimension(48, 48));

		_iconDelete.setIcon(new ImageIcon("resources/images/orderRemove.png"));
		_iconValidate.setIcon(new ImageIcon("resources/images/orderConfirm.png"));
		repaint();

		_iconDelete.setOpaque(false);
		_iconDelete.setBorder(null);
		
		_iconValidate.setOpaque(false);
		_iconValidate.setBorder(null);
		
		_iconValidate.setActionCommand(Constants.BUTTON_VALIDE_ORDER);
		_iconValidate.addActionListener(new ButtonListener());
		
		_iconDelete.setActionCommand(Constants.BUTTON_REMOVE_ORDER);
		_iconDelete.addActionListener(new ButtonListener());
		
		this.add(_name,BorderLayout.WEST);
		rightPan.add(_iconValidate);
		rightPan.add(_iconDelete);
		this.add(rightPan,BorderLayout.EAST);

	}

	public String getContent() {
		return _content;
	}

	public int getNumLine() {
		return _numLine;
	}
	
	

}
