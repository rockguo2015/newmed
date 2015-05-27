package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.impl.RCOnsitePositionImpl;
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
@DiscriminatorValue("DLINHOSPITALLOCATION_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dlinhospitallocation")
public class DLInHospitalLocationImpl extends BaseModelObject implements DLInHospitalLocation {
  public DLInHospitalLocationImpl() {
    super();
  }
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public DLInHospitalLocation setCode(final String code) {
    this.code = code;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public DLInHospitalLocation setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  @JoinColumn(name = "location_id")
  @ManyToOne(targetEntity = RCOnsitePositionImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOnsitePosition location;
  
  public RCOnsitePosition getLocation() {
    return this.location;
  }
  
  public DLInHospitalLocation setLocation(final RCOnsitePosition location) {
    this.location = location;
    return this;			
    
  }
  
  private String simplePy;
  
  public String getSimplePy() {
    return this.simplePy;
  }
  
  public DLInHospitalLocation setSimplePy(final String simplePy) {
    this.simplePy = simplePy;
    return this;			
    
  }
  
  public String getNameField() {
    return "name";
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public void update(final Procedure1<? super DLInHospitalLocation> updater) {
    updater.apply(this);
    this.checkValid();
  }
  
  public void checkValid() {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.code);
    boolean _not = (!_isNullOrEmpty);
    Validates.Assert(_not, "\u7F16\u7801\u5FC5\u987B\u8BBE\u7F6E");
    boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(this.name);
    boolean _not_1 = (!_isNullOrEmpty_1);
    Validates.Assert(_not_1, "\u540D\u79F0\u5FC5\u987B\u8BBE\u7F6E");
    boolean _notEquals = (!Objects.equal(this.location, null));
    Validates.Assert(_notEquals, "\u4F4D\u7F6E\u5FC5\u987B\u8BBE\u7F6E");
    IGenericQuery<DLInHospitalLocation> query=getObjectFactory().createGenericQuery(DLInHospitalLocation.class,"select e from com.fudanmed.platform.core.deliver.impl.DLInHospitalLocationImpl as e   where (e.code = :code) and  e.active = 1      ").setParameter("code",code);
    Collection<DLInHospitalLocation> _list = query.list();
    int _size = _list.size();
    boolean _equals = (_size == 1);
    Validates.Assert(_equals, "\u75C5\u533A\u7F16\u7801\u5FC5\u987B\u552F\u4E00");
  }
  
  public static DLInHospitalLocation create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLInHospitalLocation dLInHospitalLocation = new com.fudanmed.platform.core.deliver.impl.DLInHospitalLocationImpl(
    );
    objectFactory.create(dLInHospitalLocation);
    return dLInHospitalLocation;			
    
  }
  
  public DLInHospitalLocationProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
