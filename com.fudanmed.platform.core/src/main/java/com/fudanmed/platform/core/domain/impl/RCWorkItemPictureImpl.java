package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCWorkItemPicture;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.impl.RCWorkItemTaskImpl;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemPictureProxy;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.langlab.domain.document.impl.DocumentStorageImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("RCWORKITEMPICTURE_TYPE")
public class RCWorkItemPictureImpl extends DocumentStorageImpl implements RCWorkItemPicture {
  public RCWorkItemPictureImpl() {
    super();
  }
  
  public RCWorkItemPictureImpl(final RCWorkItemTask workitemTask) {
    super();
    this.workitemTask = workitemTask;
  }
  
  @JoinColumn(name = "workitemTask_id")
  @ManyToOne(targetEntity = RCWorkItemTaskImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWorkItemTask workitemTask;
  
  public RCWorkItemTask getWorkitemTask() {
    return this.workitemTask;
  }
  
  public RCWorkItemPicture setWorkitemTask(final RCWorkItemTask workitemTask) {
    this.workitemTask = workitemTask;
    return this;			
    
  }
  
  public IDocumentContainer getContainer() {
    return this.workitemTask;
  }
  
  public static RCWorkItemPicture create(final RCWorkItemTask workitemTask, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCWorkItemPicture rCWorkItemPicture = new com.fudanmed.platform.core.domain.impl.RCWorkItemPictureImpl(
    	workitemTask
    );
    objectFactory.create(rCWorkItemPicture);
    return rCWorkItemPicture;			
    
  }
  
  public RCWorkItemPictureProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCWorkItemPictureProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCWorkItemPictureProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
