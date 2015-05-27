package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.RCAcquireType;
import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceFile;
import com.fudanmed.platform.core.device.RCDeviceIndicator;
import com.fudanmed.platform.core.device.RCDevicePicture;
import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceUsageType;
import com.fudanmed.platform.core.device.impl.RCAcquireTypeImpl;
import com.fudanmed.platform.core.device.impl.RCDeviceFileImpl;
import com.fudanmed.platform.core.device.impl.RCDeviceIndicatorImpl;
import com.fudanmed.platform.core.device.impl.RCDevicePictureImpl;
import com.fudanmed.platform.core.device.impl.RCDeviceTypeImpl;
import com.fudanmed.platform.core.device.impl.RCDeviceUsageTypeImpl;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.domain.impl.RCOnsitePositionImpl;
import com.fudanmed.platform.core.domain.impl.RCOrganizationImpl;
import com.fudanmed.platform.core.domain.impl.RCSupplierImpl;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.impl.RCExtensiableEntityImpl;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCDEVICE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcdevice")
public class RCDeviceImpl extends BaseModelObject implements RCDevice {
  public RCDeviceImpl() {
    super();
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCDevice setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCDevice setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private String specification;
  
  public String getSpecification() {
    return this.specification;
  }
  
  public RCDevice setSpecification(final String specification) {
    this.specification = specification;
    return this;			
    
  }
  
  @JoinColumn(name = "location_id")
  @ManyToOne(targetEntity = RCOnsitePositionImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOnsitePosition location;
  
  public RCOnsitePosition getLocation() {
    return this.location;
  }
  
  public RCDevice setLocation(final RCOnsitePosition location) {
    this.location = location;
    return this;			
    
  }
  
  private String locationName;
  
  public String getLocationName() {
    return this.locationName;
  }
  
  public RCDevice setLocationName(final String locationName) {
    this.locationName = locationName;
    return this;			
    
  }
  
  private String serviceLocationName;
  
  public String getServiceLocationName() {
    return this.serviceLocationName;
  }
  
  public RCDevice setServiceLocationName(final String serviceLocationName) {
    this.serviceLocationName = serviceLocationName;
    return this;			
    
  }
  
  @JoinColumn(name = "productor_id")
  @ManyToOne(targetEntity = RCSupplierImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCSupplier productor;
  
  public RCSupplier getProductor() {
    return this.productor;
  }
  
  public RCDevice setProductor(final RCSupplier productor) {
    this.productor = productor;
    return this;			
    
  }
  
  @JoinColumn(name = "supplier_id")
  @ManyToOne(targetEntity = RCSupplierImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCSupplier supplier;
  
  public RCSupplier getSupplier() {
    return this.supplier;
  }
  
  public RCDevice setSupplier(final RCSupplier supplier) {
    this.supplier = supplier;
    return this;			
    
  }
  
  @JoinColumn(name = "deviceType_id")
  @ManyToOne(targetEntity = RCDeviceTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCDeviceType deviceType;
  
  public RCDeviceType getDeviceType() {
    return this.deviceType;
  }
  
  public RCDevice setDeviceType(final RCDeviceType deviceType) {
    this.deviceType = deviceType;
    return this;			
    
  }
  
  @JoinColumn(name = "deviceIndicator_id")
  @ManyToOne(targetEntity = RCDeviceIndicatorImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCDeviceIndicator deviceIndicator;
  
  public RCDeviceIndicator getDeviceIndicator() {
    return this.deviceIndicator;
  }
  
  public RCDevice setDeviceIndicator(final RCDeviceIndicator deviceIndicator) {
    this.deviceIndicator = deviceIndicator;
    return this;			
    
  }
  
  @JoinColumn(name = "acquireType_id")
  @ManyToOne(targetEntity = RCAcquireTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCAcquireType acquireType;
  
  public RCAcquireType getAcquireType() {
    return this.acquireType;
  }
  
  public RCDevice setAcquireType(final RCAcquireType acquireType) {
    this.acquireType = acquireType;
    return this;			
    
  }
  
  @JoinColumn(name = "usageType_id")
  @ManyToOne(targetEntity = RCDeviceUsageTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCDeviceUsageType usageType;
  
  public RCDeviceUsageType getUsageType() {
    return this.usageType;
  }
  
  public RCDevice setUsageType(final RCDeviceUsageType usageType) {
    this.usageType = usageType;
    return this;			
    
  }
  
  private Date outStockTime;
  
  public Date getOutStockTime() {
    return this.outStockTime;
  }
  
  public RCDevice setOutStockTime(final Date outStockTime) {
    this.outStockTime = outStockTime;
    return this;			
    
  }
  
  private Date buyTime;
  
  public Date getBuyTime() {
    return this.buyTime;
  }
  
  public RCDevice setBuyTime(final Date buyTime) {
    this.buyTime = buyTime;
    return this;			
    
  }
  
  @Column(length = 1024)
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCDevice setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  private Double buyPrice;
  
  public Double getBuyPrice() {
    return this.buyPrice;
  }
  
  public RCDevice setBuyPrice(final Double buyPrice) {
    this.buyPrice = buyPrice;
    return this;			
    
  }
  
  private Double netPrice;
  
  public Double getNetPrice() {
    return this.netPrice;
  }
  
  public RCDevice setNetPrice(final Double netPrice) {
    this.netPrice = netPrice;
    return this;			
    
  }
  
  @JoinColumn(name = "owner_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee owner;
  
  public RCEmployee getOwner() {
    return this.owner;
  }
  
  public RCDevice setOwner(final RCEmployee owner) {
    this.owner = owner;
    return this;			
    
  }
  
  private Integer depreciationYears;
  
  public Integer getDepreciationYears() {
    return this.depreciationYears;
  }
  
  public RCDevice setDepreciationYears(final Integer depreciationYears) {
    this.depreciationYears = depreciationYears;
    return this;			
    
  }
  
  private Double netLeaveRate;
  
  public Double getNetLeaveRate() {
    return this.netLeaveRate;
  }
  
  public RCDevice setNetLeaveRate(final Double netLeaveRate) {
    this.netLeaveRate = netLeaveRate;
    return this;			
    
  }
  
  @JoinColumn(name = "operator_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee operator;
  
  public RCEmployee getOperator() {
    return this.operator;
  }
  
  public RCDevice setOperator(final RCEmployee operator) {
    this.operator = operator;
    return this;			
    
  }
  
  @JoinColumn(name = "ownerDepartment_id")
  @ManyToOne(targetEntity = RCOrganizationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOrganization ownerDepartment;
  
  public RCOrganization getOwnerDepartment() {
    return this.ownerDepartment;
  }
  
  public RCDevice setOwnerDepartment(final RCOrganization ownerDepartment) {
    this.ownerDepartment = ownerDepartment;
    return this;			
    
  }
  
  private String ownerDepartmentName;
  
  public String getOwnerDepartmentName() {
    return this.ownerDepartmentName;
  }
  
  public RCDevice setOwnerDepartmentName(final String ownerDepartmentName) {
    this.ownerDepartmentName = ownerDepartmentName;
    return this;			
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  @JoinColumn(name = "extension_id")
  @OneToOne(targetEntity = RCExtensiableEntityImpl.class, cascade = CascadeType.ALL)
  private RCExtensiableEntity extension;
  
  public RCExtensiableEntity getExtension() {
    return this.extension;
  }
  
  public RCDevice setExtension(final RCExtensiableEntity extension) {
    this.extension = extension;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCDeviceFileImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "device")
  private Collection<RCDeviceFile> files = new java.util.ArrayList<com.fudanmed.platform.core.device.RCDeviceFile>();;
  
  public Collection<RCDeviceFile> getFiles() {
    return this.files;
  }
  
  public RCDeviceFile createAndAddtoFiles() {
    getFiles().size();
    com.fudanmed.platform.core.device.RCDeviceFile rCDeviceFile = new com.fudanmed.platform.core.device.impl.RCDeviceFileImpl(this);
    getObjectFactory().create(rCDeviceFile);
    getFiles().add(rCDeviceFile);
    return rCDeviceFile;
    
  }
  
  public RCDevice removeAllFiles() {
    for(RCDeviceFile obj : this.files){
    	getObjectFactory().delete(obj);
    }
    this.files.clear();
    return this;	
    
  }
  
  public RCDevice removeFromFiles(final RCDeviceFile rCDeviceFile) {
    this.files.remove(rCDeviceFile);
    getObjectFactory().delete(rCDeviceFile);
    return this;
    
  }
  
  @OneToMany(targetEntity = RCDevicePictureImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "device")
  private Collection<RCDevicePicture> pictures = new java.util.ArrayList<com.fudanmed.platform.core.device.RCDevicePicture>();;
  
  public Collection<RCDevicePicture> getPictures() {
    return this.pictures;
  }
  
  public RCDevicePicture createAndAddtoPictures() {
    getPictures().size();
    com.fudanmed.platform.core.device.RCDevicePicture rCDevicePicture = new com.fudanmed.platform.core.device.impl.RCDevicePictureImpl(this);
    getObjectFactory().create(rCDevicePicture);
    getPictures().add(rCDevicePicture);
    return rCDevicePicture;
    
  }
  
  public RCDevice removeAllPictures() {
    for(RCDevicePicture obj : this.pictures){
    	getObjectFactory().delete(obj);
    }
    this.pictures.clear();
    return this;	
    
  }
  
  public RCDevice removeFromPictures(final RCDevicePicture rCDevicePicture) {
    this.pictures.remove(rCDevicePicture);
    getObjectFactory().delete(rCDevicePicture);
    return this;
    
  }
  
  public RCDeviceFile createFile(final Procedure1<? super RCDeviceFile> init) {
    RCDeviceFile _createAndAddtoFiles = this.createAndAddtoFiles();
    final Procedure1<RCDeviceFile> _function = new Procedure1<RCDeviceFile>() {
        public void apply(final RCDeviceFile it) {
          init.apply(it);
        }
      };
    RCDeviceFile _doubleArrow = ObjectExtensions.<RCDeviceFile>operator_doubleArrow(_createAndAddtoFiles, _function);
    return _doubleArrow;
  }
  
  public void removeFile(final RCDeviceFile document) {
    this.removeFromFiles(document);
  }
  
  public RCDevicePicture createPicture(final Procedure1<? super RCDevicePicture> init) {
    RCDevicePicture _createAndAddtoPictures = this.createAndAddtoPictures();
    final Procedure1<RCDevicePicture> _function = new Procedure1<RCDevicePicture>() {
        public void apply(final RCDevicePicture it) {
          init.apply(it);
        }
      };
    RCDevicePicture _doubleArrow = ObjectExtensions.<RCDevicePicture>operator_doubleArrow(_createAndAddtoPictures, _function);
    return _doubleArrow;
  }
  
  public void removePicture(final RCDevicePicture picture) {
    this.removeFromPictures(picture);
  }
  
  public void checkValid() {
    IGenericQuery<Long> query=getObjectFactory().createGenericQuery(Long.class,"select count(*) from com.fudanmed.platform.core.device.impl.RCDeviceImpl as e   where (e.sid = :sid) and  e.active = 1      ").setParameter("sid",sid);
    Long _uniqueResult = query.uniqueResult();
    boolean _equals = ((_uniqueResult).longValue() == 1);
    Validates.Assert(_equals, "\u8BBE\u5907\u5E8F\u5217\u53F7\u5FC5\u987B\u552F\u4E00");
  }
  
  public static RCDevice create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.RCDevice rCDevice = new com.fudanmed.platform.core.device.impl.RCDeviceImpl(
    );
    objectFactory.create(rCDevice);
    return rCDevice;			
    
  }
  
  public RCDeviceProxy toProxy() {
    com.fudanmed.platform.core.device.proxy.RCDeviceProxy proxy = new com.fudanmed.platform.core.device.proxy.RCDeviceProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
