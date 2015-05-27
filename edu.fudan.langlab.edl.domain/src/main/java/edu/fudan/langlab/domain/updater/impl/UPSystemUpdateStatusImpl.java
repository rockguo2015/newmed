package edu.fudan.langlab.domain.updater.impl;

import edu.fudan.langlab.domain.updater.UPSystemUpdateStatus;
import edu.fudan.langlab.domain.updater.proxy.UPSystemUpdateStatusProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("UPSYSTEMUPDATESTATUS_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "upsystemupdatestatus")
public class UPSystemUpdateStatusImpl extends BaseModelObject implements UPSystemUpdateStatus {
  public UPSystemUpdateStatusImpl() {
    super();
  }
  
  private String curVersion;
  
  public String getCurVersion() {
    return this.curVersion;
  }
  
  public UPSystemUpdateStatus setCurVersion(final String curVersion) {
    this.curVersion = curVersion;
    return this;			
    
  }
  
  public static UPSystemUpdateStatus create(final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.updater.UPSystemUpdateStatus uPSystemUpdateStatus = new edu.fudan.langlab.domain.updater.impl.UPSystemUpdateStatusImpl(
    );
    objectFactory.create(uPSystemUpdateStatus);
    return uPSystemUpdateStatus;			
    
  }
  
  public UPSystemUpdateStatusProxy toProxy() {
    edu.fudan.langlab.domain.updater.proxy.UPSystemUpdateStatusProxy proxy = new edu.fudan.langlab.domain.updater.proxy.UPSystemUpdateStatusProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
