/*
 * Copyright 2006 Centenum Software Solutions, Inc. All rights reserved.
 * CENTENUM PROPRIETARY/CONFIDENTIAL. 
 */
package edu.fudan.mylang.pf;

import java.io.Serializable;
import java.util.Date;

import edu.fudan.mylang.pf.event.EntityEventsManager;
import edu.fudan.mylang.pf.event.IEntityEventsManager;

/**
 * base interface for all model class
 * 
 * @author zhang tiange
 * 
 */
public interface IModelObject extends Serializable{

	/**
	 * get object id
	 * 
	 * @return the object id
	 */
	Long getId();

	/**
	 * set object id
	 * 
	 * @param id
	 *            the object id
	 */
	void setId(Long id);

	void preinitialize();
	
	/**
	 * get last modified date
	 * 
	 * @return last modified date
	 */
	Date getModifiedDate();

	/**
	 * set last modified date
	 * 
	 * @param modifiedDate
	 *            last modified date.
	 */
	void setModifiedDate(Date modifiedDate);

	/**
	 * get last modifier
	 * 
	 * @return last modifier
	 */
	String getModifier();

	/**
	 * set last modifier
	 * 
	 * @param modifier
	 *            last modifier.
	 */
	void setModifier(String modifier);

	
	Date getCreateDate();
	void setCreateDate(Date date);
	
	
	String getCreator();
	void setCreator(String creator);
	
	Long getVersion();
	
	void setVersion(Long version);
	/**
	 * get the acitve state
	 * 
	 * @return
	 */
	Boolean isActive();

	/**
	 * set the acitve state
	 * 
	 * @param isActive
	 *            the acitve state
	 */
	void setIsActive(Boolean isActive);

	/**
	 * add a model change listener
	 * 
	 * @param listener
	 *            a listener
	 */
	void addModelChangeListener(IModelChangeListener listener);

	/**
	 * get the description of this model object
	 * 
	 * @return the description of this model object
	 */
	String getObjectDescription();
	
	Object toProxy();
	
	void delete();
	
	void checkValid();
	
}
