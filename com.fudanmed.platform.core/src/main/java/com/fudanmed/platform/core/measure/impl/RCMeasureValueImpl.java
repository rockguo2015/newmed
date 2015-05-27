package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCMeasureDeviceImpl;
import com.fudanmed.platform.core.measure.proxy.RCMeasureValueProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCMEASUREVALUE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcmeasurevalue")
public abstract class RCMeasureValueImpl extends BaseModelObject implements RCMeasureValue {
  public RCMeasureValueImpl() {
    super();
  }
  
  @JoinColumn(name = "device_id")
  @ManyToOne(targetEntity = RCMeasureDeviceImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCMeasureDevice device;
  
  public RCMeasureDevice getDevice() {
    return this.device;
  }
  
  public RCMeasureValue setDevice(final RCMeasureDevice device) {
    this.device = device;
    return this;			
    
  }
  
  private Date measureDate;
  
  public Date getMeasureDate() {
    return this.measureDate;
  }
  
  public RCMeasureValue setMeasureDate(final Date measureDate) {
    this.measureDate = measureDate;
    return this;			
    
  }
  
  private String measurePerson;
  
  public String getMeasurePerson() {
    return this.measurePerson;
  }
  
  public RCMeasureValue setMeasurePerson(final String measurePerson) {
    this.measurePerson = measurePerson;
    return this;			
    
  }
  
  @JoinColumn(name = "lastValue_id")
  @ManyToOne(targetEntity = RCMeasureValueImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCMeasureValue lastValue;
  
  public RCMeasureValue getLastValue() {
    return this.lastValue;
  }
  
  public RCMeasureValue setLastValue(final RCMeasureValue lastValue) {
    this.lastValue = lastValue;
    return this;			
    
  }
  
  public RCMeasureValueProxy toProxy() {
    com.fudanmed.platform.core.measure.proxy.RCMeasureValueProxy proxy = new com.fudanmed.platform.core.measure.proxy.RCMeasureValueProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
