package edu.fudan.langlab.theme.blue.client.panel;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;

import edu.fudan.langlab.theme.blue.client.panel.resource.Images;

public class NavButton extends Composite  {
	private Image icon;
	private Image selectIcon;
	private Label label;
	HorizontalLayoutContainer h;
	
	public NavButton(String text){
		this(text,false);
	}
	
	public void addClickHandler(ClickHandler handler){
		label.addClickHandler(handler);
	}
	
	public NavButton(String text,boolean select){
		h=new HorizontalLayoutContainer();
		h.setHeight(30);
		
		selectIcon=new Image(Images.INSTANCE.nav_select());
		label=new Label(text);
		
		if(select){
			icon=new Image(Images.INSTANCE.nav_bts());
			label.getElement().setAttribute("style", "color:#0e419c");
			h.getElement().setAttribute("style", "cursor: pointer;border-bottom:1px solid #d7d7d7;background:#fff");
		}
		else{
			icon=new Image(Images.INSTANCE.nav_bt());
			label.getElement().setAttribute("style", "color:#626665");
			h.getElement().setAttribute("style", "cursor: pointer;border-bottom:1px solid #d7d7d7;background:#dbf3fe");
		}
		
		h.add(icon,new HorizontalLayoutData(-1,1,new Margins(8,10,5,50)));
		h.add(label,new HorizontalLayoutData(-1,1,new Margins(5,10,5,0)));
		
		if(select)
			h.add(selectIcon,new HorizontalLayoutData(-1,1,new Margins(8,0,5,10)));
		super.initWidget(h);
	}
	
	public void isSelected(boolean select){
		if(select){
			h.remove(icon);
			h.remove(label);
			icon=new Image(Images.INSTANCE.nav_bts());
			label.getElement().setAttribute("style", "color:#0e419c");
			h.add(icon,new HorizontalLayoutData(-1,1,new Margins(8,10,5,50)));
			h.add(label,new HorizontalLayoutData(-1,1,new Margins(5,10,5,0)));
			h.add(selectIcon,new HorizontalLayoutData(-1,1,new Margins(8,0,5,10)));
			h.getElement().setAttribute("style", "cursor: pointer;border-bottom:1px solid #d7d7d7;background:#fff");
		}else{
			h.remove(selectIcon);
			label.getElement().setAttribute("style", "color:#626665");
			h.getElement().setAttribute("style", "cursor: pointer;border-bottom:1px solid #d7d7d7;background:#dbf3fe");
		}
	}
}
