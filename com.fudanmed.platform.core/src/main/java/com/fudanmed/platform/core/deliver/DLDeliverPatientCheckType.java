package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckTypeImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IHasSimplePy;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = DLDeliverPatientCheckTypeImpl.class)
public interface DLDeliverPatientCheckType extends IModelObject, IHasSimplePy {
  public abstract DLDeliverPatientCheckCategory getCategory();
  
  public abstract DLDeliverPatientCheckType setCategory(final DLDeliverPatientCheckCategory category);
  
  public abstract String getCode();
  
  public abstract DLDeliverPatientCheckType setCode(final String code);
  
  public abstract String getName();
  
  public abstract DLDeliverPatientCheckType setName(final String name);
  
  public abstract Integer getPerformence();
  
  public abstract DLDeliverPatientCheckType setPerformence(final Integer performence);
  
  public abstract Integer getTimeLimitation();
  
  public abstract DLDeliverPatientCheckType setTimeLimitation(final Integer timeLimitation);
  
  public abstract Collection<DLCheckOrganization> getCheckOrganization();
  
  public abstract DLDeliverPatientCheckType addtoCheckOrganization(final DLCheckOrganization dLCheckOrganization);
  
  public abstract DLDeliverPatientCheckType setCheckOrganization(final Iterable<DLCheckOrganization> checkOrganization);
  
  public abstract DLDeliverPatientCheckType removeFromCheckOrganization(final DLCheckOrganization dLCheckOrganization);
  
  public abstract DLDeliverPatientCheckType removeAllCheckOrganization();
  
  public abstract String getComment();
  
  public abstract DLDeliverPatientCheckType setComment(final String comment);
  
  public abstract void update(final Procedure1<? super DLDeliverPatientCheckType> updater);
  
  public abstract String getEntityName();
  
  public abstract String getSimplePy();
  
  public abstract DLDeliverPatientCheckType setSimplePy(final String simplePy);
  
  public abstract String getNameField();
  
  public abstract DLDeliverPatientCheckTypeProxy toProxy();
}
