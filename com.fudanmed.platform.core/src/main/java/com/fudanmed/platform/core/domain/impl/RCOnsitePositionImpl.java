package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.google.common.base.Objects;
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
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCONSITEPOSITION_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rconsiteposition")
public class RCOnsitePositionImpl extends BaseModelObject implements RCOnsitePosition {
  public RCOnsitePositionImpl() {
    super();
  }
  
  public RCOnsitePositionImpl(final RCOnsitePosition parent) {
    super();
    this.parent = parent;
  }
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public RCOnsitePosition setCode(final String code) {
    this.code = code;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCOnsitePosition setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private String phone;
  
  public String getPhone() {
    return this.phone;
  }
  
  public RCOnsitePosition setPhone(final String phone) {
    this.phone = phone;
    return this;			
    
  }
  
  @JoinColumn(name = "parent_id")
  @ManyToOne(targetEntity = RCOnsitePositionImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOnsitePosition parent;
  
  public RCOnsitePosition getParent() {
    return this.parent;
  }
  
  public RCOnsitePosition setParent(final RCOnsitePosition parent) {
    this.parent = parent;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCOnsitePositionImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "parent")
  private Collection<RCOnsitePosition> subPosition = new java.util.ArrayList<com.fudanmed.platform.core.domain.RCOnsitePosition>();;
  
  public Collection<RCOnsitePosition> getSubPosition() {
    return this.subPosition;
  }
  
  public RCOnsitePosition createAndAddtoSubPosition() {
    getSubPosition().size();
    com.fudanmed.platform.core.domain.RCOnsitePosition rCOnsitePosition = new com.fudanmed.platform.core.domain.impl.RCOnsitePositionImpl(this);
    getObjectFactory().create(rCOnsitePosition);
    getSubPosition().add(rCOnsitePosition);
    return rCOnsitePosition;
    
  }
  
  public RCOnsitePosition removeAllSubPosition() {
    for(RCOnsitePosition obj : this.subPosition){
    	getObjectFactory().delete(obj);
    }
    this.subPosition.clear();
    return this;	
    
  }
  
  public RCOnsitePosition removeFromSubPosition(final RCOnsitePosition rCOnsitePosition) {
    this.subPosition.remove(rCOnsitePosition);
    getObjectFactory().delete(rCOnsitePosition);
    return this;
    
  }
  
  private String simplePy;
  
  public String getSimplePy() {
    return this.simplePy;
  }
  
  public RCOnsitePosition setSimplePy(final String simplePy) {
    this.simplePy = simplePy;
    return this;			
    
  }
  
  private String path;
  
  public String getPath() {
    return this.path;
  }
  
  public RCOnsitePosition setPath(final String path) {
    this.path = path;
    return this;			
    
  }
  
  public String getEntityName() {
    String _fullPath = this.fullPath();
    return _fullPath;
  }
  
  public String getNameField() {
    return "name";
  }
  
  public String toIdBlock() {
    Long _id = this.getId();
    String _string = _id.toString();
    String _plus = ("[" + _string);
    String _plus_1 = (_plus + "]");
    return _plus_1;
  }
  
  public String fullIdPath() {
    String _xblockexpression = null;
    {
      String path = this.toIdBlock();
      RCOnsitePosition curParent = this.parent;
      boolean _notEquals = (!Objects.equal(curParent, null));
      boolean _while = _notEquals;
      while (_while) {
        {
          String _idBlock = curParent.toIdBlock();
          String _plus = (_idBlock + path);
          path = _plus;
          RCOnsitePosition _parent = curParent.getParent();
          curParent = _parent;
        }
        boolean _notEquals_1 = (!Objects.equal(curParent, null));
        _while = _notEquals_1;
      }
      _xblockexpression = (path);
    }
    return _xblockexpression;
  }
  
  public String fullPath() {
    String _xblockexpression = null;
    {
      boolean _equals = Objects.equal(this.parent, null);
      if (_equals) {
        return this.name;
      }
      String path = this.name;
      RCOnsitePosition curParent = this.parent;
      RCOnsitePosition _parent = curParent.getParent();
      boolean _notEquals = (!Objects.equal(_parent, null));
      boolean _while = _notEquals;
      while (_while) {
        {
          String _name = curParent.getName();
          String _plus = (_name + " ");
          String _plus_1 = (_plus + path);
          path = _plus_1;
          RCOnsitePosition _parent_1 = curParent.getParent();
          curParent = _parent_1;
        }
        RCOnsitePosition _parent_1 = curParent.getParent();
        boolean _notEquals_1 = (!Objects.equal(_parent_1, null));
        _while = _notEquals_1;
      }
      String _xifexpression = null;
      boolean _notEquals_1 = (!Objects.equal(this.phone, null));
      if (_notEquals_1) {
        String _plus = (path + "[");
        String _plus_1 = (_plus + this.phone);
        String _plus_2 = (_plus_1 + "]");
        _xifexpression = _plus_2;
      } else {
        _xifexpression = path;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public static RCOnsitePosition create(final RCOnsitePosition parent, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCOnsitePosition rCOnsitePosition = new com.fudanmed.platform.core.domain.impl.RCOnsitePositionImpl(
    	parent
    );
    objectFactory.create(rCOnsitePosition);
    return rCOnsitePosition;			
    
  }
  
  public RCOnsitePositionProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
