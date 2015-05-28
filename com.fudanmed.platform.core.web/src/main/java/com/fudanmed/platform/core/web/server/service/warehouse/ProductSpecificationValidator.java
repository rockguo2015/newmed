package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationDAO;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.extensions.ValidationExtensions;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationValidator")
public class ProductSpecificationValidator implements IValidator<UIProductSpecification> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCProductSpecificationDAO productSpecificationDAO;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean UniqueSid(final UIProductSpecification _entity) {
    final Function1<UIProductSpecification,RCProductSpecification> _function = new Function1<UIProductSpecification,RCProductSpecification>() {
        public RCProductSpecification apply(final UIProductSpecification it) {
          String _sid = _entity.getSid();
          RCProductSpecification _findBySid = ProductSpecificationValidator.this.productSpecificationDAO.findBySid(_sid);
          return _findBySid;
        }
      };
    boolean _isUnique = ValidationExtensions.<UIProductSpecification>isUnique(new Function0<UIProductSpecification>() {
      public UIProductSpecification apply() {
        return _entity;
      }
    }.apply(), _function);
    return Boolean.valueOf(_isUnique);
  }
  
  public Boolean UniqueMid(final UIProductSpecification _entity) {
    final Function1<UIProductSpecification,RCProductSpecification> _function = new Function1<UIProductSpecification,RCProductSpecification>() {
        public RCProductSpecification apply(final UIProductSpecification it) {
          String _materialId = _entity.getMaterialId();
          RCProductSpecification _findByMaterialId = ProductSpecificationValidator.this.productSpecificationDAO.findByMaterialId(_materialId);
          return _findByMaterialId;
        }
      };
    boolean _isUnique = ValidationExtensions.<UIProductSpecification>isUnique(new Function0<UIProductSpecification>() {
      public UIProductSpecification apply() {
        return _entity;
      }
    }.apply(), _function);
    return Boolean.valueOf(_isUnique);
  }
  
  public Collection<ValidationErrorItem> validate(final UIProductSpecification _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getSid()!=null && !UniqueSid(_entity)){
    	errors.add(new ValidationErrorItem("条码","物品条码已存在",com.google.common.collect.Lists.newArrayList("sid" )));
    }
    if(_entity.getMaterialId()!=null && !UniqueMid(_entity)){
    	errors.add(new ValidationErrorItem("物品编号","物品编号已存在",com.google.common.collect.Lists.newArrayList("materialId" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getSid());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("条码",rule.getMessage(),com.google.common.collect.Lists.newArrayList("sid" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getMaterialId());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("物品编号",rule.getMessage(),com.google.common.collect.Lists.newArrayList("materialId" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getBrandType());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("品牌",rule.getMessage(),com.google.common.collect.Lists.newArrayList("brandType" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getTypeDesc());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("规格型号",rule.getMessage(),com.google.common.collect.Lists.newArrayList("typeDesc" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("物品名称",rule.getMessage(),com.google.common.collect.Lists.newArrayList("name" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getProductType());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("物品类别",rule.getMessage(),com.google.common.collect.Lists.newArrayList("productType" )));
    }
    return errors;
    
  }
}
