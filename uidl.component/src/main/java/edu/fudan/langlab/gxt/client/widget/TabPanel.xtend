package edu.fudan.langlab.gxt.client.widget

import com.uniquesoft.gwt.shared.IGWTEntity
import com.uniquesoft.gwt.client.common.action.ActionContext
import com.uniquesoft.gwt.shared.command.IContextConsumer
import com.uniquesoft.gwt.client.common.Presenter

class TabPanel extends com.sencha.gxt.widget.core.client.TabPanel {
	Commands commands;
	IWidgetFactory widgets;
	
	new(Commands commands, IWidgetFactory widgets) {
		super();
		this.widgets = widgets;
		this.commands = commands;
	}
	
//	def <T extends IGWTEntity> add(ActionContext<T> context, IContextConsumer<T> contextConsumer, String title){
//		contextConsumer.setContext(context)
//		add((contextConsumer as Presenter).getView().asWidget,title)
//	}
	
	def <T extends IGWTEntity> ContentPanel add(ActionContext<T> context, IContextConsumer<T> contextConsumer, String title){
		val contentPanel = new ContentPanel(commands,widgets)=>[
			contextConsumer.setContext(context)
			widget = (contextConsumer as Presenter).getView().asWidget
		]
		add(contentPanel,title)
		contentPanel
		
	}
}