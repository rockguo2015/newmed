package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLRoutineProtocal;
import com.fudanmed.platform.core.deliver.DLRoutineTaskTemplate;
import com.fudanmed.platform.core.deliver.impl.DLRoutineTaskTemplateImpl;
import com.fudanmed.platform.core.deliver.proxy.DLRoutineProtocalProxy;
import edu.fudan.langlab.domain.common.DateRange;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLROUTINEPROTOCAL_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dlroutineprotocal")
public class DLRoutineProtocalImpl extends BaseModelObject implements DLRoutineProtocal {
  public DLRoutineProtocalImpl() {
    super();
  }
  
  @JoinColumn(name = "template_id")
  @ManyToOne(targetEntity = DLRoutineTaskTemplateImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLRoutineTaskTemplate template;
  
  public DLRoutineTaskTemplate getTemplate() {
    return this.template;
  }
  
  public DLRoutineProtocal setTemplate(final DLRoutineTaskTemplate template) {
    this.template = template;
    return this;			
    
  }
  
  private String title;
  
  public String getTitle() {
    return this.title;
  }
  
  public DLRoutineProtocal setTitle(final String title) {
    this.title = title;
    return this;			
    
  }
  
  @Embedded
  @AttributeOverrides(value = { @AttributeOverride(name = "startDate", column = @Column(name = "applyDateRange_startDate") ), @AttributeOverride(name = "finishDate", column = @Column(name = "applyDateRange_finishDate") ), @AttributeOverride(name = "workaround", column = @Column(name = "applyDateRange_workaround") ) } )
  @AssociationOverrides(value = { } )
  private DateRange applyDateRange = edu.fudan.langlab.domain.common.DateRange.create();
  
  public DateRange getApplyDateRange() {
    return this.applyDateRange;
  }
  
  public DLRoutineProtocal setApplyDateRange(final DateRange applyDateRange) {
    this.applyDateRange = applyDateRange;
    return this;			
    
  }
  
  public static DLRoutineProtocal create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLRoutineProtocal dLRoutineProtocal = new com.fudanmed.platform.core.deliver.impl.DLRoutineProtocalImpl(
    );
    objectFactory.create(dLRoutineProtocal);
    return dLRoutineProtocal;			
    
  }
  
  public DLRoutineProtocalProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLRoutineProtocalProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLRoutineProtocalProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
