package speedDeleveryTime.controlleur;

import java.util.Hashtable;

import javax.swing.JPanel;

import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;
import speedDeleveryTime.utils.Constants;
import speedDeleveryTime.view.EntityLogin_View;
import speedDeleveryTime.view.EntityManager_View;
import speedDeleveryTime.view.MainScreen;

public class Entity_ViewControlleur extends Thread {

	private DataRequest requests;
	private DataResponse responses;
	private volatile Hashtable<String, JPanel> _viewsSubscribed =  new Hashtable<>();
	private static Entity_ViewControlleur shared = null;

	public static Entity_ViewControlleur getShared(){

		if(shared == null) shared = new Entity_ViewControlleur();
		return shared;

	}

	private Entity_ViewControlleur() {
		super();
	}

	@Override
	public void run() {

		SynchObject synchronizedObj =  SynchObject.getShared();
		while(true){
			
			System.out.println("Entity_ViewController :  wait for response");
			responses  = synchronizedObj.getResponses();
			synchronized (responses) {

				System.out.println(responses);
				int actionResponse =  (int) ( (responses  != null ) ?  responses.get(Constants.ACTION_RESPONSE_KEY) : Constants.NO_ACTION);
				switch(actionResponse){

				case Constants.NO_ACTION:
					System.out.println("MainScreen.configure : nothing to do");
					break;

				case Constants.ACTION_RESPONSE_DISPLAY_LOGIN_VIEW:

					EntityLogin_View l =  new EntityLogin_View();
					l.configure(null);
					responses.put(Constants.ENTITY_LOGIN_NAME, l);
					MainScreen.getShared().configure(responses);
					MainScreen.getShared().Display();
					break;

				case Constants.ACTION_RESPONSE_CONNECT_USER:

					if(responses.get(Constants.ACTION_RESPONSE_CONNECTION_RESULT) != null 
					&& ((boolean) responses.get(Constants.ACTION_RESPONSE_CONNECTION_RESULT))){

						EntityManager_View em = new EntityManager_View();
						em.configure(null);
						responses.put(Constants.ENTITY_MANAGER_NAME, em);
						_viewsSubscribed.put(Constants.ENTITY_MANAGER_NAME, em.getView());
						MainScreen.getShared().configure(responses);

					}else{

						//TODO : add reason of connection failed to response
						System.out.println("EntityActionControleur.ACTION_REQUEST_CONNECT_USER : bad connection result");

					}
					break;

				case Constants.ACTION_RESPONSE_RECEIVE_NEW_ORDER:
					if(MainScreen.getShared().getCurrentDisplay() instanceof EntityManager_View){

						MainScreen.getShared().getCurrentDisplay().updateView(responses);

					}
					break;

				}
			}

		}

	}

	public synchronized void setRequests(DataRequest map){

		requests =  map;
		SynchObject obj = SynchObject.getShared();
		obj.setRequests(requests);

	}

	public synchronized DataRequest getRequests() {
		return requests;
	}

	public synchronized DataResponse getResponses() {
		return responses;
	}

	public synchronized void setResponses(DataResponse responses) {
		this.responses = responses;
	}
	

}
