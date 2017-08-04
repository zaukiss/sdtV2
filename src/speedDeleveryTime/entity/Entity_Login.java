package speedDeleveryTime.entity;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;
import speedDeleveryTime.interfaces.EJB_Entity;
import speedDeleveryTime.interfaces.IEntity;
import speedDeleveryTime.utils.Constants;

public class Entity_Login implements IEntity{

	@Override
	public DataResponse processBuissnessLogic(DataRequest info) {
		
		Properties env = new Properties();
		env.setProperty("org.omg.CORBA.ORBInitialHost", Constants.SERVER_BEAN_IP_ADDRESS);
		env.setProperty("org.omg.CORBA.ORBInitialPort", Constants.SERVER_BEAN_PORT);
		InitialContext ctx;
		EJB_Entity e = null;
		try {
			
			ctx = new InitialContext(env);
			e = (EJB_Entity) ctx.lookup(Constants.LOGIN_MAPPED_NAME);
			

		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		
		return e.processDao(info);
	}

}
