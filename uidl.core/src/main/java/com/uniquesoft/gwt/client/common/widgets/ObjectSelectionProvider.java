package com.uniquesoft.gwt.client.common.widgets;

/**
 * interface for a Widget which can provide selection of object(s). examples of
 * ObjectSelectionTarget is a query-result view, an object detail view
 * 
 * @author ztiange
 * 
 * @param <T>
 */
public interface ObjectSelectionProvider<T> {

	/**
	 * Return the object list which is selected by the user
	 */
	Iterable<T> getSelectedObjects();
	
	void deselect();
	
	void select(T item);

	/**
	 * Register the behavior which should be executed after selection changed
	 * 
	 * @param listener the action that triggered by changing the selection
	 */
	void addSelectionChangedListener(SelectionChangedListener<T> listener);

	/**
	 * Implemented by the objects that need to set the behavior after 
	 * changed the selection 
	 *
	 * @param <T> the type of the value
	 */
	public interface SelectionChangedListener<T> {

		/**
		 * The behavior that triggered by changeing the selections
		 * 
		 * @param selections the object list that is selected by user
		 */
		void selectionChanged(Iterable<T> selections);

	}
}
