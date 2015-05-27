package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCRCProductStorageContainer;
import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.proxy.RCRCProductStorageContainerProxy;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.common.NumberExtensions;
import edu.fudan.mylang.pf.BaseModelObject;
import java.util.Collection;
import java.util.List;
import javax.persistence.MappedSuperclass;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@MappedSuperclass
public abstract class RCRCProductStorageContainerImpl extends BaseModelObject implements RCRCProductStorageContainer {
  public RCRCProductStorageContainerImpl() {
    super();
  }
  
  /**
   * 按照批次先入先出的原则，计算从库存中取出指定数量的产品的集合（仅仅计算）
   */
  public Collection<RCRecordItem> outStockCalculate(final RCProductSpecification productSpec, final Integer quantity, final Boolean isReturnOp) {
    List<RCRecordItem> _xblockexpression = null;
    {
      final Collection<Integer> takes = CollectionLiterals.<Integer>newArrayList();
      Collection<RCProductStorage> _xifexpression = null;
      boolean _not = (!isReturnOp);
      if (_not) {
        Collection<RCProductStorage> _allProductStorage = this.getAllProductStorage(productSpec);
        _xifexpression = _allProductStorage;
      } else {
        Collection<RCProductStorage> _allProductStorage_1 = this.getAllProductStorage(productSpec);
        List<RCProductStorage> _list = IterableExtensions.<RCProductStorage>toList(_allProductStorage_1);
        List<RCProductStorage> _reverse = ListExtensions.<RCProductStorage>reverse(_list);
        _xifexpression = _reverse;
      }
      final Collection<RCProductStorage> productStorages = _xifexpression;
      final Function1<RCProductStorage,RCRecordItem> _function = new Function1<RCProductStorage,RCRecordItem>() {
          public RCRecordItem apply(final RCProductStorage storage) {
            RCRecordItem _xblockexpression = null;
            {
              final Function2<Integer,Integer,Integer> _function = new Function2<Integer,Integer,Integer>() {
                  public Integer apply(final Integer i1, final Integer i2) {
                    int _plus = ((i1).intValue() + (i2).intValue());
                    return Integer.valueOf(_plus);
                  }
                };
              Integer _reduce = IterableExtensions.<Integer>reduce(takes, _function);
              Integer _nullsafe = NumberExtensions.nullsafe(_reduce);
              int _minus = ((quantity).intValue() - (_nullsafe).intValue());
              Integer _quantity = storage.getQuantity();
              final int quantityToTake = Math.min(_minus, (_quantity).intValue());
              takes.add(Integer.valueOf(quantityToTake));
              RCRecordItem _rCRecordItem = new RCRecordItem();
              final Procedure1<RCRecordItem> _function_1 = new Procedure1<RCRecordItem>() {
                  public void apply(final RCRecordItem it) {
                    RCProductEntry _productEntry = storage.getProductEntry();
                    it.setProductEntry(_productEntry);
                    it.setQuantity(Integer.valueOf(quantityToTake));
                  }
                };
              RCRecordItem _doubleArrow = ObjectExtensions.<RCRecordItem>operator_doubleArrow(_rCRecordItem, _function_1);
              _xblockexpression = (_doubleArrow);
            }
            return _xblockexpression;
          }
        };
      Iterable<RCRecordItem> _map = IterableExtensions.<RCProductStorage, RCRecordItem>map(productStorages, _function);
      final Function1<RCRecordItem,Boolean> _function_1 = new Function1<RCRecordItem,Boolean>() {
          public Boolean apply(final RCRecordItem it) {
            Integer _quantity = it.getQuantity();
            boolean _notEquals = ((_quantity).intValue() != 0);
            return Boolean.valueOf(_notEquals);
          }
        };
      Iterable<RCRecordItem> _filter = IterableExtensions.<RCRecordItem>filter(_map, _function_1);
      List<RCRecordItem> _list_1 = IterableExtensions.<RCRecordItem>toList(_filter);
      _xblockexpression = (_list_1);
    }
    return _xblockexpression;
  }
  
  public RCProductStorage inStock(final RCProductEntry productEntry, final Integer quantity) {
    RCProductStorage _orCreateProductStorage = this.getOrCreateProductStorage(productEntry);
    final Procedure1<RCProductStorage> _function = new Procedure1<RCProductStorage>() {
        public void apply(final RCProductStorage it) {
          Integer _quantity = it.getQuantity();
          int _plus = ((_quantity).intValue() + (quantity).intValue());
          it.setQuantity(Integer.valueOf(_plus));
          Integer _quantity_1 = it.getQuantity();
          boolean _greaterEqualsThan = ((_quantity_1).intValue() >= 0);
          RCProductSpecification _productSpec = productEntry.getProductSpec();
          String _name = _productSpec.getName();
          String _plus_1 = ("\u64CD\u4F5C\u5C06\u5BFC\u81F4" + _name);
          String _plus_2 = (_plus_1 + "\u5E93\u5B58\u6570\u91CF\u5C0F\u4E8E0");
          Validates.Assert(_greaterEqualsThan, _plus_2);
        }
      };
    RCProductStorage _doubleArrow = ObjectExtensions.<RCProductStorage>operator_doubleArrow(_orCreateProductStorage, _function);
    return _doubleArrow;
  }
  
  public RCRCProductStorageContainerProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCRCProductStorageContainerProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCRCProductStorageContainerProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
