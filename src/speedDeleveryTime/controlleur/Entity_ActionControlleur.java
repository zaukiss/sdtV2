package speedDeleveryTime.controlleur;

import speedDeleveryTime.actionEntity.LoginAction;
import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;
import speedDeleveryTime.listener.CommandeListener;
import speedDeleveryTime.utils.Constants;
import speedDeleveryTime.view.EntityLogin_View;

public class Entity_ActionControlleur extends Thread {

	private DataRequest requests;
	private DataResponse responses;
	
	private static Entity_ActionControlleur shared = null;

	public static Entity_ActionControlleur getShared(){

		if(shared == null) shared = new Entity_ActionControlleur();
		return shared;

	}
	
	private Entity_ActionControlleur(){
		
		super();
		
	}

	@Override
	public void run() {

		SynchObject synchronizedObj =  SynchObject.getShared();
		while(true){
			
			System.out.println("Entity_ActionControlleur : wait for request");
			requests = synchronizedObj.getRequests();
			System.out.println("Entity_ActionControlleur : receive a request");
			int actionRequest = (int) ((requests != null) ? requests.get(Constants.ACTION_REQUEST_KEY) : Constants.NO_ACTION);
			switch(actionRequest){

			case Constants.NO_ACTION:
				System.out.println("MainScreen.configure : nothing to do");
				return;

			case Constants.ACTION_REQUEST_DISPLAY_LOGIN_VIEW:

				responses = new DataResponse();
				responses.put(Constants.ACTION_RESPONSE_KEY, Constants.ACTION_RESPONSE_DISPLAY_LOGIN_VIEW);
				EntityLogin_View l =  new EntityLogin_View();
				l.configure(null);
				responses.put(Constants.ENTITY_LOGIN_NAME, l);
				break;
				
			case Constants.ACTION_REQUEST_CONNECT_USER:

				LoginAction lAct = new LoginAction();
				responses = lAct.execute(requests);
				responses.put(Constants.ACTION_RESPONSE_KEY, Constants.ACTION_RESPONSE_CONNECT_USER);
				if(responses.get(Constants.ACTION_RESPONSE_CONNECTION_RESULT) != null 
						&& ((boolean) responses.get(Constants.ACTION_RESPONSE_CONNECTION_RESULT))){
					
					(new CommandeListener()).start();
					
				}else{
					
					//TODO : add reason of connection failed to response
					
				}
				break;
			case Constants.ACTION_REQUEST_RECEIVE_NEW_ORDER:
				System.out.println("new OrderReceive : "+ requests.get(Constants.ACTION_REQUEST_NEW_ORDER_DATA).toString());
				continue;

			}
			synchronizedObj.setResponses(responses);
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
