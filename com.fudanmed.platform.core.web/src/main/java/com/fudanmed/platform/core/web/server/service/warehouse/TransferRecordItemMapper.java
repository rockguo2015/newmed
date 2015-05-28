package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.RCMaterialBrand;
import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.RCProduceSpecificationUnit;
import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.RCTransferRecord;
import com.fudanmed.platform.core.warehouse.RCTransferRecordItem;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductEntryProxy;
import com.fudanmed.platform.core.web.server.service.warehouse.TransferRecordItemValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordItem;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.TransferRecordItemMapper")
public class TransferRecordItemMapper extends AbstractEntityMapper<UITransferRecordItem,RCTransferRecordItem> {
  @Autowired
  private IConvertService convertService;
  
  public RCTransferRecordItem create(final UITransferRecordItem gwtEntity, final Object context) {
    RCTransferRecordItem _createAndAddtoItems = ((RCTransferRecord) context).createAndAddtoItems();
    return _createAndAddtoItems;
  }
  
  @Autowired
  private IObjectFactory entities;
  
  public RCTransferRecordItem loadEntityById(final Long id) {
    return entities.get(RCTransferRecordItem.class,id);
  }
  
  public RCTransferRecordItem create() {
    return entities.create(RCTransferRecordItem.class);
  }
  
  @Autowired
  private TransferRecordItemValidator validator;
  
  public void copyToEntity(final UITransferRecordItem from, final RCTransferRecordItem to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.getRecordItem().setQuantity(convertService.toValue(java.lang.Integer.class,from.getQuantity()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UITransferRecordItem _gwt, final RCTransferRecordItem _entity) {
    RCRecordItem _recordItem = _entity.getRecordItem();
    UIProductWarehouseStorage _storage = _gwt.getStorage();
    RCProductEntryProxy _productEntry = _storage.getProductEntry();
    Long _id = _productEntry.getId();
    RCProductEntry _get = this.entities.<RCProductEntry>get(RCProductEntry.class, _id);
    _recordItem.setProductEntry(_get);
  }
  
  public UITransferRecordItem copyFromEntity(final UITransferRecordItem result, final RCTransferRecordItem entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    if(entity. getRecordItem()  != null )
    	result.setQuantity(convertService.toValue(java.lang.Integer.class,entity.getRecordItem().getQuantity()));
    if(entity. getRecordItem()  != null )
    	result.setProductEntry(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProductEntryProxy.class,entity.getRecordItem().getProductEntry()));
    if(entity. getRecordItem()  != null &&entity. getRecordItem().getProductEntry()  != null )
    	result.setSid(convertService.toValue(java.lang.String.class,entity.getRecordItem().getProductEntry().getSid()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UITransferRecordItem buildFrom(final RCTransferRecordItem entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordItem result = new com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordItem();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UITransferRecordItem _gwt, final RCTransferRecordItem _entity) {
    RCRecordItem _recordItem = _entity.getRecordItem();
    RCProductEntry _productEntry = _recordItem.getProductEntry();
    RCProductSpecification _productSpec = _productEntry.getProductSpec();
    String _sid = _productSpec.getSid();
    _gwt.setProductSid(_sid);
    RCRecordItem _recordItem_1 = _entity.getRecordItem();
    RCProductEntry _productEntry_1 = _recordItem_1.getProductEntry();
    RCProductSpecification _productSpec_1 = _productEntry_1.getProductSpec();
    String _typeDesc = _productSpec_1.getTypeDesc();
    _gwt.setTypeDesc(_typeDesc);
    RCRecordItem _recordItem_2 = _entity.getRecordItem();
    RCProductEntry _productEntry_2 = _recordItem_2.getProductEntry();
    RCProductSpecification _productSpec_2 = _productEntry_2.getProductSpec();
    RCProduceSpecificationUnit _unit = _productSpec_2.getUnit();
    RCProduceSpecificationUnitProxy _proxy = _unit.toProxy();
    _gwt.setUnit(_proxy);
    RCRecordItem _recordItem_3 = _entity.getRecordItem();
    RCProductEntry _productEntry_3 = _recordItem_3.getProductEntry();
    RCProductSpecification _productSpec_3 = _productEntry_3.getProductSpec();
    String _materialId = _productSpec_3.getMaterialId();
    _gwt.setMaterialId(_materialId);
    RCRecordItem _recordItem_4 = _entity.getRecordItem();
    RCProductEntry _productEntry_4 = _recordItem_4.getProductEntry();
    Double _price = _productEntry_4.getPrice();
    _gwt.setPrice(_price);
    RCRecordItem _recordItem_5 = _entity.getRecordItem();
    RCProductEntry _productEntry_5 = _recordItem_5.getProductEntry();
    RCProductSpecification _productSpec_4 = _productEntry_5.getProductSpec();
    RCMaterialBrand _brandType = _productSpec_4.getBrandType();
    RCMaterialBrandProxy _proxy_1 = _brandType.toProxy();
    _gwt.setBrand(_proxy_1);
  }
  
  public Class<?> getUIClass() {
    return UITransferRecordItem.class;
  }
  
  public Class<?> getEntityClass() {
    return RCTransferRecordItem.class;
  }
}
