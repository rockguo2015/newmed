package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockTransaction;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockRecordImpl;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockTransactionImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemReturnStockRecordProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.utils.DateUtil;
import java.util.Collection;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCWORKITEMRETURNSTOCKRECORD_TYPE")
public class RCWorkItemReturnStockRecordImpl extends RCWorkItemStockRecordImpl implements RCWorkItemReturnStockRecord {
  public RCWorkItemReturnStockRecordImpl() {
    super();
  }
  
  public String getTypeName() {
    return "\u9000\u6599";
  }
  
  public void initItemsFromSummary(final Collection<RCProductSpecificationSummary> summaryItems) {
    this.removeAllItems();
    final Procedure1<RCProductSpecificationSummary> _function = new Procedure1<RCProductSpecificationSummary>() {
        public void apply(final RCProductSpecificationSummary summaryItem) {
          RCWorkItemTask _workItem = RCWorkItemReturnStockRecordImpl.this.getWorkItem();
          RCProductSpecification _productSpec = summaryItem.getProductSpec();
          Integer _quantity = summaryItem.getQuantity();
          Collection<RCRecordItem> _outStockCalculate = _workItem.outStockCalculate(_productSpec, _quantity, Boolean.valueOf(true));
          final Procedure1<RCRecordItem> _function = new Procedure1<RCRecordItem>() {
              public void apply(final RCRecordItem resultItem) {
                RCWorkItemStockRecordItem _createAndAddtoItems = RCWorkItemReturnStockRecordImpl.this.createAndAddtoItems();
                final Procedure1<RCWorkItemStockRecordItem> _function = new Procedure1<RCWorkItemStockRecordItem>() {
                    public void apply(final RCWorkItemStockRecordItem it) {
                      RCRecordItem _recordItem = it.getRecordItem();
                      RCProductEntry _productEntry = resultItem.getProductEntry();
                      _recordItem.setProductEntry(_productEntry);
                      RCRecordItem _recordItem_1 = it.getRecordItem();
                      Integer _quantity = resultItem.getQuantity();
                      _recordItem_1.setQuantity(_quantity);
                    }
                  };
                ObjectExtensions.<RCWorkItemStockRecordItem>operator_doubleArrow(_createAndAddtoItems, _function);
              }
            };
          IterableExtensions.<RCRecordItem>forEach(_outStockCalculate, _function);
        }
      };
    IterableExtensions.<RCProductSpecificationSummary>forEach(summaryItems, _function);
  }
  
  public void commit(final RCEmployee operator) {
    this.setOperator(operator);
    Date _now = DateUtil.now();
    this.setDate(_now);
    Collection<RCWorkItemStockRecordItem> _items = this.getItems();
    final Procedure1<RCWorkItemStockRecordItem> _function = new Procedure1<RCWorkItemStockRecordItem>() {
        public void apply(final RCWorkItemStockRecordItem item) {
          RCWorkItemTask _workItem = RCWorkItemReturnStockRecordImpl.this.getWorkItem();
          RCRecordItem _recordItem = item.getRecordItem();
          RCProductEntry _productEntry = _recordItem.getProductEntry();
          RCRecordItem _recordItem_1 = item.getRecordItem();
          Integer _quantity = _recordItem_1.getQuantity();
          int _minus = (-_quantity);
          final RCProductStorage targetStorage = _workItem.inStock(_productEntry, Integer.valueOf(_minus));RCWorkItemStockTransaction rCWorkItemStockTransaction=RCWorkItemStockTransactionImpl.create(targetStorage,getObjectFactory());
          final Procedure1<RCWorkItemStockTransaction> _function = new Procedure1<RCWorkItemStockTransaction>() {
              public void apply(final RCWorkItemStockTransaction it) {
                it.setRecord(RCWorkItemReturnStockRecordImpl.this);
                RCRecordItem _recordItem = item.getRecordItem();
                Integer _quantity = _recordItem.getQuantity();
                int _minus = (-_quantity);
                it.setQuantity(Integer.valueOf(_minus));
                Date _now = DateUtil.now();
                it.setDate(_now);
                it.setOperator(operator);
                it.transactionCommitted();
              }
            };
          ObjectExtensions.<RCWorkItemStockTransaction>operator_doubleArrow(rCWorkItemStockTransaction, _function);
          RCWarehouse _sourceStore = RCWorkItemReturnStockRecordImpl.this.getSourceStore();
          RCRecordItem _recordItem_2 = item.getRecordItem();
          RCProductEntry _productEntry_1 = _recordItem_2.getProductEntry();
          RCRecordItem _recordItem_3 = item.getRecordItem();
          Integer _quantity_1 = _recordItem_3.getQuantity();
          final RCProductStorage sourceStorage = _sourceStore.inStock(_productEntry_1, _quantity_1);RCWorkItemStockTransaction rCWorkItemStockTransaction_1=RCWorkItemStockTransactionImpl.create(sourceStorage,getObjectFactory());
          final Procedure1<RCWorkItemStockTransaction> _function_1 = new Procedure1<RCWorkItemStockTransaction>() {
              public void apply(final RCWorkItemStockTransaction it) {
                it.setRecord(RCWorkItemReturnStockRecordImpl.this);
                RCRecordItem _recordItem = item.getRecordItem();
                Integer _quantity = _recordItem.getQuantity();
                it.setQuantity(_quantity);
                Date _now = DateUtil.now();
                it.setDate(_now);
                it.setOperator(operator);
                it.transactionCommitted();
              }
            };
          ObjectExtensions.<RCWorkItemStockTransaction>operator_doubleArrow(rCWorkItemStockTransaction_1, _function_1);
        }
      };
    IterableExtensions.<RCWorkItemStockRecordItem>forEach(_items, _function);
    this.setCommitted(Boolean.valueOf(true));
  }
  
  public static RCWorkItemReturnStockRecord create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord rCWorkItemReturnStockRecord = new com.fudanmed.platform.core.warehouse.impl.RCWorkItemReturnStockRecordImpl(
    );
    objectFactory.create(rCWorkItemReturnStockRecord);
    return rCWorkItemReturnStockRecord;			
    
  }
  
  public RCWorkItemReturnStockRecordProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCWorkItemReturnStockRecordProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCWorkItemReturnStockRecordProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
