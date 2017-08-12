package speedDeleveryTime.interfaces;

import java.util.Hashtable;

import javax.swing.JComponent;
import javax.swing.JPanel;

public interface IEntity_View {

	public void updateView(Hashtable<String,Object> content);
	public void Display();
	public void hide();
	public void configure(Hashtable<String,Object> content);
	public String getViewName();
	public Hashtable<String, JComponent> getContent();
	public  JPanel getView();
	

}
