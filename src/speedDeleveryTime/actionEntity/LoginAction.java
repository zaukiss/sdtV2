package speedDeleveryTime.actionEntity;

import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;
import speedDeleveryTime.entity.Entity_Login;
import speedDeleveryTime.interfaces.IEntity_Action;

public class LoginAction implements IEntity_Action {

	@Override
	public DataResponse execute(DataRequest info) {
			
		return (new Entity_Login()).processBuissnessLogic(info);
	}

}
