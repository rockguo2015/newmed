package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCMeasureDeviceTypeImpl;
import com.fudanmed.platform.core.measure.impl.RCMeasureValueImpl;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.google.common.base.Objects;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCMEASUREDEVICE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcmeasuredevice")
public abstract class RCMeasureDeviceImpl extends BaseModelObject implements RCMeasureDevice {
  public RCMeasureDeviceImpl() {
    super();
  }
  
  @JoinColumn(name = "deviceType_id")
  @ManyToOne(targetEntity = RCMeasureDeviceTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCMeasureDeviceType deviceType;
  
  public RCMeasureDeviceType getDeviceType() {
    return this.deviceType;
  }
  
  public RCMeasureDevice setDeviceType(final RCMeasureDeviceType deviceType) {
    this.deviceType = deviceType;
    return this;			
    
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCMeasureDevice setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCMeasureDevice setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private String location;
  
  public String getLocation() {
    return this.location;
  }
  
  public RCMeasureDevice setLocation(final String location) {
    this.location = location;
    return this;			
    
  }
  
  @JoinColumn(name = "lastValue_id")
  @ManyToOne(targetEntity = RCMeasureValueImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCMeasureValue lastValue;
  
  public RCMeasureValue getLastValue() {
    return this.lastValue;
  }
  
  public RCMeasureDevice setLastValue(final RCMeasureValue lastValue) {
    this.lastValue = lastValue;
    return this;			
    
  }
  
  public RCMeasureValue createValue(final Date measureDate, final String measurePerson) {
    RCMeasureValue _xblockexpression = null;
    {
      boolean _notEquals = (!Objects.equal(this.lastValue, null));
      if (_notEquals) {
        long _time = measureDate.getTime();
        Date _measureDate = this.lastValue.getMeasureDate();
        long _time_1 = _measureDate.getTime();
        boolean _greaterEqualsThan = (_time >= _time_1);
        Validates.Assert(_greaterEqualsThan, "\u6284\u8868\u65F6\u95F4\u4E0D\u80FD\u65E9\u4E8E\u5DF2\u63D0\u4EA4\u7684\u8BB0\u5F55");
      }
      RCMeasureValue _doCreateValue = this.doCreateValue();
      final Procedure1<RCMeasureValue> _function = new Procedure1<RCMeasureValue>() {
          public void apply(final RCMeasureValue it) {
            it.setDevice(RCMeasureDeviceImpl.this);
            it.setMeasureDate(measureDate);
            it.setMeasurePerson(measurePerson);
            it.setLastValue(RCMeasureDeviceImpl.this.lastValue);
            RCMeasureDeviceImpl.this.lastValue = it;
          }
        };
      RCMeasureValue _doubleArrow = ObjectExtensions.<RCMeasureValue>operator_doubleArrow(_doCreateValue, _function);
      _xblockexpression = (_doubleArrow);
    }
    return _xblockexpression;
  }
  
  public void checkValid() {
    boolean _notEquals = (!Objects.equal(this.deviceType, null));
    Validates.Assert(_notEquals, "\u8BBE\u5907\u7C7B\u578B\u4E0D\u80FD\u4E3A\u7A7A");
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.sid);
    boolean _not = (!_isNullOrEmpty);
    Validates.Assert(_not, "\u8BBE\u5907\u7F16\u53F7\u4E0D\u80FD\u4E3A\u7A7A");
    IGenericQuery<Long> query=getObjectFactory().createGenericQuery(Long.class,"select count(*) from com.fudanmed.platform.core.measure.impl.RCMeasureDeviceImpl as e   where (e.sid = :sid) and  e.active = 1      ").setParameter("sid",sid);
    Long _uniqueResult = query.uniqueResult();
    boolean _equals = ((_uniqueResult).longValue() == 1);
    Validates.Assert(_equals, "\u8BBE\u5907\u7F16\u53F7\u91CD\u590D");
  }
  
  public RCMeasureDeviceProxy toProxy() {
    com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy proxy = new com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
