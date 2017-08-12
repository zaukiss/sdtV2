package speedDeleveryTime.controlleur;

import speedDeleveryTime.actionEntity.LoginAction;
import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;
import speedDeleveryTime.listener.CommandeListener;
import speedDeleveryTime.utils.Constants;

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
			new Thread(new Runnable() {

				@Override
				public void run() {
					synchronized (requests) {

						int actionRequest = (int) ((requests != null) ? requests.get(Constants.ACTION_REQUEST_KEY) : Constants.NO_ACTION);
						System.out.println("Entity_ActionControlleur : receive a action : "+actionRequest);
						switch(actionRequest){

						case Constants.NO_ACTION:
							responses.put(Constants.ACTION_RESPONSE_KEY, Constants.NO_ACTION);
							break;

						case Constants.ACTION_REQUEST_DISPLAY_LOGIN_VIEW:

							responses = new DataResponse();
							responses.put(Constants.ACTION_RESPONSE_KEY, Constants.ACTION_RESPONSE_DISPLAY_LOGIN_VIEW);
							break;

						case Constants.ACTION_REQUEST_CONNECT_USER:

							LoginAction lAct = new LoginAction();
							responses = lAct.execute(requests);
							responses.put(Constants.ACTION_RESPONSE_KEY, Constants.ACTION_RESPONSE_CONNECT_USER);
							if(responses.get(Constants.ACTION_RESPONSE_CONNECTION_RESULT) != null 
									&& ((boolean) responses.get(Constants.ACTION_RESPONSE_CONNECTION_RESULT))){

								(new CommandeListener()).start();
							}
							break;
							
						case Constants.ACTION_REQUEST_RECEIVE_NEW_ORDER:

							responses.put(Constants.ACTION_RESPONSE_KEY, Constants.ACTION_RESPONSE_RECEIVE_NEW_ORDER);
							responses.put(Constants.DATA_COMMANDE_CONTENT,requests.get(Constants.ACTION_REQUEST_NEW_ORDER_DATA));
							break;
						}
						synchronizedObj.setResponses(responses);

					}


				}
			}).start();

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
