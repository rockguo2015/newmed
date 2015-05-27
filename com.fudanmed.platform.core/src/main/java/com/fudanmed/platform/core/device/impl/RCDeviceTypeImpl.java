package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceTypeCategory;
import com.fudanmed.platform.core.device.RCDeviceTypeFile;
import com.fudanmed.platform.core.device.RCDeviceTypePicture;
import com.fudanmed.platform.core.device.impl.RCDeviceTypeCategoryImpl;
import com.fudanmed.platform.core.device.impl.RCDeviceTypeFileImpl;
import com.fudanmed.platform.core.device.impl.RCDeviceTypePictureImpl;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntityType;
import com.fudanmed.platform.core.entityextension.impl.RCExtensiableEntityImpl;
import com.fudanmed.platform.core.entityextension.impl.RCExtensiableEntityTypeImpl;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.impl.RCProductSpecificationImpl;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCDEVICETYPE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcdevicetype")
public class RCDeviceTypeImpl extends BaseModelObject implements RCDeviceType {
  public RCDeviceTypeImpl() {
    super();
  }
  
  public RCDeviceTypeImpl(final RCDeviceTypeCategory category) {
    super();
    this.category = category;
  }
  
  @JoinColumn(name = "category_id")
  @ManyToOne(targetEntity = RCDeviceTypeCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCDeviceTypeCategory category;
  
  public RCDeviceTypeCategory getCategory() {
    return this.category;
  }
  
  public RCDeviceType setCategory(final RCDeviceTypeCategory category) {
    this.category = category;
    return this;			
    
  }
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public RCDeviceType setCode(final String code) {
    this.code = code;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCDeviceType setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private Integer depreciationYears;
  
  public Integer getDepreciationYears() {
    return this.depreciationYears;
  }
  
  public RCDeviceType setDepreciationYears(final Integer depreciationYears) {
    this.depreciationYears = depreciationYears;
    return this;			
    
  }
  
  private String path;
  
  public String getPath() {
    return this.path;
  }
  
  public RCDeviceType setPath(final String path) {
    this.path = path;
    return this;			
    
  }
  
  @JoinColumn(name = "extensiableType_id")
  @OneToOne(targetEntity = RCExtensiableEntityTypeImpl.class, cascade = CascadeType.ALL)
  private RCExtensiableEntityType extensiableType;
  
  public RCExtensiableEntityType getExtensiableType() {
    return this.extensiableType;
  }
  
  public RCDeviceType setExtensiableType(final RCExtensiableEntityType extensiableType) {
    this.extensiableType = extensiableType;
    return this;			
    
  }
  
  @JoinColumn(name = "defaultValue_id")
  @OneToOne(targetEntity = RCExtensiableEntityImpl.class, cascade = CascadeType.ALL)
  private RCExtensiableEntity defaultValue;
  
  public RCExtensiableEntity getDefaultValue() {
    return this.defaultValue;
  }
  
  public RCDeviceType setDefaultValue(final RCExtensiableEntity defaultValue) {
    this.defaultValue = defaultValue;
    return this;			
    
  }
  
  @ManyToMany(targetEntity = RCProductSpecificationImpl.class)
  @JoinTable(name = "m2m_rcdevicetype_parttypes", joinColumns = @JoinColumn(name = "rcdevicetype_id") , inverseJoinColumns = @JoinColumn(name = "rCProductSpecification_inv_id") )
  private Collection<RCProductSpecification> partTypes = new java.util.ArrayList<com.fudanmed.platform.core.warehouse.RCProductSpecification>();;
  
  public Collection<RCProductSpecification> getPartTypes() {
    return this.partTypes;
  }
  
  public RCDeviceType setPartTypes(final Iterable<RCProductSpecification> partTypes) {
    removeAllPartTypes();
    for(RCProductSpecification ca : partTypes){
    	addtoPartTypes(ca);
    }
    return this;		
    
  }
  
  public RCDeviceType addtoPartTypes(final RCProductSpecification rCProductSpecification) {
    this.partTypes.add(rCProductSpecification);
    return this;
    
  }
  
  public RCDeviceType removeAllPartTypes() {
    this.partTypes.clear();
    return this;	
    
  }
  
  public RCDeviceType removeFromPartTypes(final RCProductSpecification rCProductSpecification) {
    this.partTypes.remove(rCProductSpecification);
    return this;
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  @OneToMany(targetEntity = RCDeviceTypeFileImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "deviceType")
  private Collection<RCDeviceTypeFile> files = new java.util.ArrayList<com.fudanmed.platform.core.device.RCDeviceTypeFile>();;
  
  public Collection<RCDeviceTypeFile> getFiles() {
    return this.files;
  }
  
  public RCDeviceTypeFile createAndAddtoFiles() {
    getFiles().size();
    com.fudanmed.platform.core.device.RCDeviceTypeFile rCDeviceTypeFile = new com.fudanmed.platform.core.device.impl.RCDeviceTypeFileImpl(this);
    getObjectFactory().create(rCDeviceTypeFile);
    getFiles().add(rCDeviceTypeFile);
    return rCDeviceTypeFile;
    
  }
  
  public RCDeviceType removeAllFiles() {
    for(RCDeviceTypeFile obj : this.files){
    	getObjectFactory().delete(obj);
    }
    this.files.clear();
    return this;	
    
  }
  
  public RCDeviceType removeFromFiles(final RCDeviceTypeFile rCDeviceTypeFile) {
    this.files.remove(rCDeviceTypeFile);
    getObjectFactory().delete(rCDeviceTypeFile);
    return this;
    
  }
  
  @OneToMany(targetEntity = RCDeviceTypePictureImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "deviceType")
  private Collection<RCDeviceTypePicture> pictures = new java.util.ArrayList<com.fudanmed.platform.core.device.RCDeviceTypePicture>();;
  
  public Collection<RCDeviceTypePicture> getPictures() {
    return this.pictures;
  }
  
  public RCDeviceTypePicture createAndAddtoPictures() {
    getPictures().size();
    com.fudanmed.platform.core.device.RCDeviceTypePicture rCDeviceTypePicture = new com.fudanmed.platform.core.device.impl.RCDeviceTypePictureImpl(this);
    getObjectFactory().create(rCDeviceTypePicture);
    getPictures().add(rCDeviceTypePicture);
    return rCDeviceTypePicture;
    
  }
  
  public RCDeviceType removeAllPictures() {
    for(RCDeviceTypePicture obj : this.pictures){
    	getObjectFactory().delete(obj);
    }
    this.pictures.clear();
    return this;	
    
  }
  
  public RCDeviceType removeFromPictures(final RCDeviceTypePicture rCDeviceTypePicture) {
    this.pictures.remove(rCDeviceTypePicture);
    getObjectFactory().delete(rCDeviceTypePicture);
    return this;
    
  }
  
  public RCDeviceTypeFile createFile(final Procedure1<? super RCDeviceTypeFile> init) {
    RCDeviceTypeFile _createAndAddtoFiles = this.createAndAddtoFiles();
    final Procedure1<RCDeviceTypeFile> _function = new Procedure1<RCDeviceTypeFile>() {
        public void apply(final RCDeviceTypeFile it) {
          init.apply(it);
        }
      };
    RCDeviceTypeFile _doubleArrow = ObjectExtensions.<RCDeviceTypeFile>operator_doubleArrow(_createAndAddtoFiles, _function);
    return _doubleArrow;
  }
  
  public void removeFile(final RCDeviceTypeFile document) {
    this.removeFromFiles(document);
  }
  
  public RCDeviceTypePicture createPicture(final Procedure1<? super RCDeviceTypePicture> init) {
    RCDeviceTypePicture _createAndAddtoPictures = this.createAndAddtoPictures();
    final Procedure1<RCDeviceTypePicture> _function = new Procedure1<RCDeviceTypePicture>() {
        public void apply(final RCDeviceTypePicture it) {
          init.apply(it);
        }
      };
    RCDeviceTypePicture _doubleArrow = ObjectExtensions.<RCDeviceTypePicture>operator_doubleArrow(_createAndAddtoPictures, _function);
    return _doubleArrow;
  }
  
  public void removePicture(final RCDeviceTypePicture picture) {
    this.removeFromPictures(picture);
  }
  
  public static RCDeviceType create(final RCDeviceTypeCategory category, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.RCDeviceType rCDeviceType = new com.fudanmed.platform.core.device.impl.RCDeviceTypeImpl(
    	category
    );
    objectFactory.create(rCDeviceType);
    return rCDeviceType;			
    
  }
  
  public RCDeviceTypeProxy toProxy() {
    com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy proxy = new com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
