package speedDeleveryTime.interfaces;

import javax.ejb.Remote;

import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;

@Remote
public interface EJB_Entity {
	
	public DataResponse processDao(DataRequest info);
	public void processListener(Object data, int id);

}
