package speedDeleveryTime.interfaces;

import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;

public interface IEntity {
	
	public abstract DataResponse processBuissnessLogic(DataRequest infoinfo);
	
}
