package speedDeleveryTime.ejbImpl;

import javax.ejb.Stateless;

import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;
import speedDeleveryTime.interfaces.EJB_Entity;
import speedDeleveryTime.utils.Constants;

@Stateless(mappedName=Constants.COMMANDE_MAPPED_NAME)
public class EJB_Commande implements EJB_Entity {

	@Override
	public DataResponse processDao(DataRequest info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResponse processListener(DataRequest content) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
