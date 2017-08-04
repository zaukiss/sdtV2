package speedDeleveryTime.interfaces;

import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;

public interface IEntity_Action {

	public abstract DataResponse execute(DataRequest info);

}
