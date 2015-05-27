package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDeviceTypeCategory;
import com.fudanmed.platform.core.device.RCDeviceTypeFile;
import com.fudanmed.platform.core.device.RCDeviceTypePicture;
import com.fudanmed.platform.core.device.impl.RCDeviceTypeImpl;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntityType;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = RCDeviceTypeImpl.class)
public interface RCDeviceType extends IModelObject, INamedModelObject {
  public abstract RCDeviceTypeCategory getCategory();
  
  public abstract RCDeviceType setCategory(final RCDeviceTypeCategory category);
  
  public abstract String getCode();
  
  public abstract RCDeviceType setCode(final String code);
  
  public abstract String getName();
  
  public abstract RCDeviceType setName(final String name);
  
  public abstract Integer getDepreciationYears();
  
  public abstract RCDeviceType setDepreciationYears(final Integer depreciationYears);
  
  public abstract String getPath();
  
  public abstract RCDeviceType setPath(final String path);
  
  public abstract RCExtensiableEntityType getExtensiableType();
  
  public abstract RCDeviceType setExtensiableType(final RCExtensiableEntityType extensiableType);
  
  public abstract RCExtensiableEntity getDefaultValue();
  
  public abstract RCDeviceType setDefaultValue(final RCExtensiableEntity defaultValue);
  
  public abstract Collection<RCProductSpecification> getPartTypes();
  
  public abstract RCDeviceType addtoPartTypes(final RCProductSpecification rCProductSpecification);
  
  public abstract RCDeviceType setPartTypes(final Iterable<RCProductSpecification> partTypes);
  
  public abstract RCDeviceType removeFromPartTypes(final RCProductSpecification rCProductSpecification);
  
  public abstract RCDeviceType removeAllPartTypes();
  
  public abstract String getEntityName();
  
  public abstract Collection<RCDeviceTypeFile> getFiles();
  
  public abstract RCDeviceTypeFile createAndAddtoFiles();
  
  public abstract RCDeviceType removeFromFiles(final RCDeviceTypeFile rCDeviceTypeFile);
  
  public abstract RCDeviceType removeAllFiles();
  
  public abstract Collection<RCDeviceTypePicture> getPictures();
  
  public abstract RCDeviceTypePicture createAndAddtoPictures();
  
  public abstract RCDeviceType removeFromPictures(final RCDeviceTypePicture rCDeviceTypePicture);
  
  public abstract RCDeviceType removeAllPictures();
  
  public abstract RCDeviceTypeFile createFile(final Procedure1<? super RCDeviceTypeFile> init);
  
  public abstract void removeFile(final RCDeviceTypeFile document);
  
  public abstract RCDeviceTypePicture createPicture(final Procedure1<? super RCDeviceTypePicture> init);
  
  public abstract void removePicture(final RCDeviceTypePicture picture);
  
  public abstract RCDeviceTypeProxy toProxy();
}
