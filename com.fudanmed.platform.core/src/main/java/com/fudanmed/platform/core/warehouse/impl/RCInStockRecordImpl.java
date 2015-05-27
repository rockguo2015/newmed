package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.domain.impl.RCSupplierImpl;
import com.fudanmed.platform.core.warehouse.RCInStockRecord;
import com.fudanmed.platform.core.warehouse.RCInStockRecordItem;
import com.fudanmed.platform.core.warehouse.RCInStoreTransaction;
import com.fudanmed.platform.core.warehouse.RCInStoreType;
import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCInStockRecordItemImpl;
import com.fudanmed.platform.core.warehouse.impl.RCInStoreTransactionImpl;
import com.fudanmed.platform.core.warehouse.impl.RCInStoreTypeImpl;
import com.fudanmed.platform.core.warehouse.impl.RCProductEntryImpl;
import com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordProxy;
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
@DiscriminatorValue("RCINSTOCKRECORD_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcinstockrecord")
public class RCInStockRecordImpl extends BaseModelObject implements RCInStockRecord {
  public RCInStockRecordImpl() {
    super();
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCInStockRecord setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  @JoinColumn(name = "operator_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee operator;
  
  public RCEmployee getOperator() {
    return this.operator;
  }
  
  public RCInStockRecord setOperator(final RCEmployee operator) {
    this.operator = operator;
    return this;			
    
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public RCInStockRecord setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCInStockRecord setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  @JoinColumn(name = "store_id")
  @ManyToOne(targetEntity = RCWarehouseImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWarehouse store;
  
  public RCWarehouse getStore() {
    return this.store;
  }
  
  public RCInStockRecord setStore(final RCWarehouse store) {
    this.store = store;
    return this;			
    
  }
  
  @JoinColumn(name = "supplier_id")
  @ManyToOne(targetEntity = RCSupplierImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCSupplier supplier;
  
  public RCSupplier getSupplier() {
    return this.supplier;
  }
  
  public RCInStockRecord setSupplier(final RCSupplier supplier) {
    this.supplier = supplier;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCInStockRecordItemImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "inStockRecord")
  private Collection<RCInStockRecordItem> items = new java.util.ArrayList<com.fudanmed.platform.core.warehouse.RCInStockRecordItem>();;
  
  public Collection<RCInStockRecordItem> getItems() {
    return this.items;
  }
  
  public RCInStockRecordItem createAndAddtoItems() {
    getItems().size();
    com.fudanmed.platform.core.warehouse.RCInStockRecordItem rCInStockRecordItem = new com.fudanmed.platform.core.warehouse.impl.RCInStockRecordItemImpl(this);
    getObjectFactory().create(rCInStockRecordItem);
    getItems().add(rCInStockRecordItem);
    return rCInStockRecordItem;
    
  }
  
  public RCInStockRecord removeAllItems() {
    for(RCInStockRecordItem obj : this.items){
    	getObjectFactory().delete(obj);
    }
    this.items.clear();
    return this;	
    
  }
  
  public RCInStockRecord removeFromItems(final RCInStockRecordItem rCInStockRecordItem) {
    this.items.remove(rCInStockRecordItem);
    getObjectFactory().delete(rCInStockRecordItem);
    return this;
    
  }
  
  private Boolean committed = Boolean.valueOf(false);
  
  public Boolean getCommitted() {
    return this.committed;
  }
  
  public RCInStockRecord setCommitted(final Boolean committed) {
    this.committed = committed;
    return this;			
    
  }
  
  @JoinColumn(name = "inStoreType_id")
  @ManyToOne(targetEntity = RCInStoreTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCInStoreType inStoreType;
  
  public RCInStoreType getInStoreType() {
    return this.inStoreType;
  }
  
  public RCInStockRecord setInStoreType(final RCInStoreType inStoreType) {
    this.inStoreType = inStoreType;
    return this;			
    
  }
  
  private String invoiceNumber;
  
  public String getInvoiceNumber() {
    return this.invoiceNumber;
  }
  
  public RCInStockRecord setInvoiceNumber(final String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
    return this;			
    
  }
  
  private String deliverNumber;
  
  public String getDeliverNumber() {
    return this.deliverNumber;
  }
  
  public RCInStockRecord setDeliverNumber(final String deliverNumber) {
    this.deliverNumber = deliverNumber;
    return this;			
    
  }
  
  public void commit(final RCEmployee operator) {
    this.operator = operator;
    Date _now = DateUtil.now();
    this.date = _now;
    final Procedure1<RCInStockRecordItem> _function = new Procedure1<RCInStockRecordItem>() {
        public void apply(final RCInStockRecordItem item) {RCProductEntry rCProductEntry=RCProductEntryImpl.create(getObjectFactory());
          final Procedure1<RCProductEntry> _function = new Procedure1<RCProductEntry>() {
              public void apply(final RCProductEntry it) {
                String _sid = item.getSid();
                it.setSid(_sid);
                RCProductSpecification _productSpec = item.getProductSpec();
                it.setProductSpec(_productSpec);
                Double _price = item.getPrice();
                it.setPrice(_price);
                Integer _quantity = item.getQuantity();
                it.setQuantity(_quantity);
                it.setInStockRecord(RCInStockRecordImpl.this);
                Integer _quantity_1 = item.getQuantity();
                final RCProductStorage storage = RCInStockRecordImpl.this.store.inStock(it, _quantity_1);RCInStoreTransaction rCInStoreTransaction=RCInStoreTransactionImpl.create(storage,getObjectFactory());
                final Procedure1<RCInStoreTransaction> _function = new Procedure1<RCInStoreTransaction>() {
                    public void apply(final RCInStoreTransaction it) {
                      it.setInStoreRecord(RCInStockRecordImpl.this);
                      Integer _quantity = item.getQuantity();
                      it.setQuantity(_quantity);
                      Date _now = DateUtil.now();
                      it.setDate(_now);
                      it.setOperator(operator);
                      it.transactionCommitted();
                    }
                  };
                ObjectExtensions.<RCInStoreTransaction>operator_doubleArrow(rCInStoreTransaction, _function);
              }
            };
          ObjectExtensions.<RCProductEntry>operator_doubleArrow(rCProductEntry, _function);
        }
      };
    IterableExtensions.<RCInStockRecordItem>forEach(this.items, _function);
    this.committed = Boolean.valueOf(true);
  }
  
  public static RCInStockRecord create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCInStockRecord rCInStockRecord = new com.fudanmed.platform.core.warehouse.impl.RCInStockRecordImpl(
    );
    objectFactory.create(rCInStockRecord);
    return rCInStockRecord;			
    
  }
  
  public RCInStockRecordProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
