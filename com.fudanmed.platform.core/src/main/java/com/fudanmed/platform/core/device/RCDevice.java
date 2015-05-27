package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCAcquireType;
import com.fudanmed.platform.core.device.RCDeviceFile;
import com.fudanmed.platform.core.device.RCDeviceIndicator;
import com.fudanmed.platform.core.device.RCDevicePicture;
import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceUsageType;
import com.fudanmed.platform.core.device.impl.RCDeviceImpl;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = RCDeviceImpl.class)
public interface RCDevice extends IModelObject, INamedModelObject {
  public abstract String getSid();
  
  public abstract RCDevice setSid(final String sid);
  
  public abstract String getName();
  
  public abstract RCDevice setName(final String name);
  
  public abstract String getSpecification();
  
  public abstract RCDevice setSpecification(final String specification);
  
  public abstract RCOnsitePosition getLocation();
  
  public abstract RCDevice setLocation(final RCOnsitePosition location);
  
  public abstract String getLocationName();
  
  public abstract RCDevice setLocationName(final String locationName);
  
  public abstract String getServiceLocationName();
  
  public abstract RCDevice setServiceLocationName(final String serviceLocationName);
  
  public abstract RCSupplier getProductor();
  
  public abstract RCDevice setProductor(final RCSupplier productor);
  
  public abstract RCSupplier getSupplier();
  
  public abstract RCDevice setSupplier(final RCSupplier supplier);
  
  public abstract RCDeviceType getDeviceType();
  
  public abstract RCDevice setDeviceType(final RCDeviceType deviceType);
  
  public abstract RCDeviceIndicator getDeviceIndicator();
  
  public abstract RCDevice setDeviceIndicator(final RCDeviceIndicator deviceIndicator);
  
  public abstract RCAcquireType getAcquireType();
  
  public abstract RCDevice setAcquireType(final RCAcquireType acquireType);
  
  public abstract RCDeviceUsageType getUsageType();
  
  public abstract RCDevice setUsageType(final RCDeviceUsageType usageType);
  
  public abstract Date getOutStockTime();
  
  public abstract RCDevice setOutStockTime(final Date outStockTime);
  
  public abstract Date getBuyTime();
  
  public abstract RCDevice setBuyTime(final Date buyTime);
  
  public abstract String getComment();
  
  public abstract RCDevice setComment(final String comment);
  
  public abstract Double getBuyPrice();
  
  public abstract RCDevice setBuyPrice(final Double buyPrice);
  
  public abstract Double getNetPrice();
  
  public abstract RCDevice setNetPrice(final Double netPrice);
  
  public abstract RCEmployee getOwner();
  
  public abstract RCDevice setOwner(final RCEmployee owner);
  
  public abstract Integer getDepreciationYears();
  
  public abstract RCDevice setDepreciationYears(final Integer depreciationYears);
  
  public abstract Double getNetLeaveRate();
  
  public abstract RCDevice setNetLeaveRate(final Double netLeaveRate);
  
  public abstract RCEmployee getOperator();
  
  public abstract RCDevice setOperator(final RCEmployee operator);
  
  public abstract RCOrganization getOwnerDepartment();
  
  public abstract RCDevice setOwnerDepartment(final RCOrganization ownerDepartment);
  
  public abstract String getOwnerDepartmentName();
  
  public abstract RCDevice setOwnerDepartmentName(final String ownerDepartmentName);
  
  public abstract String getEntityName();
  
  public abstract RCExtensiableEntity getExtension();
  
  public abstract RCDevice setExtension(final RCExtensiableEntity extension);
  
  public abstract Collection<RCDeviceFile> getFiles();
  
  public abstract RCDeviceFile createAndAddtoFiles();
  
  public abstract RCDevice removeFromFiles(final RCDeviceFile rCDeviceFile);
  
  public abstract RCDevice removeAllFiles();
  
  public abstract Collection<RCDevicePicture> getPictures();
  
  public abstract RCDevicePicture createAndAddtoPictures();
  
  public abstract RCDevice removeFromPictures(final RCDevicePicture rCDevicePicture);
  
  public abstract RCDevice removeAllPictures();
  
  public abstract RCDeviceFile createFile(final Procedure1<? super RCDeviceFile> init);
  
  public abstract void removeFile(final RCDeviceFile document);
  
  public abstract RCDevicePicture createPicture(final Procedure1<? super RCDevicePicture> init);
  
  public abstract void removePicture(final RCDevicePicture picture);
  
  public abstract void checkValid();
  
  public abstract RCDeviceProxy toProxy();
}
