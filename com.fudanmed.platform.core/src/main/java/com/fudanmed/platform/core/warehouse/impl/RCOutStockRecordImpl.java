package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.common.RCOutStockType;
import com.fudanmed.platform.core.common.impl.RCOutStockTypeImpl;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.domain.impl.RCMaintenanceTeamImpl;
import com.fudanmed.platform.core.warehouse.RCOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCOutStockRecordItem;
import com.fudanmed.platform.core.warehouse.RCOutStockTransaction;
import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCOutStockRecordItemImpl;
import com.fudanmed.platform.core.warehouse.impl.RCOutStockTransactionImpl;
import com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
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
@DiscriminatorValue("RCOUTSTOCKRECORD_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcoutstockrecord")
public class RCOutStockRecordImpl extends BaseModelObject implements RCOutStockRecord {
  public RCOutStockRecordImpl() {
    super();
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCOutStockRecord setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  @JoinColumn(name = "operator_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee operator;
  
  public RCEmployee getOperator() {
    return this.operator;
  }
  
  public RCOutStockRecord setOperator(final RCEmployee operator) {
    this.operator = operator;
    return this;			
    
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public RCOutStockRecord setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCOutStockRecord setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  @JoinColumn(name = "team_id")
  @ManyToOne(targetEntity = RCMaintenanceTeamImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCMaintenanceTeam team;
  
  public RCMaintenanceTeam getTeam() {
    return this.team;
  }
  
  public RCOutStockRecord setTeam(final RCMaintenanceTeam team) {
    this.team = team;
    return this;			
    
  }
  
  @JoinColumn(name = "worker_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee worker;
  
  public RCEmployee getWorker() {
    return this.worker;
  }
  
  public RCOutStockRecord setWorker(final RCEmployee worker) {
    this.worker = worker;
    return this;			
    
  }
  
  @JoinColumn(name = "type_id")
  @ManyToOne(targetEntity = RCOutStockTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOutStockType type;
  
  public RCOutStockType getType() {
    return this.type;
  }
  
  public RCOutStockRecord setType(final RCOutStockType type) {
    this.type = type;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCOutStockRecordItemImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "record")
  private Collection<RCOutStockRecordItem> items = new java.util.ArrayList<com.fudanmed.platform.core.warehouse.RCOutStockRecordItem>();;
  
  public Collection<RCOutStockRecordItem> getItems() {
    return this.items;
  }
  
  public RCOutStockRecordItem createAndAddtoItems() {
    getItems().size();
    com.fudanmed.platform.core.warehouse.RCOutStockRecordItem rCOutStockRecordItem = new com.fudanmed.platform.core.warehouse.impl.RCOutStockRecordItemImpl(this);
    getObjectFactory().create(rCOutStockRecordItem);
    getItems().add(rCOutStockRecordItem);
    return rCOutStockRecordItem;
    
  }
  
  public RCOutStockRecord removeAllItems() {
    for(RCOutStockRecordItem obj : this.items){
    	getObjectFactory().delete(obj);
    }
    this.items.clear();
    return this;	
    
  }
  
  public RCOutStockRecord removeFromItems(final RCOutStockRecordItem rCOutStockRecordItem) {
    this.items.remove(rCOutStockRecordItem);
    getObjectFactory().delete(rCOutStockRecordItem);
    return this;
    
  }
  
  @JoinColumn(name = "sourceStore_id")
  @ManyToOne(targetEntity = RCWarehouseImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWarehouse sourceStore;
  
  public RCWarehouse getSourceStore() {
    return this.sourceStore;
  }
  
  public RCOutStockRecord setSourceStore(final RCWarehouse sourceStore) {
    this.sourceStore = sourceStore;
    return this;			
    
  }
  
  private Boolean committed = Boolean.valueOf(false);
  
  public Boolean getCommitted() {
    return this.committed;
  }
  
  public RCOutStockRecord setCommitted(final Boolean committed) {
    this.committed = committed;
    return this;			
    
  }
  
  public String getTypeName() {
    return "\u51FA\u5E93";
  }
  
  public Double getTotalAmount() {
    final Function1<RCOutStockRecordItem,Double> _function = new Function1<RCOutStockRecordItem,Double>() {
        public Double apply(final RCOutStockRecordItem it) {
          RCRecordItem _recordItem = it.getRecordItem();
          Double _totalAmount = _recordItem.getTotalAmount();
          return _totalAmount;
        }
      };
    Iterable<Double> _map = IterableExtensions.<RCOutStockRecordItem, Double>map(this.items, _function);
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
          RCProductSpecification _productSpec = summaryItem.getProductSpec();
          Integer _quantity = summaryItem.getQuantity();
          Collection<RCRecordItem> _outStockCalculate = RCOutStockRecordImpl.this.sourceStore.outStockCalculate(_productSpec, _quantity, Boolean.valueOf(false));
          final Procedure1<RCRecordItem> _function = new Procedure1<RCRecordItem>() {
              public void apply(final RCRecordItem resultItem) {
                RCOutStockRecordItem _createAndAddtoItems = RCOutStockRecordImpl.this.createAndAddtoItems();
                final Procedure1<RCOutStockRecordItem> _function = new Procedure1<RCOutStockRecordItem>() {
                    public void apply(final RCOutStockRecordItem it) {
                      RCRecordItem _recordItem = it.getRecordItem();
                      RCProductEntry _productEntry = resultItem.getProductEntry();
                      _recordItem.setProductEntry(_productEntry);
                      RCRecordItem _recordItem_1 = it.getRecordItem();
                      Integer _quantity = resultItem.getQuantity();
                      _recordItem_1.setQuantity(_quantity);
                    }
                  };
                ObjectExtensions.<RCOutStockRecordItem>operator_doubleArrow(_createAndAddtoItems, _function);
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
    final Procedure1<RCOutStockRecordItem> _function = new Procedure1<RCOutStockRecordItem>() {
        public void apply(final RCOutStockRecordItem item) {
          RCRecordItem _recordItem = item.getRecordItem();
          RCProductEntry _productEntry = _recordItem.getProductEntry();
          RCRecordItem _recordItem_1 = item.getRecordItem();
          Integer _quantity = _recordItem_1.getQuantity();
          int _minus = (-_quantity);
          final RCProductStorage sourceStorage = RCOutStockRecordImpl.this.sourceStore.inStock(_productEntry, Integer.valueOf(_minus));RCOutStockTransaction rCOutStockTransaction=RCOutStockTransactionImpl.create(sourceStorage,getObjectFactory());
          final Procedure1<RCOutStockTransaction> _function = new Procedure1<RCOutStockTransaction>() {
              public void apply(final RCOutStockTransaction it) {
                it.setOutStockRecord(RCOutStockRecordImpl.this);
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
          ObjectExtensions.<RCOutStockTransaction>operator_doubleArrow(rCOutStockTransaction, _function);
        }
      };
    IterableExtensions.<RCOutStockRecordItem>forEach(this.items, _function);
    this.committed = Boolean.valueOf(true);
  }
  
  public static RCOutStockRecord create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCOutStockRecord rCOutStockRecord = new com.fudanmed.platform.core.warehouse.impl.RCOutStockRecordImpl(
    );
    objectFactory.create(rCOutStockRecord);
    return rCOutStockRecord;			
    
  }
  
  public RCOutStockRecordProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
