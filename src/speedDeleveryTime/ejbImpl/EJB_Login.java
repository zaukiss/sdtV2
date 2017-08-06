package speedDeleveryTime.ejbImpl;

import javax.ejb.Stateless;

import speedDeleveryTime.dao.LoginDao;
import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;
import speedDeleveryTime.interfaces.EJB_Entity;
import speedDeleveryTime.utils.Constants;


@Stateless(mappedName=Constants.LOGIN_MAPPED_NAME)
public class EJB_Login implements EJB_Entity {

	@Override
	public DataResponse processDao(DataRequest info) {

		return (new LoginDao()).getData(info);
	}

	@Override
	public DataResponse processListener(DataRequest content) {
		return null; 
		
	}

}
