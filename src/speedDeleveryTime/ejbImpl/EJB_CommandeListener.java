package speedDeleveryTime.ejbImpl;

import javax.ejb.Stateless;

import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;
import speedDeleveryTime.interfaces.EJB_Entity;
import speedDeleveryTime.utils.Constants;

@Stateless(mappedName=Constants.COMMANDE_LISTENER_MAPPED_NAME)
public class EJB_CommandeListener implements EJB_Entity {

	@Override
	public DataResponse processDao(DataRequest info) {
		// TODO nothing.
		return null;
	}

	@Override
	public DataResponse processListener(DataRequest content) {
		
		//TODO : write datas in BD and return the right ACTION_RESPONSE_CONNECTION_RESULT false =  faile && true = sucess
		
		//start : just for test 
		DataResponse response =  new DataResponse();
		response.put(Constants.ACTION_RESPONSE_KEY, Constants.ACTION_RESPONSE_RECEIVE_NEW_ORDER);
		response.put(Constants.ACTION_RESPONSE_RECEIVE_NEW_ORDER_RESULT, true);
		//end
		return response;
		
		
		
	}

}
