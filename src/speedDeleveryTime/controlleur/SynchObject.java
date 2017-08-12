package speedDeleveryTime.controlleur;

import java.util.concurrent.atomic.AtomicBoolean;
import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;

public class SynchObject {

	private static SynchObject shared = null;
	private DataResponse responseTable =  new DataResponse();
	private DataRequest requestTable =  new DataRequest();
	private AtomicBoolean isRequestWaiting = new AtomicBoolean(false); 
	private AtomicBoolean isResponseWaiting = new AtomicBoolean(false);

	private SynchObject(){ }

	public static SynchObject getShared(){

		if(shared == null) shared =  new SynchObject();
		return shared;

	}

	public synchronized DataResponse getResponses() {

		while(!isResponseWaiting.get()){
			try {
				System.out.println("SynchObject.getResponses : wait request...");
				this.wait();
			} catch (InterruptedException e) {

				throw new RuntimeException();
			}

		}

		isResponseWaiting.set(false);
		return responseTable;
	}

	public synchronized void setResponses(DataResponse responseTable) {

		this.responseTable = responseTable;
		isResponseWaiting.set(true);
		isRequestWaiting.set(false);
		this.notify();


	}

	public synchronized DataRequest getRequests() {
		
		while(!isRequestWaiting.get()){
			try {
				System.out.println("SynchObject.getResponses : wait request...");
				this.wait();
			} catch (InterruptedException e) {

				throw new RuntimeException();
			}

		}
		isRequestWaiting.set(false);
		return requestTable;
	}

	public synchronized void setRequests(DataRequest requestTable) {

		System.out.println("SynchObject.setRequest :  start");
		System.out.println(requestTable);
		this.requestTable = requestTable;
		isRequestWaiting.set(true);
		isResponseWaiting.set(false);
		this.notify();
		System.out.println("SynchObject.setRequest : end");

	}

	public synchronized DataResponse getResponseTable() {
		return responseTable;
	}

	public synchronized DataRequest getRequestTable() {
		return requestTable;
	}	

}
