package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCAttribute;
import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.RCCompositeType;
import com.fudanmed.platform.core.entityextension.RCCompositeValue;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntityType;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.RCValue;
import com.fudanmed.platform.core.entityextension.impl.RCAttributeSlotImpl;
import com.fudanmed.platform.core.entityextension.impl.RCValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCCompositeValueProxy;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCCOMPOSITEVALUE_TYPE")
public class RCCompositeValueImpl extends RCValueImpl implements RCCompositeValue {
  public RCCompositeValueImpl() {
    super();
  }
  
  @OneToMany(targetEntity = RCAttributeSlotImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "attrValue")
  private Collection<RCAttributeSlot> slots = new java.util.ArrayList<com.fudanmed.platform.core.entityextension.RCAttributeSlot>();;
  
  public Collection<RCAttributeSlot> getSlots() {
    return this.slots;
  }
  
  public RCAttributeSlot createAndAddtoSlots() {
    getSlots().size();
    com.fudanmed.platform.core.entityextension.RCAttributeSlot rCAttributeSlot = new com.fudanmed.platform.core.entityextension.impl.RCAttributeSlotImpl(this);
    getObjectFactory().create(rCAttributeSlot);
    getSlots().add(rCAttributeSlot);
    return rCAttributeSlot;
    
  }
  
  public RCCompositeValue removeAllSlots() {
    for(RCAttributeSlot obj : this.slots){
    	getObjectFactory().delete(obj);
    }
    this.slots.clear();
    return this;	
    
  }
  
  public RCCompositeValue removeFromSlots(final RCAttributeSlot rCAttributeSlot) {
    this.slots.remove(rCAttributeSlot);
    getObjectFactory().delete(rCAttributeSlot);
    return this;
    
  }
  
  public RCAttributeSlot createAttribute(final String name, final RCType typeRef) {
    RCAttributeSlot _xblockexpression = null;
    {
      RCType _type = this.getType();
      RCAttribute _createAndAddtoAttrs = ((RCCompositeType) _type).createAndAddtoAttrs();
      final Procedure1<RCAttribute> _function = new Procedure1<RCAttribute>() {
          public void apply(final RCAttribute it) {
            it.setName(name);
            it.setTypeRef(typeRef);
          }
        };
      final RCAttribute t = ObjectExtensions.<RCAttribute>operator_doubleArrow(_createAndAddtoAttrs, _function);
      RCType _type_1 = this.getType();
      IGenericQuery<RCValue> query=getObjectFactory().createGenericQuery(RCValue.class,"select v from com.fudanmed.platform.core.entityextension.impl.RCValueImpl as v   where (v.type = :_type_1) and  v.active = 1      ").setParameter("_type_1",_type_1);
      Collection<RCValue> _list = query.list();
      final Function1<RCValue,Boolean> _function_1 = new Function1<RCValue,Boolean>() {
          public Boolean apply(final RCValue it) {
            boolean _notEquals = (!Objects.equal(it, RCCompositeValueImpl.this));
            return Boolean.valueOf(_notEquals);
          }
        };
      Iterable<RCValue> _filter = IterableExtensions.<RCValue>filter(_list, _function_1);
      Iterable<RCCompositeValue> _filter_1 = Iterables.<RCCompositeValue>filter(_filter, RCCompositeValue.class);
      final Procedure1<RCCompositeValue> _function_2 = new Procedure1<RCCompositeValue>() {
          public void apply(final RCCompositeValue it) {
            RCAttributeSlot _createAndAddtoSlots = it.createAndAddtoSlots();
            final Procedure1<RCAttributeSlot> _function = new Procedure1<RCAttributeSlot>() {
                public void apply(final RCAttributeSlot it) {
                  it.setAttr(t);
                  RCExtensiableEntity _rootOwner = RCCompositeValueImpl.this.getRootOwner();
                  RCValue _createInstance = typeRef.createInstance(_rootOwner);
                  it.setValue(_createInstance);
                  RCValue _value = it.getValue();
                  _value.setSlotOwner(it);
                }
              };
            ObjectExtensions.<RCAttributeSlot>operator_doubleArrow(_createAndAddtoSlots, _function);
          }
        };
      IterableExtensions.<RCCompositeValue>forEach(_filter_1, _function_2);
      RCAttributeSlot _createAndAddtoSlots = this.createAndAddtoSlots();
      final Procedure1<RCAttributeSlot> _function_3 = new Procedure1<RCAttributeSlot>() {
          public void apply(final RCAttributeSlot it) {
            it.setAttr(t);
            RCExtensiableEntity _rootOwner = RCCompositeValueImpl.this.getRootOwner();
            RCValue _createInstance = typeRef.createInstance(_rootOwner);
            it.setValue(_createInstance);
            RCValue _value = it.getValue();
            _value.setSlotOwner(it);
          }
        };
      RCAttributeSlot _doubleArrow = ObjectExtensions.<RCAttributeSlot>operator_doubleArrow(_createAndAddtoSlots, _function_3);
      _xblockexpression = (_doubleArrow);
    }
    return _xblockexpression;
  }
  
  public RCAttributeSlot createAttribute(final String name, final String typeName) {
    RCAttributeSlot _xblockexpression = null;
    {
      RCExtensiableEntity _rootOwner = this.getRootOwner();
      RCExtensiableEntityType _type = _rootOwner.getType();
      RCCompositeType _createAndAddtoCompositeTypes = _type.createAndAddtoCompositeTypes();
      final Procedure1<RCCompositeType> _function = new Procedure1<RCCompositeType>() {
          public void apply(final RCCompositeType it) {
            it.setName(typeName);
          }
        };
      final RCCompositeType type = ObjectExtensions.<RCCompositeType>operator_doubleArrow(_createAndAddtoCompositeTypes, _function);
      RCType _type_1 = this.getType();
      RCAttribute _createAndAddtoAttrs = ((RCCompositeType) _type_1).createAndAddtoAttrs();
      final Procedure1<RCAttribute> _function_1 = new Procedure1<RCAttribute>() {
          public void apply(final RCAttribute it) {
            it.setName(name);
            it.setTypeRef(type);
          }
        };
      final RCAttribute attr = ObjectExtensions.<RCAttribute>operator_doubleArrow(_createAndAddtoAttrs, _function_1);
      RCType _type_2 = this.getType();
      IGenericQuery<RCValue> query=getObjectFactory().createGenericQuery(RCValue.class,"select v from com.fudanmed.platform.core.entityextension.impl.RCValueImpl as v   where (v.type = :_type_2) and  v.active = 1      ").setParameter("_type_2",_type_2);
      Collection<RCValue> _list = query.list();
      final Function1<RCValue,Boolean> _function_2 = new Function1<RCValue,Boolean>() {
          public Boolean apply(final RCValue it) {
            boolean _notEquals = (!Objects.equal(it, RCCompositeValueImpl.this));
            return Boolean.valueOf(_notEquals);
          }
        };
      Iterable<RCValue> _filter = IterableExtensions.<RCValue>filter(_list, _function_2);
      Iterable<RCCompositeValue> _filter_1 = Iterables.<RCCompositeValue>filter(_filter, RCCompositeValue.class);
      final Procedure1<RCCompositeValue> _function_3 = new Procedure1<RCCompositeValue>() {
          public void apply(final RCCompositeValue it) {
            RCAttributeSlot _createAndAddtoSlots = it.createAndAddtoSlots();
            final Procedure1<RCAttributeSlot> _function = new Procedure1<RCAttributeSlot>() {
                public void apply(final RCAttributeSlot it) {
                  it.setAttr(attr);
                  RCExtensiableEntity _rootOwner = RCCompositeValueImpl.this.getRootOwner();
                  RCCompositeValue _createInstance = type.createInstance(_rootOwner);
                  it.setValue(_createInstance);
                  RCValue _value = it.getValue();
                  _value.setSlotOwner(it);
                }
              };
            ObjectExtensions.<RCAttributeSlot>operator_doubleArrow(_createAndAddtoSlots, _function);
          }
        };
      IterableExtensions.<RCCompositeValue>forEach(_filter_1, _function_3);
      RCAttributeSlot _createAndAddtoSlots = this.createAndAddtoSlots();
      final Procedure1<RCAttributeSlot> _function_4 = new Procedure1<RCAttributeSlot>() {
          public void apply(final RCAttributeSlot it) {
            it.setAttr(attr);
            RCExtensiableEntity _rootOwner = RCCompositeValueImpl.this.getRootOwner();
            RCCompositeValue _createInstance = type.createInstance(_rootOwner);
            it.setValue(_createInstance);
            RCValue _value = it.getValue();
            _value.setSlotOwner(it);
          }
        };
      RCAttributeSlot _doubleArrow = ObjectExtensions.<RCAttributeSlot>operator_doubleArrow(_createAndAddtoSlots, _function_4);
      _xblockexpression = (_doubleArrow);
    }
    return _xblockexpression;
  }
  
  public void removeAttribute(final RCAttribute attr) {
    IGenericQuery<RCAttributeSlot> query=getObjectFactory().createGenericQuery(RCAttributeSlot.class,"select s from com.fudanmed.platform.core.entityextension.impl.RCAttributeSlotImpl as s   where (s.attr = :attr) and  s.active = 1      ").setParameter("attr",attr);
    Collection<RCAttributeSlot> _list = query.list();
    final Procedure1<RCAttributeSlot> _function = new Procedure1<RCAttributeSlot>() {
        public void apply(final RCAttributeSlot it) {getObjectFactory().delete(it);
          
        }
      };
    IterableExtensions.<RCAttributeSlot>forEach(_list, _function);getObjectFactory().delete(attr);
    
  }
  
  public String getEntityName() {
    final Function1<RCAttributeSlot,String> _function = new Function1<RCAttributeSlot,String>() {
        public String apply(final RCAttributeSlot slot) {
          RCAttribute _attr = slot.getAttr();
          String _name = _attr.getName();
          String _plus = (_name + ":{");
          RCValue _value = slot.getValue();
          String _entityName = _value.getEntityName();
          String _plus_1 = (_plus + _entityName);
          String _plus_2 = (_plus_1 + "}");
          return _plus_2;
        }
      };
    Iterable<String> _map = IterableExtensions.<RCAttributeSlot, String>map(this.slots, _function);
    String _join = IterableExtensions.join(_map, ",");
    return _join;
  }
  
  public RCCompositeValue cloneIn(final RCExtensiableEntity rootOwner) {RCCompositeValue rCCompositeValue=RCCompositeValueImpl.create(getObjectFactory());
    final Procedure1<RCCompositeValue> _function = new Procedure1<RCCompositeValue>() {
        public void apply(final RCCompositeValue compositeValue) {
          compositeValue.setRootOwner(rootOwner);
          RCType _type = RCCompositeValueImpl.this.getType();
          compositeValue.setType(_type);
          final Procedure1<RCAttributeSlot> _function = new Procedure1<RCAttributeSlot>() {
              public void apply(final RCAttributeSlot slot) {
                RCAttributeSlot _createAndAddtoSlots = compositeValue.createAndAddtoSlots();
                final Procedure1<RCAttributeSlot> _function = new Procedure1<RCAttributeSlot>() {
                    public void apply(final RCAttributeSlot it) {
                      RCAttribute _attr = slot.getAttr();
                      it.setAttr(_attr);
                      RCValue _value = slot.getValue();
                      RCValue _cloneIn = _value.cloneIn(rootOwner);
                      it.setValue(_cloneIn);
                      RCValue _value_1 = it.getValue();
                      _value_1.setSlotOwner(it);
                    }
                  };
                ObjectExtensions.<RCAttributeSlot>operator_doubleArrow(_createAndAddtoSlots, _function);
              }
            };
          IterableExtensions.<RCAttributeSlot>forEach(RCCompositeValueImpl.this.slots, _function);
        }
      };
    RCCompositeValue _doubleArrow = ObjectExtensions.<RCCompositeValue>operator_doubleArrow(rCCompositeValue, _function);
    return _doubleArrow;
  }
  
  public static RCCompositeValue create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCCompositeValue rCCompositeValue = new com.fudanmed.platform.core.entityextension.impl.RCCompositeValueImpl(
    );
    objectFactory.create(rCCompositeValue);
    return rCCompositeValue;			
    
  }
  
  public RCCompositeValueProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCCompositeValueProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCCompositeValueProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
