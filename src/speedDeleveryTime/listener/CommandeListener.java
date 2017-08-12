package speedDeleveryTime.listener;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.atomic.AtomicBoolean;

import speedDeleveryTime.dataImpl.DataRequest;
import speedDeleveryTime.entity.Entity_CommandeListener;
import speedDeleveryTime.utils.Constants;
import speedDeleveryTime.utils.NetworkUtile;


public class CommandeListener extends Thread{
	private DatagramSocket sock;
	private byte[] receiveData = new byte[Constants.DATA_BUFFER_SIZE];
	private DatagramPacket _datgrameReceiver = new DatagramPacket(receiveData, Constants.DATA_BUFFER_SIZE);
	private AtomicBoolean stopListener =  new AtomicBoolean(false);
	@Override

	public void run() {

		try {

			sock = new DatagramSocket(Constants.LINSTEN_ORDER_PORT, NetworkUtile.getLocalHostLANAddress() );
			Constants.LINSTEN_ORDER_PORT =  sock.getLocalPort();
			while(true){

				if(stopListener.get()){ 

					sock.close();
					Constants.LINSTEN_ORDER_PORT = 0;
					break; 
				}

				System.out.println("wait for order in : "+sock.getLocalAddress() + ":"+ Constants.LINSTEN_ORDER_PORT);
				sock.receive(_datgrameReceiver);

				byte[] contentReceive =  _datgrameReceiver.getData();
				System.out.println("CommandeListener.notifyNew : receive some datas");
				
				if(contentReceive.length > 0){

					System.out.println("CommandeListener.notifyNew : gonne write and notify");
					DataRequest request =  new DataRequest();
					request.put(Constants.ACTION_REQUEST_KEY, Constants.ACTION_REQUEST_RECEIVE_NEW_ORDER);
					String str = new String(contentReceive);
					request.put(Constants.ACTION_REQUEST_NEW_ORDER_DATA, str );
					(new Entity_CommandeListener()).processBuissnessLogic(request);

				}else{
					
					System.out.println("content is null...");
					
				}
			}


		} catch (IOException e) {

			e.printStackTrace();
			Constants.LINSTEN_ORDER_PORT = 0;
			sock.close();
		}

	}
	
	public void stopListener(){

		stopListener.set(true);

	}

}
