package speedDeleveryTime.controlleur;

import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.dataImpl.DataResponse;

public class SynchObject {
	
	private static SynchObject shared = null;
	private DataResponse responseTable =  new DataResponse();
	private DataRequest requestTable =  new DataRequest();
	private boolean isRequestWaiting = false; 
	private boolean isResponseWaiting = false;
	
	private SynchObject(){ }
	
	public static SynchObject getShared(){
		
		if(shared == null) shared =  new SynchObject();
		return shared;
		
	}

	public synchronized DataResponse getResponses() {
		
		while(!isResponseWaiting){
			try {
				this.wait();
			} catch (InterruptedException e) {
				
				throw new RuntimeException();
			}
			
		}
		
		isResponseWaiting = false;
		return responseTable;
	}

	public synchronized void setResponses(DataResponse responseTable) {
		
		this.responseTable = responseTable;
		isResponseWaiting = true;
		isRequestWaiting = false;
		this.notify();
		
	}

	public synchronized DataRequest getRequests() {
		while(!isRequestWaiting){
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				throw new RuntimeException();
			}
			
		}
		isRequestWaiting = false;
		return requestTable;
	}

	public synchronized void setRequests(DataRequest requestTable) {
		
		System.out.println("SynchObject.setRequest :  start");
		this.requestTable = requestTable;
		isRequestWaiting = true;
		isResponseWaiting = false;
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
