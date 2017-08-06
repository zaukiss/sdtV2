package speedDeleveryTime.dao;

import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;
import speedDeleveryTime.interfaces.EJB_DAO;
import speedDeleveryTime.utils.Constants;

public class LoginDao implements EJB_DAO {

	@Override
	public DataResponse getData(DataRequest info) {
		
		DataResponse d = new DataResponse();
		int actionRequest =  (int)info.get(Constants.ACTION_REQUEST_KEY);
		switch(actionRequest){
		
		case Constants.NO_ACTION:
			System.out.println("LoginDao : No Action");
			return null;
			
		case Constants.ACTION_REQUEST_CONNECT_USER:
			d.put(Constants.ACTION_RESPONSE_CONNECTION_RESULT, true);
			break;
			
		}

		//TODO :   lecture de la BD.
		
		return d;
	}

	@Override
	public void setData(DataRequest contentToWrite, int entityType) {
			
		//TODO :  écriture dans la BD.
		
	}

}
