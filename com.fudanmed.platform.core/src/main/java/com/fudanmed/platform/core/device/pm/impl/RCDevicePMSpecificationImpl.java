package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.impl.RCDeviceImpl;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.RCDevicePMType;
import com.fudanmed.platform.core.device.pm.impl.RCDevicePMPlanImpl;
import com.fudanmed.platform.core.device.pm.impl.RCDevicePMTypeImpl;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.utils.DateUtil;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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

@Entity
@DiscriminatorValue("RCDEVICEPMSPECIFICATION_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcdevicepmspecification")
public class RCDevicePMSpecificationImpl extends BaseModelObject implements RCDevicePMSpecification {
  public RCDevicePMSpecificationImpl() {
    super();
  }
  
  @JoinColumn(name = "device_id")
  @ManyToOne(targetEntity = RCDeviceImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCDevice device;
  
  public RCDevice getDevice() {
    return this.device;
  }
  
  public RCDevicePMSpecification setDevice(final RCDevice device) {
    this.device = device;
    return this;			
    
  }
  
  @JoinColumn(name = "pmType_id")
  @ManyToOne(targetEntity = RCDevicePMTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCDevicePMType pmType;
  
  public RCDevicePMType getPmType() {
    return this.pmType;
  }
  
  public RCDevicePMSpecification setPmType(final RCDevicePMType pmType) {
    this.pmType = pmType;
    return this;			
    
  }
  
  @Column(length = 2048)
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public RCDevicePMSpecification setDescription(final String description) {
    this.description = description;
    return this;			
    
  }
  
  private Integer intervalInDays;
  
  public Integer getIntervalInDays() {
    return this.intervalInDays;
  }
  
  public RCDevicePMSpecification setIntervalInDays(final Integer intervalInDays) {
    this.intervalInDays = intervalInDays;
    return this;			
    
  }
  
  private Date lastPMPlanDate;
  
  public Date getLastPMPlanDate() {
    return this.lastPMPlanDate;
  }
  
  public RCDevicePMSpecification setLastPMPlanDate(final Date lastPMPlanDate) {
    this.lastPMPlanDate = lastPMPlanDate;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCDevicePMPlanImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "spec")
  private Collection<RCDevicePMPlan> plans = new java.util.ArrayList<com.fudanmed.platform.core.device.pm.RCDevicePMPlan>();;
  
  public Collection<RCDevicePMPlan> getPlans() {
    return this.plans;
  }
  
  public RCDevicePMPlan createAndAddtoPlans() {
    getPlans().size();
    com.fudanmed.platform.core.device.pm.RCDevicePMPlan rCDevicePMPlan = new com.fudanmed.platform.core.device.pm.impl.RCDevicePMPlanImpl(this);
    getObjectFactory().create(rCDevicePMPlan);
    getPlans().add(rCDevicePMPlan);
    return rCDevicePMPlan;
    
  }
  
  public RCDevicePMSpecification removeAllPlans() {
    for(RCDevicePMPlan obj : this.plans){
    	getObjectFactory().delete(obj);
    }
    this.plans.clear();
    return this;	
    
  }
  
  public RCDevicePMSpecification removeFromPlans(final RCDevicePMPlan rCDevicePMPlan) {
    this.plans.remove(rCDevicePMPlan);
    getObjectFactory().delete(rCDevicePMPlan);
    return this;
    
  }
  
  public void removePlan(final RCDevicePMPlan plan) {
    this.removeFromPlans(plan);
  }
  
  public RCDevicePMPlan createPlan(final Procedure1<? super RCDevicePMPlan> init) {
    RCDevicePMPlan _createAndAddtoPlans = this.createAndAddtoPlans();
    final Procedure1<RCDevicePMPlan> _function = new Procedure1<RCDevicePMPlan>() {
        public void apply(final RCDevicePMPlan it) {
          init.apply(it);
        }
      };
    RCDevicePMPlan _doubleArrow = ObjectExtensions.<RCDevicePMPlan>operator_doubleArrow(_createAndAddtoPlans, _function);
    return _doubleArrow;
  }
  
  /**
   * 从指定日期开始生成到指定年内的PM计划
   */
  public void initializePMPlanUptoYear(final Date startDate, final Integer year) {
    boolean yearOut = false;
    Date curDate = startDate;
    boolean _not = (!yearOut);
    boolean _while = _not;
    while (_while) {
      {
        final Date nextPMDate = DateUtil.addDays(curDate, (this.intervalInDays).intValue());
        int _year = nextPMDate.getYear();
        int _plus = (_year + 1900);
        boolean _lessEqualsThan = (_plus <= (year).intValue());
        if (_lessEqualsThan) {
          RCDevicePMPlan _createAndAddtoPlans = this.createAndAddtoPlans();
          final Procedure1<RCDevicePMPlan> _function = new Procedure1<RCDevicePMPlan>() {
              public void apply(final RCDevicePMPlan it) {
                it.setPlanDate(nextPMDate);
                it.start();
                RCDevicePMSpecificationImpl.this.lastPMPlanDate = nextPMDate;
              }
            };
          ObjectExtensions.<RCDevicePMPlan>operator_doubleArrow(_createAndAddtoPlans, _function);
          curDate = nextPMDate;
        } else {
          yearOut = true;
        }
      }
      boolean _not_1 = (!yearOut);
      _while = _not_1;
    }
  }
  
  public static RCDevicePMSpecification create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.pm.RCDevicePMSpecification rCDevicePMSpecification = new com.fudanmed.platform.core.device.pm.impl.RCDevicePMSpecificationImpl(
    );
    objectFactory.create(rCDevicePMSpecification);
    return rCDevicePMSpecification;			
    
  }
  
  public RCDevicePMSpecificationProxy toProxy() {
    com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy proxy = new com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
