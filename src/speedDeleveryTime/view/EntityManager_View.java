package speedDeleveryTime.view;

import java.util.Hashtable;

import javax.swing.JComponent;
import javax.swing.JPanel;

import speedDeleveryTime.interfaces.IEntity_View;
import speedDeleveryTime.utils.Constants;

public class EntityManager_View extends JPanel implements IEntity_View {

	private static final long serialVersionUID = 1L;
	private final String name =  Constants.ENTITY_MANAGER_NAME;
	private Hashtable<String , JComponent>content = new Hashtable<>();  

	public EntityManager_View() {
		
		
	}

	@Override
	public void updateView(Hashtable<String,Object> content) {
		
	}

	@Override
	public void Display() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void configure(Hashtable<String,Object> content) {

		
	}

	@Override
	public String getViewName() {
		return name;
	}

	@Override
	public Hashtable<String, JComponent> getContent() {
		return content;
	}
	
	

}
