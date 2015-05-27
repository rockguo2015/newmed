package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverOrganization;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.impl.RCOrganizationImpl;
import com.google.common.base.Objects;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLDELIVERORGANIZATION_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dldeliverorganization")
public class DLDeliverOrganizationImpl extends BaseModelObject implements DLDeliverOrganization {
  public DLDeliverOrganizationImpl() {
    super();
  }
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public DLDeliverOrganization setCode(final String code) {
    this.code = code;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public DLDeliverOrganization setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  @JoinColumn(name = "organization_id")
  @ManyToOne(targetEntity = RCOrganizationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOrganization organization;
  
  public RCOrganization getOrganization() {
    return this.organization;
  }
  
  public DLDeliverOrganization setOrganization(final RCOrganization organization) {
    this.organization = organization;
    return this;			
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public void update(final Procedure1<? super DLDeliverOrganization> updater) {
    updater.apply(this);
    this.checkValid();
  }
  
  public void checkValid() {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.code);
    boolean _not = (!_isNullOrEmpty);
    Validates.Assert(_not, "\u4EE3\u7801\u5FC5\u987B\u8F93\u5165");
    boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(this.name);
    boolean _not_1 = (!_isNullOrEmpty_1);
    Validates.Assert(_not_1, "\u540D\u79F0\u5FC5\u987B\u8F93\u5165");
    boolean _notEquals = (!Objects.equal(this.organization, null));
    Validates.Assert(_notEquals, "\u7EC4\u7EC7\u673A\u6784\u5FC5\u987B\u8F93\u5165");
    IGenericQuery<DLDeliverOrganization> query=getObjectFactory().createGenericQuery(DLDeliverOrganization.class,"select e from com.fudanmed.platform.core.deliver.impl.DLDeliverOrganizationImpl as e   where (e.organization = :organization) and  e.active = 1      ").setParameter("organization",organization);
    Collection<DLDeliverOrganization> _list = query.list();
    int _size = _list.size();
    boolean _equals = (_size == 1);
    Validates.Assert(_equals, "\u4E0D\u80FD\u91CD\u590D\u8BBE\u5B9A\u7EC4\u7EC7\u673A\u6784");
  }
  
  public static DLDeliverOrganization create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLDeliverOrganization dLDeliverOrganization = new com.fudanmed.platform.core.deliver.impl.DLDeliverOrganizationImpl(
    );
    objectFactory.create(dLDeliverOrganization);
    return dLDeliverOrganization;			
    
  }
  
  public DLDeliverOrganizationProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
