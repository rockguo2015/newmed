package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationMapper")
public class ProductSpecificationMapper extends AbstractEntityMapper<UIProductSpecification,RCProductSpecification> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCProductSpecification loadEntityById(final Long id) {
    return entities.get(RCProductSpecification.class,id);
  }
  
  public RCProductSpecification create() {
    return entities.create(RCProductSpecification.class);
  }
  
  @Autowired
  private ProductSpecificationValidator validator;
  
  public void copyToEntity(final UIProductSpecification from, final RCProductSpecification to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setTypeDesc(convertService.toValue(java.lang.String.class,from.getTypeDesc()));
    to.setUnit(convertService.toValue(com.fudanmed.platform.core.warehouse.RCProduceSpecificationUnit.class,from.getUnit()));
    to.setProductType(convertService.toValue(com.fudanmed.platform.core.warehouse.RCProductType.class,from.getProductType()));
    to.setDefaultSupplier(convertService.toValue(com.fudanmed.platform.core.domain.RCSupplier.class,from.getDefaultSupplier()));
    to.setMaterialId(convertService.toValue(java.lang.String.class,from.getMaterialId()));
    to.setBrandType(convertService.toValue(com.fudanmed.platform.core.common.RCMaterialBrand.class,from.getBrandType()));
    to.setReferencePrice(convertService.toValue(java.lang.Double.class,from.getReferencePrice()));
    to.setShelfLife(convertService.toValue(java.lang.Integer.class,from.getShelfLife()));
    to.setLowerStorage(convertService.toValue(java.lang.Integer.class,from.getLowerStorage()));
    to.setUpperStorage(convertService.toValue(java.lang.Integer.class,from.getUpperStorage()));
    
  }
  
  public UIProductSpecification copyFromEntity(final UIProductSpecification result, final RCProductSpecification entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setTypeDesc(convertService.toValue(java.lang.String.class,entity.getTypeDesc()));
    result.setUnit(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy.class,entity.getUnit()));
    result.setProductType(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy.class,entity.getProductType()));
    result.setDefaultSupplier(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCSupplierProxy.class,entity.getDefaultSupplier()));
    result.setMaterialId(convertService.toValue(java.lang.String.class,entity.getMaterialId()));
    result.setBrandType(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy.class,entity.getBrandType()));
    result.setReferencePrice(convertService.toValue(java.lang.Double.class,entity.getReferencePrice()));
    result.setShelfLife(convertService.toValue(java.lang.Integer.class,entity.getShelfLife()));
    result.setLowerStorage(convertService.toValue(java.lang.Integer.class,entity.getLowerStorage()));
    result.setUpperStorage(convertService.toValue(java.lang.Integer.class,entity.getUpperStorage()));
    return result;
    
  }
  
  public UIProductSpecification buildFrom(final RCProductSpecification entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification result = new com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIProductSpecification.class;
  }
  
  public Class<?> getEntityClass() {
    return RCProductSpecification.class;
  }
}
