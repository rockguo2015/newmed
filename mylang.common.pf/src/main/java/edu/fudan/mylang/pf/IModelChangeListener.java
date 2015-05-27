/*
 * Copyright 2006 Centenum Software Solutions, Inc. All rights reserved.
 * CENTENUM PROPRIETARY/CONFIDENTIAL. 
 */
package edu.fudan.mylang.pf;

/**
 * Model change listener, fire the model change events
 * 
 * @author zhang tiange
 * 
 */
public interface IModelChangeListener {

	/**
	 * fire the property changed event
	 * 
	 * @param propertyName
	 *            property name
	 */
	void PropertyChanged(String propertyName);

	/**
	 * fire the object attached event.
	 * 
	 * @param propertyName
	 *            property name
	 * @param attachedObject
	 *            object that attached
	 */
	void ObjectAttached(String propertyName, Object attachedObject);

	/**
	 * fire the object detached event.
	 * 
	 * @param propertyName
	 *            property name
	 * @param attachedObject
	 *            object that detached
	 */
	void ObjectDetached(String propertyName, Object detachedObject);

	/**
	 * fire the object added event.
	 * 
	 * @param propertyName
	 *            property name
	 * @param attachedObject
	 *            object that hold the added object
	 */
	void ObjectAdded(String propertyName, Object addedObject);

	/**
	 * fire the object removed event.
	 * 
	 * @param propertyName
	 *            property name
	 * @param attachedObject
	 *            object that hold the added object
	 */
	void ObjectRemoved(String propertyName, Object removedObject);

}
