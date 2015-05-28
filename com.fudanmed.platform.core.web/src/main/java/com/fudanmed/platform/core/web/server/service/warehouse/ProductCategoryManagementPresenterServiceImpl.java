package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductCategory;
import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductCategoryMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductTypeMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductType;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenterService")
@Transactional
public class ProductCategoryManagementPresenterServiceImpl extends BaseService implements ProductCategoryManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProductCategoryMapper mapper;
  
  @Autowired
  private ProductTypeMapper ProductTypeMapper;
  
  public Collection<UIProductCategory> loadAllProductCategory() throws SessionTimeOutException, ValidationException {
    Collection<RCProductCategory> _all = this.entities.<RCProductCategory>all(RCProductCategory.class);
    final Function1<RCProductCategory,UIProductCategory> _function = new Function1<RCProductCategory,UIProductCategory>() {
        public UIProductCategory apply(final RCProductCategory it) {
          UIProductCategory _transform = ProductCategoryManagementPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIProductCategory> _map = IterableExtensions.<RCProductCategory, UIProductCategory>map(_all, _function);
    Collection<UIProductCategory> _unlazy = IterableExtensions2.<UIProductCategory>unlazy(_map);
    return _unlazy;
  }
  
  public void delete(final RCProductCategoryProxy value) throws SessionTimeOutException, ValidationException {
    RCProductCategory _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
  
  public UIProductCategory getValue(final RCProductCategoryProxy org) throws SessionTimeOutException, ValidationException {
    RCProductCategory _resolved= null;
    if(org!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(org, entities);
    
    UIProductCategory _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public Collection<UIProductType> loadItems(final RCProductCategoryProxy value) throws SessionTimeOutException, ValidationException {
    RCProductCategory _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    Collection<RCProductType> _productTypes =  _resolved.getProductTypes();
    final Function1<RCProductType,UIProductType> _function = new Function1<RCProductType,UIProductType>() {
        public UIProductType apply(final RCProductType it) {
          UIProductType _transform = ProductCategoryManagementPresenterServiceImpl.this.ProductTypeMapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIProductType> _map = IterableExtensions.<RCProductType, UIProductType>map(_productTypes, _function);
    Collection<UIProductType> _unlazy = IterableExtensions2.<UIProductType>unlazy(_map);
    return _unlazy;
  }
  
  public void deleteChild(final RCProductTypeProxy child) throws SessionTimeOutException, ValidationException {
    RCProductType _resolved= null;
    if(child!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(child, entities);
    
    this.entities.delete( _resolved);
  }
}
