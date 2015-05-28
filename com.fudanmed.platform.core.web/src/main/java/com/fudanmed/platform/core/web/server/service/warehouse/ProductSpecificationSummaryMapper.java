package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationSummaryMapper")
public class ProductSpecificationSummaryMapper extends AbstractDataTypeMapper<UIProductSpecificationSummary,RCProductSpecificationSummary> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIProductSpecificationSummary from, final RCProductSpecificationSummary to) {
    to.setProductSpec(convertService.toValue(com.fudanmed.platform.core.warehouse.RCProductSpecification.class,from.getProductSpec()));
    to.setQuantity(convertService.toValue(java.lang.Integer.class,from.getQuantity()));
    to.getProductSpec().setTypeDesc(convertService.toValue(java.lang.String.class,from.getTypeDesc()));
    to.getProductSpec().setUnit(convertService.toValue(com.fudanmed.platform.core.warehouse.RCProduceSpecificationUnit.class,from.getUnit()));
    
  }
  
  public UIProductSpecificationSummary copyFromEntity(final UIProductSpecificationSummary result, final RCProductSpecificationSummary entity) {
    if(entity==null) return null;
    result.setProductSpec(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy.class,entity.getProductSpec()));
    result.setQuantity(convertService.toValue(java.lang.Integer.class,entity.getQuantity()));
    if(entity. getProductSpec()  != null )
    	result.setSid(convertService.toValue(java.lang.String.class,entity.getProductSpec().getSid()));
    if(entity. getProductSpec()  != null )
    	result.setTypeDesc(convertService.toValue(java.lang.String.class,entity.getProductSpec().getTypeDesc()));
    if(entity. getProductSpec()  != null )
    	result.setUnit(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy.class,entity.getProductSpec().getUnit()));
    return result;
    
  }
  
  public UIProductSpecificationSummary buildFrom(final RCProductSpecificationSummary entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary result = new com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIProductSpecificationSummary.class;
  }
  
  public Class<?> getEntityClass() {
    return RCProductSpecificationSummary.class;
  }
}
