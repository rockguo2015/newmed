package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.impl.RCOnsitePositionImpl;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.google.common.base.Objects;
import edu.fudan.langlab.domain.organization.impl.PartyImpl;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Entity
@DiscriminatorValue("RCORGANIZATION_TYPE")
public class RCOrganizationImpl extends PartyImpl implements RCOrganization {
  public RCOrganizationImpl() {
    super();
  }
  
  public RCOrganizationImpl(final RCOrganization parent) {
    super();
    this.parent = parent;
  }
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public RCOrganization setCode(final String code) {
    this.code = code;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCOrganizationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "parent")
  private Collection<RCOrganization> subOrganizations = new java.util.ArrayList<com.fudanmed.platform.core.domain.RCOrganization>();;
  
  public Collection<RCOrganization> getSubOrganizations() {
    return this.subOrganizations;
  }
  
  public RCOrganization createAndAddtoSubOrganizations() {
    getSubOrganizations().size();
    com.fudanmed.platform.core.domain.RCOrganization rCOrganization = new com.fudanmed.platform.core.domain.impl.RCOrganizationImpl(this);
    getObjectFactory().create(rCOrganization);
    getSubOrganizations().add(rCOrganization);
    return rCOrganization;
    
  }
  
  public RCOrganization removeAllSubOrganizations() {
    for(RCOrganization obj : this.subOrganizations){
    	getObjectFactory().delete(obj);
    }
    this.subOrganizations.clear();
    return this;	
    
  }
  
  public RCOrganization removeFromSubOrganizations(final RCOrganization rCOrganization) {
    this.subOrganizations.remove(rCOrganization);
    getObjectFactory().delete(rCOrganization);
    return this;
    
  }
  
  @JoinColumn(name = "parent_id")
  @ManyToOne(targetEntity = RCOrganizationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOrganization parent;
  
  public RCOrganization getParent() {
    return this.parent;
  }
  
  public RCOrganization setParent(final RCOrganization parent) {
    this.parent = parent;
    return this;			
    
  }
  
  @ManyToMany(targetEntity = RCOnsitePositionImpl.class)
  @JoinTable(name = "m2m_rcorganization_positions", joinColumns = @JoinColumn(name = "rcorganization_id") , inverseJoinColumns = @JoinColumn(name = "rCOnsitePosition_inv_id") )
  private Collection<RCOnsitePosition> positions = new java.util.ArrayList<com.fudanmed.platform.core.domain.RCOnsitePosition>();;
  
  public Collection<RCOnsitePosition> getPositions() {
    return this.positions;
  }
  
  public RCOrganization setPositions(final Iterable<RCOnsitePosition> positions) {
    removeAllPositions();
    for(RCOnsitePosition ca : positions){
    	addtoPositions(ca);
    }
    return this;		
    
  }
  
  public RCOrganization addtoPositions(final RCOnsitePosition rCOnsitePosition) {
    this.positions.add(rCOnsitePosition);
    return this;
    
  }
  
  public RCOrganization removeAllPositions() {
    this.positions.clear();
    return this;	
    
  }
  
  public RCOrganization removeFromPositions(final RCOnsitePosition rCOnsitePosition) {
    this.positions.remove(rCOnsitePosition);
    return this;
    
  }
  
  public Collection<RCEmployee> getAllEmployees() {
    IGenericQuery<RCEmployee> query=getObjectFactory().createGenericQuery(RCEmployee.class,"select e from com.fudanmed.platform.core.domain.impl.RCEmployeeImpl as e   where (e.organization = :this) and  e.active = 1      ").setParameter("this",this);
    Collection<RCEmployee> _list = query.list();
    return _list;
  }
  
  public String getEntityName() {
    String _fullPath = this.fullPath();
    return _fullPath;
  }
  
  public Collection<RCEmployee> getOnJobEmployees() {
    IGenericQuery<RCEmployee> query=getObjectFactory().createGenericQuery(RCEmployee.class,"select e from com.fudanmed.platform.core.domain.impl.RCEmployeeImpl as e   where (e.organization = :this) and  e.active = 1      ").setParameter("this",this);
    Collection<RCEmployee> _list = query.list();
    final Function1<RCEmployee,Boolean> _function = new Function1<RCEmployee,Boolean>() {
        public Boolean apply(final RCEmployee it) {
          Boolean _isLeaveJob = it.isLeaveJob();
          boolean _not = (!_isLeaveJob);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<RCEmployee> _filter = IterableExtensions.<RCEmployee>filter(_list, _function);
    Set<RCEmployee> _set = IterableExtensions.<RCEmployee>toSet(_filter);
    return _set;
  }
  
  public String fullPath() {
    String _xblockexpression = null;
    {
      boolean _equals = Objects.equal(this.parent, null);
      if (_equals) {
        return this.getName();
      }
      String path = this.getName();
      RCOrganization curParent = this.parent;
      RCOrganization _parent = curParent.getParent();
      boolean _notEquals = (!Objects.equal(_parent, null));
      boolean _while = _notEquals;
      while (_while) {
        {
          String _name = curParent.getName();
          String _plus = (_name + " ");
          String _plus_1 = (_plus + path);
          path = _plus_1;
          RCOrganization _parent_1 = curParent.getParent();
          curParent = _parent_1;
        }
        RCOrganization _parent_1 = curParent.getParent();
        boolean _notEquals_1 = (!Objects.equal(_parent_1, null));
        _while = _notEquals_1;
      }
      _xblockexpression = (path);
    }
    return _xblockexpression;
  }
  
  public static RCOrganization create(final RCOrganization parent, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCOrganization rCOrganization = new com.fudanmed.platform.core.domain.impl.RCOrganizationImpl(
    	parent
    );
    objectFactory.create(rCOrganization);
    return rCOrganization;			
    
  }
  
  public RCOrganizationProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
