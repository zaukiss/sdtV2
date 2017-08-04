package speedDeleveryTime.utils;

import java.awt.Toolkit;

public class Constants {
	
	public static String SERVER_BEAN_IP_ADDRESS = "127.0.0.1";
	public static String SERVER_BEAN_PORT = "3700";
	
	public static final String LOGIN_MAPPED_NAME = "ejb/login";
	public static final String COMMANDE_MAPPED_NAME = "ejb/commande";
	public static final String MANAGER_MAPPED_NAME = "ejb/manager";
	
	public static String ENTITY_LOGIN_NAME = "LoginView";
	public static String ENTITY_HOME_NAME = "MainScreen";
	public static String ENTITY_MANAGER_NAME = "ManagerView";
	
	public static String ENTITY_LOGIN_KEY_PSEUDO_LBL = "pseudo";
	public static String ENTITY_LOGIN_KEY_PASSWORD_LBL = "password";
	public static String ENTITY_LOGIN_KEY_PSEUDO_FIELD = "pseudoField";
	public static String ENTITY_LOGIN_KEY_PASSWORD_FIELD = "passField";
	
	public static final int SCREEN_WIDTH = 900;
	public static final int SCREEN_HEIGHT = 900;
	
	public static final int HEADER_BUTTON_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width /4;
	public static final int HEADER_BUTTON_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height /8;
	public static final int HEADER_MIDDLE_PAN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width /2;
	public static final int HEADER_MIDDLE_PAN_HEIGHT= Toolkit.getDefaultToolkit().getScreenSize().height /8;
	
	public static final String BUTTON_SETTING = "Settings";
	public static final String BUTTON_LOGIN = "Connexion";
	public static final String BUTTON_INSCRIPTION = "Inscription";
	public static final String BUTTON_PROFILE = "Profile";
	public static final String BUTTON_ALERT = "ALERT";
	public static final String BUTTON_CALL = "CALL";
	public static final String BUTTON_PLANNIFICATION = "Planifier";
	public static final String BUTTON_STATISTIQUE = "Statistique";
	public static final String BUTTON_CREATION = "creer";
	public static final String BUTTON_MODIFICATION = "Modifier";
	public static final String BUTTON_VISUALISER_COMMANDE= "visuliserCommnade";
	public static final String BUTTON_VISUALISER_LIVREUR = "visuliserLivreur";
	
	public static final String ACTION_REQUEST_KEY= "actionRequest";
	public static final String ACTION_RESPONSE_KEY= "actionResponse";
	public static final String ACTION_RESPONSE_CONNECTION_RESULT = "connectionResult";
	public static final int NO_ACTION = -1;
	
	public static final int ACTION_REQUEST_DISPLAY_LOGIN_VIEW = 0;
	public static final int ACTION_RESPONSE_DISPLAY_LOGIN_VIEW = 1;
	
	public static final int ACTION_REQUEST_CONNECT_USER = 2;
	public static final int ACTION_RESPONSE_CONNECT_USER = 3;
	
	
	

}
