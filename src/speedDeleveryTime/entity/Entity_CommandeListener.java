package speedDeleveryTime.entity;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import speedDeleveryTime.controlleur.Entity_ActionControlleur;
import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;
import speedDeleveryTime.interfaces.EJB_Entity;
import speedDeleveryTime.interfaces.IEntity;
import speedDeleveryTime.utils.Constants;

public class Entity_CommandeListener implements IEntity {

	@Override
	public DataResponse processBuissnessLogic(DataRequest info) {

		Properties env = new Properties();
		env.setProperty("org.omg.CORBA.ORBInitialHost", Constants.SERVER_BEAN_IP_ADDRESS);
		env.setProperty("org.omg.CORBA.ORBInitialPort", Constants.SERVER_BEAN_PORT);
		InitialContext ctx;
		DataResponse dr ;
		EJB_Entity e = null;
		try {

			ctx = new InitialContext(env);
			e = (EJB_Entity) ctx.lookup(Constants.COMMANDE_LISTENER_MAPPED_NAME);
			dr = e.processListener(info);
			
			if(dr.get(Constants.ACTION_RESPONSE_RECEIVE_NEW_ORDER_RESULT) != null
					&& (boolean)dr.get(Constants.ACTION_RESPONSE_RECEIVE_NEW_ORDER_RESULT)){
				
				Entity_ActionControlleur.getShared().setRequests(info);
				return dr;
			}else{
				
				System.out.println("Entity_CommandeListener.processBuissnessLogic : cannot do this cause :"+
				"dr = "+dr.get(Constants.ACTION_RESPONSE_RECEIVE_NEW_ORDER_RESULT));
			}
			
			

		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		

		return null;
	}

}
