package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.impl.RCWorkItemPictureImpl;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemPictureProxy;
import edu.fudan.langlab.domain.document.DocumentStorage;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCWorkItemPictureImpl.class)
public interface RCWorkItemPicture extends DocumentStorage {
  public abstract RCWorkItemTask getWorkitemTask();
  
  public abstract RCWorkItemPicture setWorkitemTask(final RCWorkItemTask workitemTask);
  
  public abstract IDocumentContainer getContainer();
  
  public abstract RCWorkItemPictureProxy toProxy();
}
