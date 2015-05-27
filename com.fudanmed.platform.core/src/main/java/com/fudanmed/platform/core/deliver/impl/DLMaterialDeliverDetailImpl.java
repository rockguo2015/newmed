package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialType;
import com.fudanmed.platform.core.deliver.DLMaterialDeliver;
import com.fudanmed.platform.core.deliver.DLMaterialDeliverDetail;
import com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialTypeImpl;
import com.fudanmed.platform.core.deliver.impl.DLMaterialDeliverImpl;
import com.fudanmed.platform.core.deliver.proxy.DLMaterialDeliverDetailProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLMATERIALDELIVERDETAIL_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dlmaterialdeliverdetail")
public class DLMaterialDeliverDetailImpl extends BaseModelObject implements DLMaterialDeliverDetail {
  public DLMaterialDeliverDetailImpl() {
    super();
  }
  
  public DLMaterialDeliverDetailImpl(final DLMaterialDeliver materialDeliver) {
    super();
    this.materialDeliver = materialDeliver;
  }
  
  @JoinColumn(name = "materialType_id")
  @ManyToOne(targetEntity = DLDeliverMaterialTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLDeliverMaterialType materialType;
  
  public DLDeliverMaterialType getMaterialType() {
    return this.materialType;
  }
  
  public DLMaterialDeliverDetail setMaterialType(final DLDeliverMaterialType materialType) {
    this.materialType = materialType;
    return this;			
    
  }
  
  private Double quantity;
  
  public Double getQuantity() {
    return this.quantity;
  }
  
  public DLMaterialDeliverDetail setQuantity(final Double quantity) {
    this.quantity = quantity;
    return this;			
    
  }
  
  @JoinColumn(name = "materialDeliver_id")
  @ManyToOne(targetEntity = DLMaterialDeliverImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLMaterialDeliver materialDeliver;
  
  public DLMaterialDeliver getMaterialDeliver() {
    return this.materialDeliver;
  }
  
  public DLMaterialDeliverDetail setMaterialDeliver(final DLMaterialDeliver materialDeliver) {
    this.materialDeliver = materialDeliver;
    return this;			
    
  }
  
  public static DLMaterialDeliverDetail create(final DLMaterialDeliver materialDeliver, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLMaterialDeliverDetail dLMaterialDeliverDetail = new com.fudanmed.platform.core.deliver.impl.DLMaterialDeliverDetailImpl(
    	materialDeliver
    );
    objectFactory.create(dLMaterialDeliverDetail);
    return dLMaterialDeliverDetail;			
    
  }
  
  public DLMaterialDeliverDetailProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLMaterialDeliverDetailProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLMaterialDeliverDetailProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
