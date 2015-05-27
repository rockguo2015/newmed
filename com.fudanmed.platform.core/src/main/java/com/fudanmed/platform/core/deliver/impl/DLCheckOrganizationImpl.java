package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.impl.RCOrganizationImpl;
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
@DiscriminatorValue("DLCHECKORGANIZATION_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dlcheckorganization")
public class DLCheckOrganizationImpl extends BaseModelObject implements DLCheckOrganization {
  public DLCheckOrganizationImpl() {
    super();
  }
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public DLCheckOrganization setCode(final String code) {
    this.code = code;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public DLCheckOrganization setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  @JoinColumn(name = "organization_id")
  @ManyToOne(targetEntity = RCOrganizationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOrganization organization;
  
  public RCOrganization getOrganization() {
    return this.organization;
  }
  
  public DLCheckOrganization setOrganization(final RCOrganization organization) {
    this.organization = organization;
    return this;			
    
  }
  
  private String simplePy;
  
  public String getSimplePy() {
    return this.simplePy;
  }
  
  public DLCheckOrganization setSimplePy(final String simplePy) {
    this.simplePy = simplePy;
    return this;			
    
  }
  
  public String getNameField() {
    return "name";
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public void update(final Procedure1<? super DLCheckOrganization> updater) {
    updater.apply(this);
    this.checkValid();
  }
  
  public void checkValid() {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.code);
    boolean _not = (!_isNullOrEmpty);
    Validates.Assert(_not, "\u7F16\u7801\u8F93\u5165");
    boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(this.name);
    boolean _not_1 = (!_isNullOrEmpty_1);
    Validates.Assert(_not_1, "\u540D\u79F0\u8F93\u5165");
    IGenericQuery<DLCheckOrganization> query=getObjectFactory().createGenericQuery(DLCheckOrganization.class,"select e from com.fudanmed.platform.core.deliver.impl.DLCheckOrganizationImpl as e   where (e.code = :code) and  e.active = 1      ").setParameter("code",code);
    Collection<DLCheckOrganization> _list = query.list();
    int _size = _list.size();
    boolean _equals = (_size == 1);
    Validates.Assert(_equals, "\u75C5\u533A\u7F16\u7801\u5FC5\u987B\u552F\u4E00");
  }
  
  public static DLCheckOrganization create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLCheckOrganization dLCheckOrganization = new com.fudanmed.platform.core.deliver.impl.DLCheckOrganizationImpl(
    );
    objectFactory.create(dLCheckOrganization);
    return dLCheckOrganization;			
    
  }
  
  public DLCheckOrganizationProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
