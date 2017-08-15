package speedDeleveryTime.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import speedDeleveryTime.interfaces.IEntity_View;
import speedDeleveryTime.utils.Constants;
import speedDeleveryTime.utils.ScrollPaneLine;

public class EntityManager_View extends JPanel implements IEntity_View {

	private static final long serialVersionUID = 1L;
	private final String name =  Constants.ENTITY_MANAGER_NAME;
	private Hashtable<String , JComponent>views = new Hashtable<>();

	public EntityManager_View() {

	}

	@Override
	public void updateView(Hashtable<String,Object> content) {

		synchronized (content) {
			
			int actionKey = ((int)content.get(Constants.ACTION_RESPONSE_KEY));
			switch (actionKey) {
			
			case Constants.NO_ACTION:

				return;
			case Constants.ACTION_RESPONSE_RECEIVE_NEW_ORDER:
				
				//TODO :  check if order list view is display.

				//IF displayed do the following code  
				if(content.get(Constants.DATA_COMMANDE_CONTENT) != null ){

					ScrollPaneLine line =  new ScrollPaneLine((String)content.get(Constants.DATA_COMMANDE_CONTENT), 10);
					this.add(line);
					this.invalidate();
					this.validate();
					this.repaint();
					
					
				}else{
					
					System.out.println("EntityManager_View.updateView :  no data to set");
					
				}
				//ELSE turn on the corresponding icon
				break;

			}
		}


	}

	@Override
	public void Display() { setVisible(true); }

	@Override
	public void hide() { setVisible(false); }

	@Override
	public void configure(Hashtable<String,Object> content) {

		if(content == null){// TODO : here must set the home view for manager
			this.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH- (MainScreen.getShared().get_floatLeftPanelWidth() + 20 ),
					MainScreen.getShared().get_floatLeftPanelHeight() ));
			
			//just for test notify new order not the home view for manager
			buildListOrderView();
			

		}

	}

	@Override
	public String getViewName() {
		return name;
	}

	@Override
	public Hashtable<String, JComponent> getContent() {
		synchronized (views) {

			return views;
		}

	}

	private void buildListOrderView(){

		GridLayout layout = new GridLayout(100,1);
		layout.setVgap(30);
		JScrollPane mainPanel = new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		mainPanel.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH-MainScreen.getShared().get_floatLeftPanelWidth(),
				Constants.SCREEN_HEIGHT));
		mainPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Speed Delivery Time"));
		mainPanel.setBackground(null);
		
		
		synchronized(views){

			this.views.put(Constants.MANAGER_COMPONENT_LIST_ORDER, mainPanel);	
		}

	}
	
	public JPanel getView(){ return this; }

}
