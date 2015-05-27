package com.uniquesoft.gwt.client.common;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;

/**
 * Implemented by objects that have the ability to display through the {@link Viewer} 
 */
public interface Presenter<V extends Viewer> {
	

	/**
	 * the view that specify the UI interface of this presenter
	 * @return
	 */
	public V getView();
	
	/**
	 * activate the view the appropriate location, execute the post action
	 * after the other actions.
	 * 
	 * @param postAction action shall be done after the initialization
	 */
	public void activate(IPostInitializeAction postAction);
	
	/**
	 * remove the view from the location
	 */
	public void deactivate();
	
	public boolean getIsActivated();	
	
	public Procedure0 getRPCFailureHandler();

}
