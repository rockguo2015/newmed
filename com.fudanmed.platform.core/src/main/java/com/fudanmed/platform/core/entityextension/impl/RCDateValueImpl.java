package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCDateValue;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.impl.RCPrimaryValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCDateValueProxy;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.IObjectFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCDATEVALUE_TYPE")
public class RCDateValueImpl extends RCPrimaryValueImpl implements RCDateValue {
  public RCDateValueImpl() {
    super();
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public RCDateValue setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  public String getEntityName() {
    String _xifexpression = null;
    boolean _equals = Objects.equal(this.date, null);
    if (_equals) {
      _xifexpression = "";
    } else {
      SimpleDateFormat _simpleDateFormat = new SimpleDateFormat(
        "yyyy-MM-dd");
      String _format = _simpleDateFormat.format(this.date);
      _xifexpression = _format;
    }
    return _xifexpression;
  }
  
  public void setValue(final Date date) {
    this.date = date;
  }
  
  public RCDateValue cloneIn(final RCExtensiableEntity rootOwner) {RCDateValue rCDateValue=RCDateValueImpl.create(getObjectFactory());
    final Procedure1<RCDateValue> _function = new Procedure1<RCDateValue>() {
        public void apply(final RCDateValue it) {
          it.setRootOwner(rootOwner);
          RCType _type = RCDateValueImpl.this.getType();
          it.setType(_type);
          it.setDate(RCDateValueImpl.this.date);
        }
      };
    RCDateValue _doubleArrow = ObjectExtensions.<RCDateValue>operator_doubleArrow(rCDateValue, _function);
    return _doubleArrow;
  }
  
  public static RCDateValue create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCDateValue rCDateValue = new com.fudanmed.platform.core.entityextension.impl.RCDateValueImpl(
    );
    objectFactory.create(rCDateValue);
    return rCDateValue;			
    
  }
  
  public RCDateValueProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCDateValueProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCDateValueProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
