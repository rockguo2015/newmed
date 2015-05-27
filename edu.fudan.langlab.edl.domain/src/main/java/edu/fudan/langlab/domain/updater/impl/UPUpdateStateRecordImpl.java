package edu.fudan.langlab.domain.updater.impl;

import edu.fudan.langlab.domain.updater.UPUpdateStateRecord;
import edu.fudan.langlab.domain.updater.proxy.UPUpdateStateRecordProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("UPUPDATESTATERECORD_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "upupdatestaterecord")
public class UPUpdateStateRecordImpl extends BaseModelObject implements UPUpdateStateRecord {
  public UPUpdateStateRecordImpl() {
    super();
  }
  
  private String upgrader;
  
  public String getUpgrader() {
    return this.upgrader;
  }
  
  public UPUpdateStateRecord setUpgrader(final String upgrader) {
    this.upgrader = upgrader;
    return this;			
    
  }
  
  private String fromVersionTag;
  
  public String getFromVersionTag() {
    return this.fromVersionTag;
  }
  
  public UPUpdateStateRecord setFromVersionTag(final String fromVersionTag) {
    this.fromVersionTag = fromVersionTag;
    return this;			
    
  }
  
  private String updaterTag;
  
  public String getUpdaterTag() {
    return this.updaterTag;
  }
  
  public UPUpdateStateRecord setUpdaterTag(final String updaterTag) {
    this.updaterTag = updaterTag;
    return this;			
    
  }
  
  private Date updateDate;
  
  public Date getUpdateDate() {
    return this.updateDate;
  }
  
  public UPUpdateStateRecord setUpdateDate(final Date updateDate) {
    this.updateDate = updateDate;
    return this;			
    
  }
  
  public static UPUpdateStateRecord create(final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.updater.UPUpdateStateRecord uPUpdateStateRecord = new edu.fudan.langlab.domain.updater.impl.UPUpdateStateRecordImpl(
    );
    objectFactory.create(uPUpdateStateRecord);
    return uPUpdateStateRecord;			
    
  }
  
  public UPUpdateStateRecordProxy toProxy() {
    edu.fudan.langlab.domain.updater.proxy.UPUpdateStateRecordProxy proxy = new edu.fudan.langlab.domain.updater.proxy.UPUpdateStateRecordProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
