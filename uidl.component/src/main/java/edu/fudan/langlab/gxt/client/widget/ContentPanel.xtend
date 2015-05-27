package edu.fudan.langlab.gxt.client.widget

import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand
import com.uniquesoft.gwt.client.common.action.ActionContext
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand
import com.uniquesoft.gwt.client.common.command.BaseContextAwareMultiObjectCommand

class ContentPanel extends com.sencha.gxt.widget.core.client.ContentPanel {
	Commands commands;
	IWidgetFactory widgets;
	
	new(Commands commands, IWidgetFactory widgets) {
		super();
		this.widgets = widgets;
		this.commands = commands;
	}

	def void addCommand(ActionContext ac, BaseContextAwareSingleObjectCommand command) {
		commands.asButton(ac,command)[
			addButton(it)
		]
	}
	def void addCommand(ActionContext ac, BaseContextAwareSingleObjectCommand command, String title) {
		commands.asButton(ac,command,title)[
			addButton(it)
		]
	}
	
	def <T> void addCommand(()=>T valueProvider, BaseContextAwareSingleObjectCommand<T> command){
		commands.<T>asButton(valueProvider,command)[
			addButton(it)
		]
	}
	def <T> void addCommand( BaseContextAwareSingleObjectCommand<T> command){
		commands.<T>asButton(command)[
			addButton(it)
		]
	}

	def void addCommand(ActionContext ac, BaseContextAwareMultiObjectCommand command) {
		commands.asButton(ac,command)[
			addButton(it)
		]
	}	
	
	
	def void addSimpleCommand(BaseSimpleCommand command) {
		commands.asButton(widgets,command)[
			addButton(it)
		]
	}	
}