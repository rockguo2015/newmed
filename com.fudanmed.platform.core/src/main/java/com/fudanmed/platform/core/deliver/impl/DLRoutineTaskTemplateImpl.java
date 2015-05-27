package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLRoutineProtocal;
import com.fudanmed.platform.core.deliver.DLRoutineTaskTemplate;
import com.fudanmed.platform.core.deliver.impl.DLRoutineProtocalImpl;
import com.fudanmed.platform.core.deliver.proxy.DLRoutineTaskTemplateProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLROUTINETASKTEMPLATE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dlroutinetasktemplate")
public abstract class DLRoutineTaskTemplateImpl extends BaseModelObject implements DLRoutineTaskTemplate {
  public DLRoutineTaskTemplateImpl() {
    super();
  }
  
  @JoinColumn(name = "protocal_id")
  @OneToOne(targetEntity = DLRoutineProtocalImpl.class, cascade = CascadeType.ALL)
  private DLRoutineProtocal protocal;
  
  public DLRoutineProtocal getProtocal() {
    return this.protocal;
  }
  
  public DLRoutineTaskTemplate setProtocal(final DLRoutineProtocal protocal) {
    this.protocal = protocal;
    return this;			
    
  }
  
  public DLRoutineTaskTemplateProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLRoutineTaskTemplateProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLRoutineTaskTemplateProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
