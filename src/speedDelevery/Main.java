package speedDelevery;


import speedDeleveryTime.controlleur.Entity_ActionControlleur;
import speedDeleveryTime.controlleur.Entity_ViewControlleur;
import speedDeleveryTime.controlleur.SynchObject;
import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.utils.Constants;

public class Main {

	public  static void main(String[] args) {

		DataRequest data = new DataRequest();
		data.put(Constants.ACTION_REQUEST_KEY, Constants.ACTION_REQUEST_DISPLAY_LOGIN_VIEW);
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
					SynchObject o = SynchObject.getShared();
					o.setRequests(data);

			}
		});
		Entity_ActionControlleur.getShared().start();
		Entity_ViewControlleur.getShared().start();
		t.start();

	}

}
