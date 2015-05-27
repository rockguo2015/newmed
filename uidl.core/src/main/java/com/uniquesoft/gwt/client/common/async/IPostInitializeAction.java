package com.uniquesoft.gwt.client.common.async;

/**
 * It is used as a callback, when all the data has got ready, it will
 * call the initializeFinished() method to declare that all the initialize
 * work has been finished.
 *
 */
public interface IPostInitializeAction {
	
	public static IPostInitializeAction Null = new IPostInitializeAction(){

		@Override
		public void initializeFinished(Void v) {
			// TODO Auto-generated method stub
			
		}
		
	};
	/**
	 * To some work after all the asynchronous work has finished  
	 * @param v
	 */
	void initializeFinished(Void v);
	
}
