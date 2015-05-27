package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCAttribute;
import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.RCCompositeType;
import com.fudanmed.platform.core.entityextension.RCCompositeValue;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntityType;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.RCValue;
import com.fudanmed.platform.core.entityextension.impl.RCAttributeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCCompositeValueImpl;
import com.fudanmed.platform.core.entityextension.impl.RCExtensiableEntityTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCCompositeTypeProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCCOMPOSITETYPE_TYPE")
public class RCCompositeTypeImpl extends RCTypeImpl implements RCCompositeType {
  public RCCompositeTypeImpl() {
    super();
  }
  
  public RCCompositeTypeImpl(final RCExtensiableEntityType extensiableEntity) {
    super();
    this.extensiableEntity = extensiableEntity;
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCCompositeType setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  public String getTypeName() {
    return this.name;
  }
  
  @JoinColumn(name = "extensiableEntity_id")
  @ManyToOne(targetEntity = RCExtensiableEntityTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCExtensiableEntityType extensiableEntity;
  
  public RCExtensiableEntityType getExtensiableEntity() {
    return this.extensiableEntity;
  }
  
  public RCCompositeType setExtensiableEntity(final RCExtensiableEntityType extensiableEntity) {
    this.extensiableEntity = extensiableEntity;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCAttributeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "type")
  private Collection<RCAttribute> attrs = new java.util.ArrayList<com.fudanmed.platform.core.entityextension.RCAttribute>();;
  
  public Collection<RCAttribute> getAttrs() {
    return this.attrs;
  }
  
  public RCAttribute createAndAddtoAttrs() {
    getAttrs().size();
    com.fudanmed.platform.core.entityextension.RCAttribute rCAttribute = new com.fudanmed.platform.core.entityextension.impl.RCAttributeImpl(this);
    getObjectFactory().create(rCAttribute);
    getAttrs().add(rCAttribute);
    return rCAttribute;
    
  }
  
  public RCCompositeType removeAllAttrs() {
    for(RCAttribute obj : this.attrs){
    	getObjectFactory().delete(obj);
    }
    this.attrs.clear();
    return this;	
    
  }
  
  public RCCompositeType removeFromAttrs(final RCAttribute rCAttribute) {
    this.attrs.remove(rCAttribute);
    getObjectFactory().delete(rCAttribute);
    return this;
    
  }
  
  public RCCompositeValue createInstance(final RCExtensiableEntity rootOwner) {RCCompositeValue rCCompositeValue=RCCompositeValueImpl.create(getObjectFactory());
    final Procedure1<RCCompositeValue> _function = new Procedure1<RCCompositeValue>() {
        public void apply(final RCCompositeValue compositeValue) {
          compositeValue.setRootOwner(rootOwner);
          compositeValue.setType(RCCompositeTypeImpl.this);
          final Procedure1<RCAttribute> _function = new Procedure1<RCAttribute>() {
              public void apply(final RCAttribute attr) {
                RCAttributeSlot _createAndAddtoSlots = compositeValue.createAndAddtoSlots();
                final Procedure1<RCAttributeSlot> _function = new Procedure1<RCAttributeSlot>() {
                    public void apply(final RCAttributeSlot slot) {
                      slot.setAttr(attr);
                      RCType _typeRef = attr.getTypeRef();
                      RCValue _createInstance = _typeRef.createInstance(rootOwner);
                      slot.setValue(_createInstance);
                    }
                  };
                ObjectExtensions.<RCAttributeSlot>operator_doubleArrow(_createAndAddtoSlots, _function);
              }
            };
          IterableExtensions.<RCAttribute>forEach(RCCompositeTypeImpl.this.attrs, _function);
        }
      };
    RCCompositeValue _doubleArrow = ObjectExtensions.<RCCompositeValue>operator_doubleArrow(rCCompositeValue, _function);
    return _doubleArrow;
  }
  
  public RCCompositeType cloneType(final RCExtensiableEntityType extensiableEntity) {RCCompositeType rCCompositeType=RCCompositeTypeImpl.create(extensiableEntity,getObjectFactory());
    final Procedure1<RCCompositeType> _function = new Procedure1<RCCompositeType>() {
        public void apply(final RCCompositeType newType) {
          newType.setName(RCCompositeTypeImpl.this.name);
          final Procedure1<RCAttribute> _function = new Procedure1<RCAttribute>() {
              public void apply(final RCAttribute oldAttr) {
                RCAttribute _createAndAddtoAttrs = newType.createAndAddtoAttrs();
                final Procedure1<RCAttribute> _function = new Procedure1<RCAttribute>() {
                    public void apply(final RCAttribute newAttr) {
                      String _name = oldAttr.getName();
                      newAttr.setName(_name);
                      RCType _typeRef = oldAttr.getTypeRef();
                      RCType _cloneType = _typeRef.cloneType(extensiableEntity);
                      newAttr.setTypeRef(_cloneType);
                    }
                  };
                ObjectExtensions.<RCAttribute>operator_doubleArrow(_createAndAddtoAttrs, _function);
              }
            };
          IterableExtensions.<RCAttribute>forEach(RCCompositeTypeImpl.this.attrs, _function);
        }
      };
    RCCompositeType _doubleArrow = ObjectExtensions.<RCCompositeType>operator_doubleArrow(rCCompositeType, _function);
    return _doubleArrow;
  }
  
  public static RCCompositeType create(final RCExtensiableEntityType extensiableEntity, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCCompositeType rCCompositeType = new com.fudanmed.platform.core.entityextension.impl.RCCompositeTypeImpl(
    	extensiableEntity
    );
    objectFactory.create(rCCompositeType);
    return rCCompositeType;			
    
  }
  
  public RCCompositeTypeProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCCompositeTypeProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCCompositeTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
