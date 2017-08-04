package speedDeleveryTime.interfaces;

import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;

public interface EJB_DAO {
	
	public DataResponse getData(DataRequest info);
	public void setData(DataRequest contentToWrite, int entityType );

}
