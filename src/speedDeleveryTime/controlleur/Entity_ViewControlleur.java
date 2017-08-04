package speedDeleveryTime.controlleur;

import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;
import speedDeleveryTime.interfaces.IEntity_View;
import speedDeleveryTime.utils.Constants;
import speedDeleveryTime.view.EntityLogin_View;
import speedDeleveryTime.view.MainScreen;

public class Entity_ViewControlleur extends Thread {

	private DataRequest requests;
	private DataResponse responses;
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
			System.out.println(responses);
			int actionResponse =  (int) ( (responses  != null ) ?  responses.get(Constants.ACTION_RESPONSE_KEY) : Constants.NO_ACTION);
			switch(actionResponse){

			case Constants.NO_ACTION:
				System.out.println("MainScreen.configure : nothing to do");
				return;

			case Constants.ACTION_RESPONSE_DISPLAY_LOGIN_VIEW:

				IEntity_View v =  (IEntity_View) responses.get(Constants.ENTITY_LOGIN_NAME);
				if(v != null ){

					v.Display();
					MainScreen.getShared().add(((EntityLogin_View) v).getView());
					MainScreen.getShared().Display();

				}
				break;

			case Constants.ACTION_RESPONSE_CONNECT_USER:
				boolean connectionState =  (boolean)((responses.get(Constants.ACTION_RESPONSE_CONNECTION_RESULT) != null) ? 
						responses.get(Constants.ACTION_RESPONSE_CONNECTION_RESULT) : false);
				
				if(connectionState){
					
					
					
				}else{
					
					//TODO manage error from connection
					
				}
				break;

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
