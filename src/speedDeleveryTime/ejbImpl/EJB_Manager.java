package speedDeleveryTime.ejbImpl;

import javax.ejb.Stateless;

import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;
import speedDeleveryTime.interfaces.EJB_Entity;
import speedDeleveryTime.utils.Constants;

@Stateless(mappedName=Constants.MANAGER_MAPPED_NAME)
public class EJB_Manager implements EJB_Entity {


	@Override
	public void processListener(Object data, int id) {
	
		
	}

	@Override
	public DataResponse processDao(DataRequest info) {
		
		return null;
	}

}
