package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.domain.impl.RCWorkItemTaskImpl;
import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem;
import com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockRecordItemImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import edu.fudan.mylang.common.NumberExtensions;
import edu.fudan.mylang.pf.BaseModelObject;
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
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCWORKITEMSTOCKRECORD_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcworkitemstockrecord")
public abstract class RCWorkItemStockRecordImpl extends BaseModelObject implements RCWorkItemStockRecord {
  public RCWorkItemStockRecordImpl() {
    super();
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCWorkItemStockRecord setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  @JoinColumn(name = "operator_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee operator;
  
  public RCEmployee getOperator() {
    return this.operator;
  }
  
  public RCWorkItemStockRecord setOperator(final RCEmployee operator) {
    this.operator = operator;
    return this;			
    
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public RCWorkItemStockRecord setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCWorkItemStockRecord setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  @JoinColumn(name = "workItem_id")
  @ManyToOne(targetEntity = RCWorkItemTaskImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWorkItemTask workItem;
  
  public RCWorkItemTask getWorkItem() {
    return this.workItem;
  }
  
  public RCWorkItemStockRecord setWorkItem(final RCWorkItemTask workItem) {
    this.workItem = workItem;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCWorkItemStockRecordItemImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "record")
  private Collection<RCWorkItemStockRecordItem> items = new java.util.ArrayList<com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem>();;
  
  public Collection<RCWorkItemStockRecordItem> getItems() {
    return this.items;
  }
  
  public RCWorkItemStockRecordItem createAndAddtoItems() {
    getItems().size();
    com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem rCWorkItemStockRecordItem = new com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockRecordItemImpl(this);
    getObjectFactory().create(rCWorkItemStockRecordItem);
    getItems().add(rCWorkItemStockRecordItem);
    return rCWorkItemStockRecordItem;
    
  }
  
  public RCWorkItemStockRecord removeAllItems() {
    for(RCWorkItemStockRecordItem obj : this.items){
    	getObjectFactory().delete(obj);
    }
    this.items.clear();
    return this;	
    
  }
  
  public RCWorkItemStockRecord removeFromItems(final RCWorkItemStockRecordItem rCWorkItemStockRecordItem) {
    this.items.remove(rCWorkItemStockRecordItem);
    getObjectFactory().delete(rCWorkItemStockRecordItem);
    return this;
    
  }
  
  @JoinColumn(name = "sourceStore_id")
  @ManyToOne(targetEntity = RCWarehouseImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWarehouse sourceStore;
  
  public RCWarehouse getSourceStore() {
    return this.sourceStore;
  }
  
  public RCWorkItemStockRecord setSourceStore(final RCWarehouse sourceStore) {
    this.sourceStore = sourceStore;
    return this;			
    
  }
  
  private Boolean committed = Boolean.valueOf(false);
  
  public Boolean getCommitted() {
    return this.committed;
  }
  
  public RCWorkItemStockRecord setCommitted(final Boolean committed) {
    this.committed = committed;
    return this;			
    
  }
  
  public Double getTotalAmount() {
    final Function1<RCWorkItemStockRecordItem,Double> _function = new Function1<RCWorkItemStockRecordItem,Double>() {
        public Double apply(final RCWorkItemStockRecordItem it) {
          RCRecordItem _recordItem = it.getRecordItem();
          Double _totalAmount = _recordItem.getTotalAmount();
          return _totalAmount;
        }
      };
    Iterable<Double> _map = IterableExtensions.<RCWorkItemStockRecordItem, Double>map(this.items, _function);
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
  
  public RCWorkItemStockRecordProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
