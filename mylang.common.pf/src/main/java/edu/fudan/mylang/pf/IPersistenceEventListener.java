/*
 * Copyright 2006 Centenum Software Solutions, Inc. All rights reserved.
 * CENTENUM PROPRIETARY/CONFIDENTIAL. 
 */
package edu.fudan.mylang.pf;

/**
 * persistence listener interface which can listen to presisten related events
 * such as Object Save/ Object Delete.
 * 
 * @author zhang tiange
 * 
 */
public interface IPersistenceEventListener {
	/**
	 * befor an object is saved to database
	 * 
	 * @param object
	 *            the object
	 * @param of
	 *            Object Factory used for persistence
	 */
	void beforeObjectSaved(IModelObject object, IObjectFactory of);

	/**
	 * after an object is saved to database
	 * 
	 * @param object
	 *            the object
	 * @param of
	 *            Object Factory used for persistence
	 */
	void afterObjectSaved(IModelObject object, IObjectFactory of);

	/**
	 * before an object is to be deleted from database
	 * 
	 * @param object
	 *            the object
	 * @param of
	 *            Object Factory used for persistence
	 */
	void beforeObjectDeleted(IModelObject object, IObjectFactory of);
}
