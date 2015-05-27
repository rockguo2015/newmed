package com.uniquesoft.gwt.client.common.widgets.baregwt.component.dialog;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * To show a view in a dialog, IManagableByDialog has to be inherited by the view's presenter;
 * like "presenter GWTGridPresenter implements IManagableByDialog{}" 
 *
 */
public interface IManagableByDialog{
	/**
	 * @param finished
	 * To get some service data asynchronously;
	 * wo can use it in the interaction in the presenter,for example:
	 * if we need to get data from the service:
	 * interaction{
			input call.performFinish(()=>void finished) : void{
				
				service.createEmployee(getView().employee,onSuccess[
						fire eventbus.EmployeeContentsChanged()
						finished.apply()
					]	
				)
			}
		}
		if there is no data to get:
	 * interaction{
			input call.performFinish(()=>void finished) : void{
				finished.apply()				
			}
		}
	 */
	void performFinish(final Procedure0 finished);
}
