package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceTypeCategory;
import com.fudanmed.platform.core.device.events.RCDeviceTypeEventsManager;
import com.fudanmed.platform.core.device.impl.RCDeviceTypeImpl;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.entityextension.RCCompositeType;
import com.fudanmed.platform.core.entityextension.RCCompositeValue;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntityType;
import com.fudanmed.platform.core.entityextension.impl.RCCompositeTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCExtensiableEntityImpl;
import com.fudanmed.platform.core.entityextension.impl.RCExtensiableEntityTypeImpl;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.beans.factory.BeanFactory;

@Entity
@DiscriminatorValue("RCDEVICETYPECATEGORY_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcdevicetypecategory")
public class RCDeviceTypeCategoryImpl extends BaseModelObject implements RCDeviceTypeCategory {
  public RCDeviceTypeCategoryImpl() {
    super();
  }
  
  public RCDeviceTypeCategoryImpl(final RCDeviceTypeCategory parent) {
    super();
    this.parent = parent;
  }
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public RCDeviceTypeCategory setCode(final String code) {
    this.code = code;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCDeviceTypeCategory setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private String simplePy;
  
  public String getSimplePy() {
    return this.simplePy;
  }
  
  public RCDeviceTypeCategory setSimplePy(final String simplePy) {
    this.simplePy = simplePy;
    return this;			
    
  }
  
  @JoinColumn(name = "parent_id")
  @ManyToOne(targetEntity = RCDeviceTypeCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCDeviceTypeCategory parent;
  
  public RCDeviceTypeCategory getParent() {
    return this.parent;
  }
  
  public RCDeviceTypeCategory setParent(final RCDeviceTypeCategory parent) {
    this.parent = parent;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCDeviceTypeCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "parent")
  private Collection<RCDeviceTypeCategory> subCategories = new java.util.ArrayList<com.fudanmed.platform.core.device.RCDeviceTypeCategory>();;
  
  public Collection<RCDeviceTypeCategory> getSubCategories() {
    return this.subCategories;
  }
  
  public RCDeviceTypeCategory createAndAddtoSubCategories() {
    getSubCategories().size();
    com.fudanmed.platform.core.device.RCDeviceTypeCategory rCDeviceTypeCategory = new com.fudanmed.platform.core.device.impl.RCDeviceTypeCategoryImpl(this);
    getObjectFactory().create(rCDeviceTypeCategory);
    getSubCategories().add(rCDeviceTypeCategory);
    return rCDeviceTypeCategory;
    
  }
  
  public RCDeviceTypeCategory removeAllSubCategories() {
    for(RCDeviceTypeCategory obj : this.subCategories){
    	getObjectFactory().delete(obj);
    }
    this.subCategories.clear();
    return this;	
    
  }
  
  public RCDeviceTypeCategory removeFromSubCategories(final RCDeviceTypeCategory rCDeviceTypeCategory) {
    this.subCategories.remove(rCDeviceTypeCategory);
    getObjectFactory().delete(rCDeviceTypeCategory);
    return this;
    
  }
  
  @OneToMany(targetEntity = RCDeviceTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "category")
  private Collection<RCDeviceType> deviceTypes = new java.util.ArrayList<com.fudanmed.platform.core.device.RCDeviceType>();;
  
  public Collection<RCDeviceType> getDeviceTypes() {
    return this.deviceTypes;
  }
  
  public RCDeviceType createAndAddtoDeviceTypes() {
    getDeviceTypes().size();
    com.fudanmed.platform.core.device.RCDeviceType rCDeviceType = new com.fudanmed.platform.core.device.impl.RCDeviceTypeImpl(this);
    getObjectFactory().create(rCDeviceType);
    getDeviceTypes().add(rCDeviceType);
    return rCDeviceType;
    
  }
  
  public RCDeviceTypeCategory removeAllDeviceTypes() {
    for(RCDeviceType obj : this.deviceTypes){
    	getObjectFactory().delete(obj);
    }
    this.deviceTypes.clear();
    return this;	
    
  }
  
  public RCDeviceTypeCategory removeFromDeviceTypes(final RCDeviceType rCDeviceType) {
    this.deviceTypes.remove(rCDeviceType);
    getObjectFactory().delete(rCDeviceType);
    return this;
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public String getNameField() {
    return "name";
  }
  
  public RCDeviceType createDeviceType() {
    RCDeviceType _createAndAddtoDeviceTypes = this.createAndAddtoDeviceTypes();
    final Procedure1<RCDeviceType> _function = new Procedure1<RCDeviceType>() {
        public void apply(final RCDeviceType it) {RCExtensiableEntityType rCExtensiableEntityType=RCExtensiableEntityTypeImpl.create(getObjectFactory());
          final Procedure1<RCExtensiableEntityType> _function = new Procedure1<RCExtensiableEntityType>() {
              public void apply(final RCExtensiableEntityType etype) {RCCompositeType rCCompositeType=RCCompositeTypeImpl.create(etype,getObjectFactory());
                etype.setRootType(rCCompositeType);
              }
            };
          RCExtensiableEntityType _doubleArrow = ObjectExtensions.<RCExtensiableEntityType>operator_doubleArrow(rCExtensiableEntityType, _function);
          it.setExtensiableType(_doubleArrow);RCExtensiableEntity rCExtensiableEntity=RCExtensiableEntityImpl.create(getObjectFactory());
          final Procedure1<RCExtensiableEntity> _function_1 = new Procedure1<RCExtensiableEntity>() {
              public void apply(final RCExtensiableEntity extension) {
                RCExtensiableEntityType _extensiableType = it.getExtensiableType();
                extension.setType(_extensiableType);
                RCExtensiableEntityType _extensiableType_1 = it.getExtensiableType();
                RCCompositeType _rootType = _extensiableType_1.getRootType();
                RCCompositeValue _createInstance = _rootType.createInstance(extension);
                extension.setValue(_createInstance);
              }
            };
          RCExtensiableEntity _doubleArrow_1 = ObjectExtensions.<RCExtensiableEntity>operator_doubleArrow(rCExtensiableEntity, _function_1);
          it.setDefaultValue(_doubleArrow_1);
          BeanFactory _beanFactory = RCDeviceTypeCategoryImpl.this.getBeanFactory();
          RCDeviceTypeEventsManager _bean = _beanFactory.<RCDeviceTypeEventsManager>getBean(RCDeviceTypeEventsManager.class);
          _bean.fireCreated(it);
        }
      };
    RCDeviceType _doubleArrow = ObjectExtensions.<RCDeviceType>operator_doubleArrow(_createAndAddtoDeviceTypes, _function);
    return _doubleArrow;
  }
  
  public RCDeviceType cloneDeviceType(final RCDeviceType sourceType) {
    RCDeviceType _createAndAddtoDeviceTypes = this.createAndAddtoDeviceTypes();
    final Procedure1<RCDeviceType> _function = new Procedure1<RCDeviceType>() {
        public void apply(final RCDeviceType it) {RCExtensiableEntityType rCExtensiableEntityType=RCExtensiableEntityTypeImpl.create(getObjectFactory());
          final Procedure1<RCExtensiableEntityType> _function = new Procedure1<RCExtensiableEntityType>() {
              public void apply(final RCExtensiableEntityType etype) {
                RCExtensiableEntityType _extensiableType = sourceType.getExtensiableType();
                RCCompositeType _rootType = _extensiableType.getRootType();
                RCCompositeType _cloneType = _rootType.cloneType(etype);
                etype.setRootType(_cloneType);
              }
            };
          RCExtensiableEntityType _doubleArrow = ObjectExtensions.<RCExtensiableEntityType>operator_doubleArrow(rCExtensiableEntityType, _function);
          it.setExtensiableType(_doubleArrow);RCExtensiableEntity rCExtensiableEntity=RCExtensiableEntityImpl.create(getObjectFactory());
          final Procedure1<RCExtensiableEntity> _function_1 = new Procedure1<RCExtensiableEntity>() {
              public void apply(final RCExtensiableEntity extension) {
                RCExtensiableEntityType _extensiableType = it.getExtensiableType();
                extension.setType(_extensiableType);
                RCExtensiableEntityType _extensiableType_1 = it.getExtensiableType();
                RCCompositeType _rootType = _extensiableType_1.getRootType();
                RCCompositeValue _createInstance = _rootType.createInstance(extension);
                extension.setValue(_createInstance);
              }
            };
          RCExtensiableEntity _doubleArrow_1 = ObjectExtensions.<RCExtensiableEntity>operator_doubleArrow(rCExtensiableEntity, _function_1);
          it.setDefaultValue(_doubleArrow_1);
          BeanFactory _beanFactory = RCDeviceTypeCategoryImpl.this.getBeanFactory();
          RCDeviceTypeEventsManager _bean = _beanFactory.<RCDeviceTypeEventsManager>getBean(RCDeviceTypeEventsManager.class);
          _bean.fireCreated(it);
        }
      };
    RCDeviceType _doubleArrow = ObjectExtensions.<RCDeviceType>operator_doubleArrow(_createAndAddtoDeviceTypes, _function);
    return _doubleArrow;
  }
  
  public void deleteDeviceType(final RCDeviceType deviceType) {
    RCExtensiableEntity _defaultValue = deviceType.getDefaultValue();getObjectFactory().delete(_defaultValue);
    
    RCExtensiableEntityType _extensiableType = deviceType.getExtensiableType();getObjectFactory().delete(_extensiableType);
    
    this.removeFromDeviceTypes(deviceType);
    BeanFactory _beanFactory = this.getBeanFactory();
    RCDeviceTypeEventsManager _bean = _beanFactory.<RCDeviceTypeEventsManager>getBean(RCDeviceTypeEventsManager.class);
    _bean.fireDeleted(deviceType);
  }
  
  public static RCDeviceTypeCategory create(final RCDeviceTypeCategory parent, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.RCDeviceTypeCategory rCDeviceTypeCategory = new com.fudanmed.platform.core.device.impl.RCDeviceTypeCategoryImpl(
    	parent
    );
    objectFactory.create(rCDeviceTypeCategory);
    return rCDeviceTypeCategory;			
    
  }
  
  public RCDeviceTypeCategoryProxy toProxy() {
    com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy proxy = new com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
