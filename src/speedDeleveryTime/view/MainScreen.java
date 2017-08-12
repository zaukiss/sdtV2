package speedDeleveryTime.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import com.sun.msv.verifier.jarv.Const;

import speedDeleveryTime.interfaces.IEntity_View;
import speedDeleveryTime.utils.ButtonListener;
import speedDeleveryTime.utils.Constants;

public class MainScreen extends JFrame implements IEntity_View {

	private static final long serialVersionUID = 1L;
	private IEntity_View currentDisplay;
	private int width = Constants.SCREEN_WIDTH; 
	private int height = Constants.SCREEN_HEIGHT;
	private static  MainScreen shared = null;
	private JButton _setting;
	private JButton _notifIcon;
	private JButton _userIcon;
	private JPanel _middleHeader;
	private JPanel _floatLeftPan;
	private JPanel _iconright;
	private JButton _iconCall;
	private JButton _plannifierComIcon;
	private JButton _statistiqueIcon;
	private JButton _creationIcon;
	private JButton _modificationIcon;
	private JButton _visuaComIcon;
	private JButton _visuaLivIcon;
	private JPanel _headerPanel;
	private JLabel _userLogin;
	private JLabel _date;
	private ButtonListener _clickEventManager = new ButtonListener();
	private LocalDate _localDate;
	private final int __MARGIN__BOTTOM__ =  40;
	private MainScreen(){

		this.setTitle("Speed Delivery Time");
		this.setSize(width, height);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.build();

	}
	public static MainScreen getShared(){

		if(shared == null) shared = new MainScreen();
		return shared;

	}
	@Override
	public void updateView(Hashtable<String,Object> content) {

			this.invalidate();
			this.validate();
			this.repaint();

	}

	@Override
	public void hide() {


	}

	@Override
	public void Display() { this.setVisible(true); }

	@Override
	public void configure(Hashtable<String,Object> content) {

		if(content != null){

			int action =  ((content.get(Constants.ACTION_RESPONSE_KEY) != null) ? (int) content.get(Constants.ACTION_RESPONSE_KEY)  : -1);
			switch (action) {
			case Constants.NO_ACTION:
				System.out.println("MainScreen.configure : nothing to do");
				break;
			case Constants.ACTION_RESPONSE_DISPLAY_LOGIN_VIEW:

				currentDisplay =  (IEntity_View) content.get(Constants.ENTITY_LOGIN_NAME);
				this.getContentPane().add(((EntityLogin_View)currentDisplay).getView(),BorderLayout.CENTER);
				break;

			case Constants.ACTION_RESPONSE_CONNECT_USER:
				if(currentDisplay != null ){

					this.remove(currentDisplay.getView());

				}
				currentDisplay =  (IEntity_View) content.get(Constants.ENTITY_MANAGER_NAME);
				JScrollPane managerListOrder = ((JScrollPane)((EntityManager_View)currentDisplay).getContent().get(Constants.MANAGER_COMPONENT_LIST_ORDER));
				this.getContentPane().add(managerListOrder,BorderLayout.CENTER);
				updateView(null);
				break;
			}

		}


	}

	@Override
	public Hashtable<String, JComponent> getContent() {

		return currentDisplay.getContent();
	}

	@Override
	public String getViewName() {

		return Constants.ENTITY_HOME_NAME;
	}

	public void setDim(int width, int height){

		this.width = width;
		this.height = height;

	}

	private void build(){


		GridBagConstraints gbc = new GridBagConstraints();
		GridBagConstraints gbc2 = new GridBagConstraints();

		initButtonSet();
		initPanelSet();
		initLabelSet();

		//Constraints settings

		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 2;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		_headerPanel.add(_setting,gbc);

		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = GridBagConstraints.RELATIVE;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		_headerPanel.add(_middleHeader,gbc);

		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 3;
		gbc.gridy = 0;
		_headerPanel.add(_iconright, gbc);	

		gbc2.gridx = 0;
		gbc2.gridy = 0;
		_middleHeader.add(_userLogin, gbc2);

		gbc2.gridx = 0;
		gbc2.gridy = 1;
		_middleHeader.add(_date, gbc2);

		//----------------------------------- icons left

		//gbc3.gridx = 0;
		//gbc3.gridy = 0;
		_floatLeftPan.add(Box.createRigidArea(new Dimension(0,__MARGIN__BOTTOM__)));
		_plannifierComIcon.setAlignmentX(CENTER_ALIGNMENT);
		_floatLeftPan.add(_plannifierComIcon);
		_floatLeftPan.add(Box.createRigidArea(new Dimension(0,__MARGIN__BOTTOM__)));

		_statistiqueIcon.setAlignmentX(CENTER_ALIGNMENT);
		_floatLeftPan.add(_statistiqueIcon);
		_floatLeftPan.add(Box.createRigidArea(new Dimension(0,__MARGIN__BOTTOM__)));

		_creationIcon.setAlignmentX(CENTER_ALIGNMENT);
		_floatLeftPan.add(_creationIcon);
		_floatLeftPan.add(Box.createRigidArea(new Dimension(0,__MARGIN__BOTTOM__)));

		_modificationIcon.setAlignmentX(CENTER_ALIGNMENT);
		_floatLeftPan.add(_modificationIcon);
		_floatLeftPan.add(Box.createRigidArea(new Dimension(0,__MARGIN__BOTTOM__)));

		_visuaComIcon.setAlignmentX(CENTER_ALIGNMENT);
		_floatLeftPan.add(_visuaComIcon);
		_floatLeftPan.add(Box.createRigidArea(new Dimension(0,__MARGIN__BOTTOM__)));

		_visuaLivIcon.setAlignmentX(CENTER_ALIGNMENT);
		_floatLeftPan.add(_visuaLivIcon);
		_floatLeftPan.add(Box.createRigidArea(new Dimension(0,__MARGIN__BOTTOM__)));

		this.getContentPane().add(_headerPanel, BorderLayout.NORTH);
		this.getContentPane().add(_floatLeftPan,BorderLayout.WEST);

	}


	private void initButtonSet(){

		_plannifierComIcon = new JButton();
		_statistiqueIcon = new JButton();
		_creationIcon = new JButton();
		_modificationIcon = new JButton();
		_visuaComIcon = new JButton();
		_visuaLivIcon = new JButton();
		_notifIcon = new JButton();
		_userIcon = new JButton();
		_iconCall = new JButton();
		_setting = new JButton();

		_plannifierComIcon.setActionCommand(Constants.BUTTON_PLANNIFICATION);
		_statistiqueIcon.setActionCommand(Constants.BUTTON_STATISTIQUE);
		_creationIcon.setActionCommand(Constants.BUTTON_CREATION);
		_modificationIcon.setActionCommand(Constants.BUTTON_MODIFICATION);
		_visuaComIcon.setActionCommand(Constants.BUTTON_VISUALISER_COMMANDE);
		_visuaLivIcon.setActionCommand(Constants.BUTTON_VISUALISER_LIVREUR);
		_notifIcon.setActionCommand(Constants.BUTTON_ALERT);
		_userIcon.setActionCommand(Constants.BUTTON_PROFILE);
		_iconCall.setActionCommand(Constants.BUTTON_CALL);
		_setting.setActionCommand(Constants.BUTTON_SETTING);

		_setting.setPreferredSize(new Dimension(64, 53));
		_notifIcon.setPreferredSize(new Dimension(64, 50));
		_userIcon.setPreferredSize(new Dimension(64, 61));
		_iconCall.setPreferredSize(new Dimension(64,60));
		_plannifierComIcon.setPreferredSize(new Dimension(60, 64));
		_statistiqueIcon.setPreferredSize(new Dimension(60, 64));
		_creationIcon.setPreferredSize(new Dimension(60, 64));
		_modificationIcon.setPreferredSize(new Dimension(60, 64));
		_visuaComIcon.setPreferredSize(new Dimension(60, 64));
		_visuaLivIcon.setPreferredSize(new Dimension(60, 64));

		setIconSet();

		_setting.addActionListener(_clickEventManager);
		_plannifierComIcon.addActionListener(_clickEventManager);
		_statistiqueIcon.addActionListener(_clickEventManager);
		_creationIcon.addActionListener(_clickEventManager);
		_modificationIcon.addActionListener(_clickEventManager);
		_visuaComIcon.addActionListener(_clickEventManager);
		_visuaLivIcon.addActionListener(_clickEventManager);
		_notifIcon.addActionListener(_clickEventManager);
		_userIcon.addActionListener(_clickEventManager);
		_iconCall.addActionListener(_clickEventManager);

		_plannifierComIcon.setOpaque(false);
		_statistiqueIcon.setOpaque(false);
		_creationIcon.setOpaque(false);
		_modificationIcon.setOpaque(false);
		_visuaComIcon.setOpaque(false);
		_visuaLivIcon.setOpaque(false);
		_notifIcon.setOpaque(false);
		_userIcon.setOpaque(false);
		_iconCall.setOpaque(false);
		_setting.setOpaque(false);

		_plannifierComIcon.setBorder(null);
		_statistiqueIcon.setBorder(null);
		_creationIcon.setBorder(null);
		_modificationIcon.setBorder(null);
		_visuaComIcon.setBorder(null);
		_visuaLivIcon.setBorder(null);
		_notifIcon.setBorder(null);
		_userIcon.setBorder(null);
		_iconCall.setBorder(null);
		_setting.setBorder(null);

	}

	private void setIconSet(){

		try {

			_setting.setIcon(new ImageIcon("resources/images/setting.png"));
			_notifIcon.setIcon(new ImageIcon("resources/images/notification.png"));
			_userIcon.setIcon(new ImageIcon("resources/images/userIcon.png"));
			_iconCall.setIcon(new ImageIcon("resources/images/callIcon.png"));
			_plannifierComIcon.setIcon(new ImageIcon("resources/images/iconPlanning.png"));
			_statistiqueIcon.setIcon(new ImageIcon("resources/images/iconStatistique.png"));
			_creationIcon.setIcon(new ImageIcon("resources/images/iconCreerCommand.png"));
			_modificationIcon.setIcon(new ImageIcon("resources/images/iconModifierCommande.png"));
			_visuaComIcon.setIcon(new ImageIcon("resources/images/visualiseationCommande.png"));
			_visuaLivIcon.setIcon(new ImageIcon("resources/images/visualisationsationLivreur.png"));

			repaint();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private void initPanelSet(){

		_headerPanel =  new JPanel();
		_middleHeader =  new JPanel();
		_floatLeftPan = new JPanel();
		_iconright = new JPanel();

		_middleHeader.setPreferredSize(new Dimension(Constants.HEADER_MIDDLE_PAN_WIDTH, 61));
		_headerPanel.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH,85));
		_floatLeftPan.setPreferredSize(new Dimension(250, Constants.SCREEN_HEIGHT -  _headerPanel.getHeight() ) );

		GridLayout gLay = new GridLayout(1, 3);
		_iconright.setLayout(gLay);;
		_iconright.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH - _middleHeader.getHeight() ,61));
		_iconright.setOpaque(false);
		_iconright.add(_userIcon);
		_iconright.add(_notifIcon);
		_iconright.add(_iconCall);

		GridBagLayout layout = new GridBagLayout();

		_headerPanel.setLayout(layout);
		_middleHeader.setLayout(layout);
		_floatLeftPan.setLayout(new BoxLayout(_floatLeftPan, BoxLayout.Y_AXIS));

	}

	private void initLabelSet(){

		_userLogin = new JLabel("User : Test");
		_localDate = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		_date = new JLabel("Date : "+  _localDate.format(dtf));
		_userLogin.setPreferredSize(new Dimension(100, 75));
		_date.setPreferredSize(new Dimension(100, 75));
		_userLogin.setFont(new Font("Arial", Font.BOLD , 24));
		_date.setFont(new Font("Arial", Font.BOLD , 24));
		_userLogin.setForeground(new Color(192,92,192));
		_date.setForeground(new Color(192,92,192));

	}
	public void setCurrentDisplay(IEntity_View currentDisplay) {
		this.currentDisplay = currentDisplay;
	}

	public IEntity_View getCurrentDisplay(){

		return currentDisplay;

	}

	public int get_floatLeftPanelHeight() {

		return _floatLeftPan.getHeight();
	}
	public int get_floatLeftPanelWidth() {

		return _floatLeftPan.getWidth();
	}
	@Override
	public JPanel getView() {
		// TODO Auto-generated method stub
		return null;
	}




}
