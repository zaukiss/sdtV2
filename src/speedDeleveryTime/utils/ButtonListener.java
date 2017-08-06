package speedDeleveryTime.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import speedDeleveryTime.controlleur.Entity_ViewControlleur;
import speedDeleveryTime.dataImpl.DataRequest;

public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("but : "+e.getActionCommand());

		switch (e.getActionCommand()) {
		
		case Constants.BUTTON_INSCRIPTION:
			
			break;

		case Constants.BUTTON_LOGIN:
			DataRequest d = new DataRequest();
			d.put(Constants.ACTION_REQUEST_KEY, Constants.ACTION_REQUEST_CONNECT_USER);
			Entity_ViewControlleur.getShared().setRequests(d);
			break;
			
		case Constants.BUTTON_ALERT:
			
			break;
			
		case Constants.BUTTON_CALL:
			
			break;
			
		case Constants.BUTTON_CREATION:
			
			break;
			
		case Constants.BUTTON_MODIFICATION:
			
			break;
			
		case Constants.BUTTON_PLANNIFICATION:
			
			break;
			
		case Constants.BUTTON_PROFILE:
			
			break;
			
		case Constants.BUTTON_SETTING:
			
			break;
		case Constants.BUTTON_STATISTIQUE:
			
			break;
			
		case Constants.BUTTON_VISUALISER_COMMANDE:
			
			break;
			
		case Constants.BUTTON_VISUALISER_LIVREUR:
			
			break;
			

		}

	}
}
