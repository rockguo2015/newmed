package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.common.RCWorkType;
import com.fudanmed.platform.core.common.impl.RCWorkTypeImpl;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeStatus;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.impl.RCOrganizationImpl;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.google.common.base.Objects;
import edu.fudan.langlab.domain.organization.impl.PartyImpl;
import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.domain.security.SecurityService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.statemachine.ModelObjectLogService;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.springframework.beans.factory.BeanFactory;

@Entity
@DiscriminatorValue("RCEMPLOYEE_TYPE")
public class RCEmployeeImpl extends PartyImpl implements RCEmployee {
  public RCEmployeeImpl() {
    super();
  }
  
  private RCEmployeeStatus Status;
  
  public RCEmployeeStatus getStatus() {
    return this.Status;
  }
  
  private ModelObjectLogService getModelObjectLogService() {
    return getBeanFactory().getBean(ModelObjectLogService.class);
  }
  
  private void _start() {
    
    this.isLeaveJob = Boolean.valueOf(false);
    Status=RCEmployeeStatus.onJob;
  }
  
  public void start() {
    if(Status==null){
    	_start();
    	getModelObjectLogService().createLog(this,"Status","Initialize");
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _leaveJob() {
    
    this.isLeaveJob = Boolean.valueOf(true);
    Status=RCEmployeeStatus.leaveJob;
  }
  
  public void leaveJob() {
    if(Status==RCEmployeeStatus.onJob){
    	_leaveJob();
    	getModelObjectLogService().createLog(this,"Status","leaveJob");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCEmployeeEventsManager.class).fireLeaveJob(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _returnJob() {
    
    this.isLeaveJob = Boolean.valueOf(false);
    Status=RCEmployeeStatus.onJob;
  }
  
  public void returnJob() {
    if(Status==RCEmployeeStatus.leaveJob){
    	_returnJob();
    	getModelObjectLogService().createLog(this,"Status","returnJob");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCEmployeeEventsManager.class).fireReturnJob(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  public Boolean isOnJob() {
    return com.fudanmed.platform.core.domain.RCEmployeeStatus.onJob==Status;
  }
  
  public Boolean isLeaveJob() {
    return com.fudanmed.platform.core.domain.RCEmployeeStatus.leaveJob==Status;
  }
  
  private String eid;
  
  public String getEid() {
    return this.eid;
  }
  
  public RCEmployee setEid(final String eid) {
    this.eid = eid;
    return this;			
    
  }
  
  private String mobil;
  
  public String getMobil() {
    return this.mobil;
  }
  
  public RCEmployee setMobil(final String mobil) {
    this.mobil = mobil;
    return this;			
    
  }
  
  private String tel;
  
  public String getTel() {
    return this.tel;
  }
  
  public RCEmployee setTel(final String tel) {
    this.tel = tel;
    return this;			
    
  }
  
  private String workTel;
  
  public String getWorkTel() {
    return this.workTel;
  }
  
  public RCEmployee setWorkTel(final String workTel) {
    this.workTel = workTel;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCEmployee setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  @ManyToMany(targetEntity = RCWorkTypeImpl.class)
  @JoinTable(name = "m2m_rcemployee_worktypes", joinColumns = @JoinColumn(name = "rcemployee_id") , inverseJoinColumns = @JoinColumn(name = "rCWorkType_inv_id") )
  private Collection<RCWorkType> workTypes = new java.util.ArrayList<com.fudanmed.platform.core.common.RCWorkType>();;
  
  public Collection<RCWorkType> getWorkTypes() {
    return this.workTypes;
  }
  
  public RCEmployee setWorkTypes(final Iterable<RCWorkType> workTypes) {
    removeAllWorkTypes();
    for(RCWorkType ca : workTypes){
    	addtoWorkTypes(ca);
    }
    return this;		
    
  }
  
  public RCEmployee addtoWorkTypes(final RCWorkType rCWorkType) {
    this.workTypes.add(rCWorkType);
    return this;
    
  }
  
  public RCEmployee removeAllWorkTypes() {
    this.workTypes.clear();
    return this;	
    
  }
  
  public RCEmployee removeFromWorkTypes(final RCWorkType rCWorkType) {
    this.workTypes.remove(rCWorkType);
    return this;
    
  }
  
  @JoinColumn(name = "organization_id")
  @ManyToOne(targetEntity = RCOrganizationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOrganization organization;
  
  public RCOrganization getOrganization() {
    return this.organization;
  }
  
  public RCEmployee setOrganization(final RCOrganization organization) {
    this.organization = organization;
    return this;			
    
  }
  
  private String cardNumber;
  
  public String getCardNumber() {
    return this.cardNumber;
  }
  
  public RCEmployee setCardNumber(final String cardNumber) {
    this.cardNumber = cardNumber;
    return this;			
    
  }
  
  private String orgPath;
  
  public String getOrgPath() {
    return this.orgPath;
  }
  
  public RCEmployee setOrgPath(final String orgPath) {
    this.orgPath = orgPath;
    return this;			
    
  }
  
  private Boolean isLeaveJob;
  
  public Boolean getIsLeaveJob() {
    return this.isLeaveJob;
  }
  
  public RCEmployee setIsLeaveJob(final Boolean isLeaveJob) {
    this.isLeaveJob = isLeaveJob;
    return this;			
    
  }
  
  public User asUser() {
    IGenericQuery<RCEmployeeUser> query=getObjectFactory().createGenericQuery(RCEmployeeUser.class,"select eu from com.fudanmed.platform.core.domain.impl.RCEmployeeUserImpl as eu   where (eu.employee = :this) and  eu.active = 1      ").setParameter("this",this);
    RCEmployeeUser _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
  
  public Collection<Role> getRoles() {
    BeanFactory _beanFactory = this.getBeanFactory();
    SecurityService _bean = _beanFactory.<SecurityService>getBean(SecurityService.class);
    User _asUser = this.asUser();
    Collection<Role> _allRoles4User = _bean.getAllRoles4User(_asUser);
    return _allRoles4User;
  }
  
  public void updateOrgPath() {
    String orgp = "";
    RCOrganization curOrg = this.organization;
    boolean _notEquals = (!Objects.equal(curOrg, null));
    boolean _while = _notEquals;
    while (_while) {
      {
        String _plus = (orgp + "[");
        Long _id = curOrg.getId();
        String _string = _id.toString();
        String _plus_1 = (_plus + _string);
        String _plus_2 = (_plus_1 + "]");
        orgp = _plus_2;
        RCOrganization _parent = curOrg.getParent();
        curOrg = _parent;
      }
      boolean _notEquals_1 = (!Objects.equal(curOrg, null));
      _while = _notEquals_1;
    }
    this.orgPath = orgp;
  }
  
  public static RCEmployee create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCEmployee rCEmployee = new com.fudanmed.platform.core.domain.impl.RCEmployeeImpl(
    );
    objectFactory.create(rCEmployee);
    return rCEmployee;			
    
  }
  
  public RCEmployeeProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
