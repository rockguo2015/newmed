package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecordItem;
import com.fudanmed.platform.core.warehouse.RCStockTakingTransaction;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingRecordItemImpl;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingTransactionImpl;
import com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import edu.fudan.mylang.common.NumberExtensions;
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
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCSTOCKTAKINGRECORD_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcstocktakingrecord")
public class RCStockTakingRecordImpl extends BaseModelObject implements RCStockTakingRecord {
  public RCStockTakingRecordImpl() {
    super();
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCStockTakingRecord setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  @JoinColumn(name = "operator_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee operator;
  
  public RCEmployee getOperator() {
    return this.operator;
  }
  
  public RCStockTakingRecord setOperator(final RCEmployee operator) {
    this.operator = operator;
    return this;			
    
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public RCStockTakingRecord setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCStockTakingRecord setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCStockTakingRecordItemImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "record")
  private Collection<RCStockTakingRecordItem> items = new java.util.ArrayList<com.fudanmed.platform.core.warehouse.RCStockTakingRecordItem>();;
  
  public Collection<RCStockTakingRecordItem> getItems() {
    return this.items;
  }
  
  public RCStockTakingRecordItem createAndAddtoItems() {
    getItems().size();
    com.fudanmed.platform.core.warehouse.RCStockTakingRecordItem rCStockTakingRecordItem = new com.fudanmed.platform.core.warehouse.impl.RCStockTakingRecordItemImpl(this);
    getObjectFactory().create(rCStockTakingRecordItem);
    getItems().add(rCStockTakingRecordItem);
    return rCStockTakingRecordItem;
    
  }
  
  public RCStockTakingRecord removeAllItems() {
    for(RCStockTakingRecordItem obj : this.items){
    	getObjectFactory().delete(obj);
    }
    this.items.clear();
    return this;	
    
  }
  
  public RCStockTakingRecord removeFromItems(final RCStockTakingRecordItem rCStockTakingRecordItem) {
    this.items.remove(rCStockTakingRecordItem);
    getObjectFactory().delete(rCStockTakingRecordItem);
    return this;
    
  }
  
  @JoinColumn(name = "sourceStore_id")
  @ManyToOne(targetEntity = RCWarehouseImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWarehouse sourceStore;
  
  public RCWarehouse getSourceStore() {
    return this.sourceStore;
  }
  
  public RCStockTakingRecord setSourceStore(final RCWarehouse sourceStore) {
    this.sourceStore = sourceStore;
    return this;			
    
  }
  
  private Boolean committed = Boolean.valueOf(false);
  
  public Boolean getCommitted() {
    return this.committed;
  }
  
  public RCStockTakingRecord setCommitted(final Boolean committed) {
    this.committed = committed;
    return this;			
    
  }
  
  public String getTypeName() {
    return "\u76D8\u70B9";
  }
  
  public Double getTotalAmount() {
    final Function1<RCStockTakingRecordItem,Double> _function = new Function1<RCStockTakingRecordItem,Double>() {
        public Double apply(final RCStockTakingRecordItem it) {
          RCRecordItem _recordItem = it.getRecordItem();
          Double _totalAmount = _recordItem.getTotalAmount();
          return _totalAmount;
        }
      };
    Iterable<Double> _map = IterableExtensions.<RCStockTakingRecordItem, Double>map(this.items, _function);
    final Function2<Double,Double,Double> _function_1 = new Function2<Double,Double,Double>() {
        public Double apply(final Double d1, final Double d2) {
          double _plus = DoubleExtensions.operator_plus(d1, d2);
          return Double.valueOf(_plus);
        }
      };
    Double _reduce = IterableExtensions.<Double>reduce(_map, _function_1);
    Double _nullsafe = NumberExtensions.nullsafe(_reduce);
    return _nullsafe;
  }
  
  public void initItemsFromSummary(final Collection<RCProductSpecificationSummary> summaryItems) {
    this.removeAllItems();
    final Procedure1<RCProductSpecificationSummary> _function = new Procedure1<RCProductSpecificationSummary>() {
        public void apply(final RCProductSpecificationSummary summaryItem) {
          Integer _quantity = summaryItem.getQuantity();
          boolean _lessThan = ((_quantity).intValue() < 0);
          if (_lessThan) {
            RCProductSpecification _productSpec = summaryItem.getProductSpec();
            Integer _quantity_1 = summaryItem.getQuantity();
            Collection<RCRecordItem> _outStockCalculate = RCStockTakingRecordImpl.this.sourceStore.outStockCalculate(_productSpec, _quantity_1, Boolean.valueOf(false));
            final Procedure1<RCRecordItem> _function = new Procedure1<RCRecordItem>() {
                public void apply(final RCRecordItem resultItem) {
                  RCStockTakingRecordItem _createAndAddtoItems = RCStockTakingRecordImpl.this.createAndAddtoItems();
                  final Procedure1<RCStockTakingRecordItem> _function = new Procedure1<RCStockTakingRecordItem>() {
                      public void apply(final RCStockTakingRecordItem it) {
                        RCRecordItem _recordItem = it.getRecordItem();
                        RCProductEntry _productEntry = resultItem.getProductEntry();
                        _recordItem.setProductEntry(_productEntry);
                        RCRecordItem _recordItem_1 = it.getRecordItem();
                        Integer _quantity = resultItem.getQuantity();
                        _recordItem_1.setQuantity(_quantity);
                      }
                    };
                  ObjectExtensions.<RCStockTakingRecordItem>operator_doubleArrow(_createAndAddtoItems, _function);
                }
              };
            IterableExtensions.<RCRecordItem>forEach(_outStockCalculate, _function);
          } else {
            RCStockTakingRecordItem _createAndAddtoItems = RCStockTakingRecordImpl.this.createAndAddtoItems();
            final Procedure1<RCStockTakingRecordItem> _function_1 = new Procedure1<RCStockTakingRecordItem>() {
                public void apply(final RCStockTakingRecordItem it) {
                  RCRecordItem _recordItem = it.getRecordItem();
                  RCProductSpecification _productSpec = summaryItem.getProductSpec();
                  Collection<RCProductStorage> _allProductStorage = RCStockTakingRecordImpl.this.sourceStore.getAllProductStorage(_productSpec);
                  RCProductStorage _last = IterableExtensions.<RCProductStorage>last(_allProductStorage);
                  RCProductEntry _productEntry = _last.getProductEntry();
                  _recordItem.setProductEntry(_productEntry);
                  RCRecordItem _recordItem_1 = it.getRecordItem();
                  Integer _quantity = summaryItem.getQuantity();
                  _recordItem_1.setQuantity(_quantity);
                }
              };
            ObjectExtensions.<RCStockTakingRecordItem>operator_doubleArrow(_createAndAddtoItems, _function_1);
          }
        }
      };
    IterableExtensions.<RCProductSpecificationSummary>forEach(summaryItems, _function);
  }
  
  public void commit(final RCEmployee operator) {
    this.operator = operator;
    Date _now = DateUtil.now();
    this.date = _now;
    final Procedure1<RCStockTakingRecordItem> _function = new Procedure1<RCStockTakingRecordItem>() {
        public void apply(final RCStockTakingRecordItem item) {
          RCRecordItem _recordItem = item.getRecordItem();
          RCProductEntry _productEntry = _recordItem.getProductEntry();
          RCRecordItem _recordItem_1 = item.getRecordItem();
          Integer _quantity = _recordItem_1.getQuantity();
          final RCProductStorage sourceStorage = RCStockTakingRecordImpl.this.sourceStore.inStock(_productEntry, _quantity);RCStockTakingTransaction rCStockTakingTransaction=RCStockTakingTransactionImpl.create(sourceStorage,getObjectFactory());
          final Procedure1<RCStockTakingTransaction> _function = new Procedure1<RCStockTakingTransaction>() {
              public void apply(final RCStockTakingTransaction it) {
                it.setStockTakingRecord(RCStockTakingRecordImpl.this);
                RCRecordItem _recordItem = item.getRecordItem();
                Integer _quantity = _recordItem.getQuantity();
                it.setQuantity(_quantity);
                Date _now = DateUtil.now();
                it.setDate(_now);
                it.setOperator(operator);
                it.transactionCommitted();
              }
            };
          ObjectExtensions.<RCStockTakingTransaction>operator_doubleArrow(rCStockTakingTransaction, _function);
        }
      };
    IterableExtensions.<RCStockTakingRecordItem>forEach(this.items, _function);
    this.committed = Boolean.valueOf(true);
  }
  
  public static RCStockTakingRecord create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCStockTakingRecord rCStockTakingRecord = new com.fudanmed.platform.core.warehouse.impl.RCStockTakingRecordImpl(
    );
    objectFactory.create(rCStockTakingRecord);
    return rCStockTakingRecord;			
    
  }
  
  public RCStockTakingRecordProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
