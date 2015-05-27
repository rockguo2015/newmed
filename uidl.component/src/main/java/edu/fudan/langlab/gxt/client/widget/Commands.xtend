package edu.fudan.langlab.gxt.client.widget

import edu.fudan.langlab.security.client.Securities
import com.google.inject.Inject
import com.uniquesoft.gwt.client.common.async.IInitializerSupport
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction
import com.uniquesoft.gwt.shared.GWTEntity
import com.uniquesoft.gwt.client.common.action.ActionContext
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand
import edu.fudan.langlab.gxt.client.action.SingleObjectActions
import edu.fudan.langlab.gxt.client.action.MultiObjectActions
import com.sencha.gxt.widget.core.client.button.TextButton
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand
import com.uniquesoft.gwt.client.common.command.BaseContextAwareMultiObjectCommand
import com.uniquesoft.gwt.shared.IGWTEntity
import edu.fudan.langlab.gxt.client.action.ButtonRequester

class Commands implements IInitializerSupport{
	@Inject Securities securities 
	override initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null)
	}
	
	def <T> void asButton(IWidgetFactory widgets,BaseSimpleCommand command, (TextButton)=>void acceptor){
		securities.check(command.requireCheck,command.actionId)[
			val button = widgets.TextButton(command.title)[
				command.execute
			]
			acceptor.apply(button)
		]
	}
	def <T> void asButton(BaseContextAwareSingleObjectCommand<T> contextAwareAction, (TextButton)=>void acceptor){
		securities.check(contextAwareAction.requireCheck,contextAwareAction.actionId)[
			val button = SingleObjectActions::onSingleObjectAction(contextAwareAction.context)[
				onExecute[T value|
					contextAwareAction.execute(value)
				]
				onCheckEnable[
					contextAwareAction.checkEnable(contextAwareAction.context.selectedObjects.head)
				]
			].asButtonRequester(contextAwareAction.getTitle())
			acceptor.apply(button)
		]
	}

	def <T extends IGWTEntity> void asButton(ActionContext<T> actionContext,BaseContextAwareSingleObjectCommand<T> contextAwareAction, (TextButton)=>void acceptor){
			contextAwareAction.context = actionContext
			asButton(contextAwareAction)[TextButton btn|
				acceptor.apply(btn)
			]
	}

	def <T> void asButton(()=>T valueProvider,BaseContextAwareSingleObjectCommand<T> contextAwareAction, (TextButton)=>void acceptor){
		securities.check(contextAwareAction.requireCheck,contextAwareAction.actionId)[
			contextAwareAction.valueProvider = valueProvider
			val req = new ButtonRequester(contextAwareAction.getTitle())=>[
				it.requestHandler=[|
					contextAwareAction.execute(valueProvider.apply)
				]
			]
			acceptor.apply(req.asWidget)
		]
	}

	def <T> void asButton(ActionContext<T> actionContext,BaseContextAwareSingleObjectCommand<T> contextAwareAction,String name, (TextButton)=>void acceptor){
		securities.check(contextAwareAction.requireCheck,contextAwareAction.actionId)[
			contextAwareAction.context = actionContext
			val button = SingleObjectActions::onSingleObjectAction(contextAwareAction.context)[
				onExecute[T value|
					contextAwareAction.execute(value)
				]
			].asButtonRequester(name)
			acceptor.apply(button)
		]
	}
	def <T> void asButton(ActionContext<T> actionContext,BaseContextAwareMultiObjectCommand<T> contextAwareAction,(TextButton)=>void acceptor){
		securities.check(contextAwareAction.actionId)[
			contextAwareAction.context = actionContext
			val button = MultiObjectActions::onMultiObjectAction(contextAwareAction.context)[
				onExecute[Iterable<T> value|
					contextAwareAction.execute(value)
				]
				
				onCheckEnable[
					contextAwareAction.checkEnable(contextAwareAction.context.selectedObjects as Iterable<T>)
				]
				
			].asButtonRequester(contextAwareAction.getTitle())
			acceptor.apply(button)
		]
	}
}