package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLTask;
import com.fudanmed.platform.core.deliver.DLTaskEvent;
import com.fudanmed.platform.core.deliver.DLTaskSource;
import com.fudanmed.platform.core.deliver.impl.DLTaskEventImpl;
import com.fudanmed.platform.core.deliver.impl.DLTaskSourceImpl;
import com.fudanmed.platform.core.deliver.proxy.DLTaskProxy;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.google.common.base.Objects;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.Date;
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
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLTASK_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dltask")
public class DLTaskImpl extends BaseModelObject implements DLTask {
  public DLTaskImpl() {
    super();
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public DLTask setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private Date createTime;
  
  public Date getCreateTime() {
    return this.createTime;
  }
  
  public DLTask setCreateTime(final Date createTime) {
    this.createTime = createTime;
    return this;			
    
  }
  
  @ManyToMany(targetEntity = RCEmployeeImpl.class)
  @JoinTable(name = "m2m_dltask_performers", joinColumns = @JoinColumn(name = "dltask_id") , inverseJoinColumns = @JoinColumn(name = "rCEmployee_inv_id") )
  private Collection<RCEmployee> performers = new java.util.ArrayList<com.fudanmed.platform.core.domain.RCEmployee>();;
  
  public Collection<RCEmployee> getPerformers() {
    return this.performers;
  }
  
  public DLTask setPerformers(final Iterable<RCEmployee> performers) {
    removeAllPerformers();
    for(RCEmployee ca : performers){
    	addtoPerformers(ca);
    }
    return this;		
    
  }
  
  public DLTask addtoPerformers(final RCEmployee rCEmployee) {
    this.performers.add(rCEmployee);
    return this;
    
  }
  
  public DLTask removeAllPerformers() {
    this.performers.clear();
    return this;	
    
  }
  
  public DLTask removeFromPerformers(final RCEmployee rCEmployee) {
    this.performers.remove(rCEmployee);
    return this;
    
  }
  
  @JoinColumn(name = "operator_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee operator;
  
  public RCEmployee getOperator() {
    return this.operator;
  }
  
  public DLTask setOperator(final RCEmployee operator) {
    this.operator = operator;
    return this;			
    
  }
  
  @JoinColumn(name = "taskSource_id")
  @OneToOne(targetEntity = DLTaskSourceImpl.class, cascade = CascadeType.ALL)
  private DLTaskSource taskSource;
  
  public DLTaskSource getTaskSource() {
    return this.taskSource;
  }
  
  public DLTask setTaskSource(final DLTaskSource taskSource) {
    this.taskSource = taskSource;
    return this;			
    
  }
  
  @OneToMany(targetEntity = DLTaskEventImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "task")
  private Collection<DLTaskEvent> events = new java.util.ArrayList<com.fudanmed.platform.core.deliver.DLTaskEvent>();;
  
  public Collection<DLTaskEvent> getEvents() {
    return this.events;
  }
  
  public DLTask removeAllEvents() {
    for(DLTaskEvent obj : this.events){
    	getObjectFactory().delete(obj);
    }
    this.events.clear();
    return this;	
    
  }
  
  public DLTask removeFromEvents(final DLTaskEvent dLTaskEvent) {
    this.events.remove(dLTaskEvent);
    getObjectFactory().delete(dLTaskEvent);
    return this;
    
  }
  
  public void chackValid() {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.sid);
    boolean _not = (!_isNullOrEmpty);
    Validates.Assert(_not, "\u4EFB\u52A1\u7F16\u53F7\u4E0D\u80FD\u4E3A\u7A7A");
    boolean _notEquals = (!Objects.equal(this.createTime, null));
    Validates.Assert(_notEquals, "\u751F\u6210\u65F6\u95F4\u4E0D\u80FD\u4E3A\u7A7A");
    boolean _notEquals_1 = (!Objects.equal(this.operator, null));
    Validates.Assert(_notEquals_1, "\u64CD\u4F5C\u5458\u4E0D\u80FD\u4E3A\u7A7A");
    boolean _notEquals_2 = (!Objects.equal(this.taskSource, null));
    Validates.Assert(_notEquals_2, "\u4EFB\u52A1\u6765\u6E90\u4E0D\u80FD\u4E3A\u7A7A");
  }
  
  public static DLTask create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLTask dLTask = new com.fudanmed.platform.core.deliver.impl.DLTaskImpl(
    );
    objectFactory.create(dLTask);
    return dLTask;			
    
  }
  
  public DLTaskProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLTaskProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLTaskProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
