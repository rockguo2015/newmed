package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.RCTransferRecord;
import com.fudanmed.platform.core.warehouse.RCTransferRecordItem;
import com.fudanmed.platform.core.warehouse.RCTransferTransaction;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCTransferRecordItemImpl;
import com.fudanmed.platform.core.warehouse.impl.RCTransferTransactionImpl;
import com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.utils.DateUtil;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCTRANSFERRECORD_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rctransferrecord")
public class RCTransferRecordImpl extends BaseModelObject implements RCTransferRecord {
  public RCTransferRecordImpl() {
    super();
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCTransferRecord setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  @JoinColumn(name = "operator_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee operator;
  
  public RCEmployee getOperator() {
    return this.operator;
  }
  
  public RCTransferRecord setOperator(final RCEmployee operator) {
    this.operator = operator;
    return this;			
    
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public RCTransferRecord setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCTransferRecord setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  @JoinColumn(name = "sourceStore_id")
  @ManyToOne(targetEntity = RCWarehouseImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWarehouse sourceStore;
  
  public RCWarehouse getSourceStore() {
    return this.sourceStore;
  }
  
  public RCTransferRecord setSourceStore(final RCWarehouse sourceStore) {
    this.sourceStore = sourceStore;
    return this;			
    
  }
  
  @JoinColumn(name = "targetStore_id")
  @ManyToOne(targetEntity = RCWarehouseImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWarehouse targetStore;
  
  public RCWarehouse getTargetStore() {
    return this.targetStore;
  }
  
  public RCTransferRecord setTargetStore(final RCWarehouse targetStore) {
    this.targetStore = targetStore;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCTransferRecordItemImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "transferRecord")
  private Collection<RCTransferRecordItem> items = new java.util.ArrayList<com.fudanmed.platform.core.warehouse.RCTransferRecordItem>();;
  
  public Collection<RCTransferRecordItem> getItems() {
    return this.items;
  }
  
  public RCTransferRecordItem createAndAddtoItems() {
    getItems().size();
    com.fudanmed.platform.core.warehouse.RCTransferRecordItem rCTransferRecordItem = new com.fudanmed.platform.core.warehouse.impl.RCTransferRecordItemImpl(this);
    getObjectFactory().create(rCTransferRecordItem);
    getItems().add(rCTransferRecordItem);
    return rCTransferRecordItem;
    
  }
  
  public RCTransferRecord removeAllItems() {
    for(RCTransferRecordItem obj : this.items){
    	getObjectFactory().delete(obj);
    }
    this.items.clear();
    return this;	
    
  }
  
  public RCTransferRecord removeFromItems(final RCTransferRecordItem rCTransferRecordItem) {
    this.items.remove(rCTransferRecordItem);
    getObjectFactory().delete(rCTransferRecordItem);
    return this;
    
  }
  
  private Boolean committed = Boolean.valueOf(false);
  
  public Boolean getCommitted() {
    return this.committed;
  }
  
  public RCTransferRecord setCommitted(final Boolean committed) {
    this.committed = committed;
    return this;			
    
  }
  
  public void initItemsFromSummary(final Collection<RCProductSpecificationSummary> summaryItems) {
    this.removeAllItems();
    final Procedure1<RCProductSpecificationSummary> _function = new Procedure1<RCProductSpecificationSummary>() {
        public void apply(final RCProductSpecificationSummary summaryItem) {
          RCProductSpecification _productSpec = summaryItem.getProductSpec();
          Integer _quantity = summaryItem.getQuantity();
          Collection<RCRecordItem> _outStockCalculate = RCTransferRecordImpl.this.sourceStore.outStockCalculate(_productSpec, _quantity, Boolean.valueOf(false));
          final Procedure1<RCRecordItem> _function = new Procedure1<RCRecordItem>() {
              public void apply(final RCRecordItem resultItem) {
                RCTransferRecordItem _createAndAddtoItems = RCTransferRecordImpl.this.createAndAddtoItems();
                final Procedure1<RCTransferRecordItem> _function = new Procedure1<RCTransferRecordItem>() {
                    public void apply(final RCTransferRecordItem it) {
                      RCRecordItem _recordItem = it.getRecordItem();
                      RCProductEntry _productEntry = resultItem.getProductEntry();
                      _recordItem.setProductEntry(_productEntry);
                      RCRecordItem _recordItem_1 = it.getRecordItem();
                      Integer _quantity = resultItem.getQuantity();
                      _recordItem_1.setQuantity(_quantity);
                    }
                  };
                ObjectExtensions.<RCTransferRecordItem>operator_doubleArrow(_createAndAddtoItems, _function);
              }
            };
          IterableExtensions.<RCRecordItem>forEach(_outStockCalculate, _function);
        }
      };
    IterableExtensions.<RCProductSpecificationSummary>forEach(summaryItems, _function);
  }
  
  public void commit(final RCEmployee operator) {
    this.operator = operator;
    Date _now = DateUtil.now();
    this.date = _now;
    final Procedure1<RCTransferRecordItem> _function = new Procedure1<RCTransferRecordItem>() {
        public void apply(final RCTransferRecordItem item) {
          RCRecordItem _recordItem = item.getRecordItem();
          RCProductEntry _productEntry = _recordItem.getProductEntry();
          RCRecordItem _recordItem_1 = item.getRecordItem();
          Integer _quantity = _recordItem_1.getQuantity();
          int _minus = (-_quantity);
          final RCProductStorage sourceStorage = RCTransferRecordImpl.this.sourceStore.inStock(_productEntry, Integer.valueOf(_minus));RCTransferTransaction rCTransferTransaction=RCTransferTransactionImpl.create(sourceStorage,getObjectFactory());
          final Procedure1<RCTransferTransaction> _function = new Procedure1<RCTransferTransaction>() {
              public void apply(final RCTransferTransaction it) {
                it.setTransferRecord(RCTransferRecordImpl.this);
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
          ObjectExtensions.<RCTransferTransaction>operator_doubleArrow(rCTransferTransaction, _function);
          RCRecordItem _recordItem_2 = item.getRecordItem();
          RCProductEntry _productEntry_1 = _recordItem_2.getProductEntry();
          RCRecordItem _recordItem_3 = item.getRecordItem();
          Integer _quantity_1 = _recordItem_3.getQuantity();
          final RCProductStorage targetStorage = RCTransferRecordImpl.this.targetStore.inStock(_productEntry_1, _quantity_1);RCTransferTransaction rCTransferTransaction_1=RCTransferTransactionImpl.create(targetStorage,getObjectFactory());
          final Procedure1<RCTransferTransaction> _function_1 = new Procedure1<RCTransferTransaction>() {
              public void apply(final RCTransferTransaction it) {
                it.setTransferRecord(RCTransferRecordImpl.this);
                RCRecordItem _recordItem = item.getRecordItem();
                Integer _quantity = _recordItem.getQuantity();
                it.setQuantity(_quantity);
                Date _now = DateUtil.now();
                it.setDate(_now);
                it.setOperator(operator);
                it.transactionCommitted();
              }
            };
          ObjectExtensions.<RCTransferTransaction>operator_doubleArrow(rCTransferTransaction_1, _function_1);
        }
      };
    IterableExtensions.<RCTransferRecordItem>forEach(this.items, _function);
    this.committed = Boolean.valueOf(true);
  }
  
  public static RCTransferRecord create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCTransferRecord rCTransferRecord = new com.fudanmed.platform.core.warehouse.impl.RCTransferRecordImpl(
    );
    objectFactory.create(rCTransferRecord);
    return rCTransferRecord;			
    
  }
  
  public RCTransferRecordProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
