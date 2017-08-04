package speedDeleveryTime.dataImpl;

import speedDeleveryTime.interfaces.IData;
import java.util.Hashtable;

public class DataRequest extends Hashtable<String, Object> implements IData {

	private static final long serialVersionUID = 1L;
	
	public  DataRequest() {
		super();
	}
	
	@Override
	public Hashtable<String, Object> getData() {
		// TODO Auto-generated method stub
		return this;
	}

}
