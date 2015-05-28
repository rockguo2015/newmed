package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummaryCriteria;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseDAO;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummaryCriteria;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductWarehouseStorageSummaryCriteriaMapper")
public class ProductWarehouseStorageSummaryCriteriaMapper extends AbstractDataTypeMapper<UIProductWarehouseStorageSummaryCriteria,RCProductWarehouseStorageSummaryCriteria> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCWarehouseDAO warehouseDAO;
  
  @Autowired
  private ProductSpecificationMapper __ProductSpecificationMapper__;
  
  public void copyToEntity(final UIProductWarehouseStorageSummaryCriteria from, final RCProductWarehouseStorageSummaryCriteria to) {
    to.setStore(convertService.toValue(com.fudanmed.platform.core.warehouse.RCWarehouse.class,from.getStore()));
    to.setProductType(convertService.toValue(com.fudanmed.platform.core.warehouse.RCProductType.class,from.getProductType()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIProductWarehouseStorageSummaryCriteria _gwt, final RCProductWarehouseStorageSummaryCriteria _entity) {
    UIProductSpecification _productSpec = _gwt.getProductSpec();
    boolean _notEquals = (!Objects.equal(_productSpec, null));
    if (_notEquals) {
      UIProductSpecification _productSpec_1 = _gwt.getProductSpec();
      Long _id = _productSpec_1.getId();
      RCProductSpecification _get = this.entities.<RCProductSpecification>get(RCProductSpecification.class, _id);
      _entity.setProductSpec(_get);
    }
    Collection<RCWarehouse> _findManagedWarehouse = this.warehouseDAO.findManagedWarehouse();
    final Function1<RCWarehouse,Long> _function = new Function1<RCWarehouse,Long>() {
        public Long apply(final RCWarehouse it) {
          Long _id = it.getId();
          return _id;
        }
      };
    Iterable<Long> _map = IterableExtensions.<RCWarehouse, Long>map(_findManagedWarehouse, _function);
    Collection<Long> _unlazy = IterableExtensions2.<Long>unlazy(_map);
    _entity.setStores(_unlazy);
  }
  
  public UIProductWarehouseStorageSummaryCriteria copyFromEntity(final UIProductWarehouseStorageSummaryCriteria result, final RCProductWarehouseStorageSummaryCriteria entity) {
    if(entity==null) return null;
    result.setStore(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy.class,entity.getStore()));
    result.setProductSpec(__ProductSpecificationMapper__.apply(entity.getProductSpec()));
    result.setProductType(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy.class,entity.getProductType()));
    return result;
    
  }
  
  public UIProductWarehouseStorageSummaryCriteria buildFrom(final RCProductWarehouseStorageSummaryCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummaryCriteria result = new com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummaryCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIProductWarehouseStorageSummaryCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCProductWarehouseStorageSummaryCriteria.class;
  }
}
