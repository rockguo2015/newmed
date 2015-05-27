package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLGender;
import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.deliver.impl.DLInHospitalPatientImpl;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IHasSimplePy;
import edu.fudan.mylang.pf.IModelObject;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = DLInHospitalPatientImpl.class)
public interface DLInHospitalPatient extends IModelObject, IHasSimplePy {
  public abstract String getSid();
  
  public abstract DLInHospitalPatient setSid(final String sid);
  
  public abstract String getName();
  
  public abstract DLInHospitalPatient setName(final String name);
  
  public abstract Integer getAge();
  
  public abstract DLInHospitalPatient setAge(final Integer age);
  
  public abstract DLGender getGender();
  
  public abstract DLInHospitalPatient setGender(final DLGender gender);
  
  public abstract DLInHospitalLocation getLocation();
  
  public abstract DLInHospitalPatient setLocation(final DLInHospitalLocation location);
  
  public abstract String getBedNumber();
  
  public abstract DLInHospitalPatient setBedNumber(final String bedNumber);
  
  public abstract String getSimplePy();
  
  public abstract DLInHospitalPatient setSimplePy(final String simplePy);
  
  public abstract String getNameField();
  
  public abstract String getEntityName();
  
  public abstract void update(final Procedure1<? super DLInHospitalPatient> updater);
  
  public abstract DLInHospitalPatientProxy toProxy();
}
