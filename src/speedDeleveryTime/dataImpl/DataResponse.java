package speedDeleveryTime.dataImpl;

import java.util.Hashtable;
import speedDeleveryTime.interfaces.IData;

public class DataResponse extends Hashtable<String, Object> implements IData{

	private static final long serialVersionUID = 1L;

	public  DataResponse() {
		super();
	}

	@Override
	public Hashtable<String, Object> getData() {
		return this;
	}

}
