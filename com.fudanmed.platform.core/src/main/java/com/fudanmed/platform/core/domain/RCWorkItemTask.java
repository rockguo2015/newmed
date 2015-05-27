package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCWorkItemPicture;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import com.fudanmed.platform.core.domain.impl.RCWorkItemTaskImpl;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCRCProductStorageContainer;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import edu.fudan.langlab.domain.document.IDocument;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.INamedModelObject;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = RCWorkItemTaskImpl.class)
public interface RCWorkItemTask extends RCRCProductStorageContainer, INamedModelObject, IDocumentContainer {
  public abstract RCGroupTask getGroupTask();
  
  public abstract RCWorkItemTask setGroupTask(final RCGroupTask groupTask);
  
  public abstract String getSid();
  
  public abstract RCWorkItemTask setSid(final String sid);
  
  public abstract Date getDate();
  
  public abstract RCWorkItemTask setDate(final Date date);
  
  public abstract Date getTime();
  
  public abstract RCWorkItemTask setTime(final Date time);
  
  public abstract Date getFinishDate();
  
  public abstract RCWorkItemTask setFinishDate(final Date finishDate);
  
  public abstract Date getFinishTime();
  
  public abstract RCWorkItemTask setFinishTime(final Date finishTime);
  
  public abstract Collection<RCEmployee> getWorkers();
  
  public abstract RCWorkItemTask addtoWorkers(final RCEmployee rCEmployee);
  
  public abstract RCWorkItemTask setWorkers(final Iterable<RCEmployee> workers);
  
  public abstract RCWorkItemTask removeFromWorkers(final RCEmployee rCEmployee);
  
  public abstract RCWorkItemTask removeAllWorkers();
  
  public abstract String getComment();
  
  public abstract RCWorkItemTask setComment(final String comment);
  
  public abstract RCEmployee getOperator();
  
  public abstract RCWorkItemTask setOperator(final RCEmployee operator);
  
  public abstract RCFaultType getFaultType();
  
  public abstract RCWorkItemTask setFaultType(final RCFaultType faultType);
  
  public abstract String getFaultDescription();
  
  public abstract RCWorkItemTask setFaultDescription(final String faultDescription);
  
  public abstract Collection<RCWorkItemPicture> getDocuments();
  
  public abstract RCWorkItemPicture createAndAddtoDocuments();
  
  public abstract RCWorkItemTask removeFromDocuments(final RCWorkItemPicture rCWorkItemPicture);
  
  public abstract RCWorkItemTask removeAllDocuments();
  
  public abstract IDocument createDocument(final Procedure1<? super IDocument> init);
  
  public abstract void removeDocument(final IDocument document);
  
  public abstract String getMonth();
  
  public abstract RCWorkItemTask setMonth(final String month);
  
  public abstract String getEntityName();
  
  public abstract Collection<RCEmployee> getTaskOwners();
  
  public abstract String getDescription();
  
  public abstract Boolean isEnd();
  
  public abstract Collection<RCWorkItemStockRecord> getOutStoreRecord();
  
  public abstract Collection<RCWorkItemStorage> getStorage();
  
  public abstract Collection<RCProductStorage> getAllProductStorage(final RCProductSpecification productSpec);
  
  public abstract Double getAmount();
  
  public abstract RCProductStorage getOrCreateProductStorage(final RCProductEntry productEntry);
  
  public abstract void updateDerived();
  
  public abstract RCWorkItemTaskStatus getStatus();
  
  public abstract void start();
  
  public abstract void followup();
  
  public abstract void pend();
  
  public abstract void misDispatching();
  
  public abstract void outsource();
  
  public abstract void cancel();
  
  public abstract void cancelPend();
  
  public abstract void finishOutsource();
  
  public abstract void finish();
  
  public abstract Boolean isProcessing();
  
  public abstract Boolean isFollowuping();
  
  public abstract Boolean isPending();
  
  public abstract Boolean isOutsourcing();
  
  public abstract Boolean isMisDispatching();
  
  public abstract Boolean isPendFinish();
  
  public abstract Boolean isOutsourceFinish();
  
  public abstract Boolean isFinished();
  
  public abstract Boolean isCanceled();
  
  public abstract RCWorkItemTaskProxy toProxy();
}
