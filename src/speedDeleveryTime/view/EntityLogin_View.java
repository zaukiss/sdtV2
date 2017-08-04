package speedDeleveryTime.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import speedDeleveryTime.interfaces.IEntity_View;
import speedDeleveryTime.utils.ButtonListener;
import speedDeleveryTime.utils.Constants;



public class EntityLogin_View extends JPanel implements IEntity_View {

	private static final long serialVersionUID = 1L;
	private final String name = Constants.ENTITY_LOGIN_NAME;
	private Hashtable<String, JComponent> _content =  new Hashtable<>();
	private ButtonListener _but_eventListener =  new ButtonListener();

	@Override
	public void updateView(Hashtable<String,Object> content) { }

	@Override
	public void Display() { this.setVisible(true); }

	@Override
	public void hide() { this.setVisible(false); }

	@Override
	public void configure(Hashtable<String,Object> content) {

		if(content == null){// first use, so we create the view

			createView();
		}

	}

	private void createView(){

		this.setLayout(new GridBagLayout());
		JLabel pseudo = new JLabel("Login : ");
		JLabel pass	  = new JLabel("Password : ");
		JTextField pseudoField =  new JTextField(20);
		JPasswordField passField =  new JPasswordField(20);

		pseudoField.setPreferredSize(new Dimension(425, 25));
		passField.setPreferredSize(new Dimension(425, 25));

		JButton connex = new JButton("Connexion");
		JButton regis = new JButton("s'enregistrer");

		connex.setActionCommand(Constants.BUTTON_LOGIN);
		regis.setActionCommand(Constants.BUTTON_INSCRIPTION);		
		connex.addActionListener(_but_eventListener);
		regis.addActionListener(_but_eventListener);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(50, 50, 50, 50);
		constraints.gridx = 0;
        constraints.gridy = 0;     
        this.add(pseudo, constraints);
        
        constraints.gridx = 1;
        this.add(pseudoField, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;     
        this.add(pass, constraints);
        
        constraints.gridx = 1;
        this.add(passField, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 0;
        this.add(regis, constraints);
        
        constraints.gridx = 1;
        this.add(connex, constraints);
        
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Speed Delivery Time"));


		synchronized (this._content) {
			
			this._content.put(Constants.ENTITY_LOGIN_KEY_PSEUDO_LBL, pseudo);
			this._content.put(Constants.ENTITY_LOGIN_KEY_PASSWORD_LBL, pass);
			this._content.put(Constants.ENTITY_LOGIN_KEY_PSEUDO_FIELD, pseudoField);
			this._content.put(Constants.ENTITY_LOGIN_KEY_PASSWORD_FIELD, passField);
			this._content.put(Constants.BUTTON_INSCRIPTION, regis);
			this._content.put(Constants.BUTTON_LOGIN, connex);
			
		}

	}

	@Override
	public Hashtable<String, JComponent> getContent() { return _content; }

	@Override
	public String getViewName() { return name; }

	public JPanel getView(){ return this; }


}
