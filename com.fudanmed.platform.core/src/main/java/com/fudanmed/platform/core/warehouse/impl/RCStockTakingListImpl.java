package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.common.RCSequenceService;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.RCStockTakingItem;
import com.fudanmed.platform.core.warehouse.RCStockTakingList;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecordItem;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseService;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingItemImpl;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingRecordImpl;
import com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IGenericQuery;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.beans.factory.BeanFactory;

@Entity
@DiscriminatorValue("RCSTOCKTAKINGLIST_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcstocktakinglist")
public class RCStockTakingListImpl extends BaseModelObject implements RCStockTakingList {
  public RCStockTakingListImpl() {
    super();
  }
  
  @JoinColumn(name = "warehouse_id")
  @ManyToOne(targetEntity = RCWarehouseImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWarehouse warehouse;
  
  public RCWarehouse getWarehouse() {
    return this.warehouse;
  }
  
  public RCStockTakingList setWarehouse(final RCWarehouse warehouse) {
    this.warehouse = warehouse;
    return this;			
    
  }
  
  @JoinColumn(name = "operator_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee operator;
  
  public RCEmployee getOperator() {
    return this.operator;
  }
  
  public RCStockTakingList setOperator(final RCEmployee operator) {
    this.operator = operator;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCStockTakingList setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public RCStockTakingList setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  @JoinColumn(name = "stockTakingRecord_id")
  @OneToOne(targetEntity = RCStockTakingRecordImpl.class, cascade = CascadeType.ALL)
  private RCStockTakingRecord stockTakingRecord;
  
  public RCStockTakingRecord getStockTakingRecord() {
    return this.stockTakingRecord;
  }
  
  public RCStockTakingList setStockTakingRecord(final RCStockTakingRecord stockTakingRecord) {
    this.stockTakingRecord = stockTakingRecord;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCStockTakingItemImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "takingList")
  private Collection<RCStockTakingItem> items = new java.util.ArrayList<com.fudanmed.platform.core.warehouse.RCStockTakingItem>();;
  
  public Collection<RCStockTakingItem> getItems() {
    return this.items;
  }
  
  public RCStockTakingItem createAndAddtoItems() {
    getItems().size();
    com.fudanmed.platform.core.warehouse.RCStockTakingItem rCStockTakingItem = new com.fudanmed.platform.core.warehouse.impl.RCStockTakingItemImpl(this);
    getObjectFactory().create(rCStockTakingItem);
    getItems().add(rCStockTakingItem);
    return rCStockTakingItem;
    
  }
  
  public RCStockTakingList removeAllItems() {
    for(RCStockTakingItem obj : this.items){
    	getObjectFactory().delete(obj);
    }
    this.items.clear();
    return this;	
    
  }
  
  public RCStockTakingList removeFromItems(final RCStockTakingItem rCStockTakingItem) {
    this.items.remove(rCStockTakingItem);
    getObjectFactory().delete(rCStockTakingItem);
    return this;
    
  }
  
  public void initializeStockTakingItems(final RCEmployee operator) {
    this.date = this.date;
    this.operator = operator;
    IGenericQuery<RCProductWarehouseStorageSummary> query=getObjectFactory().createGenericQuery(RCProductWarehouseStorageSummary.class,"select ps from com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageSummaryImpl as ps   where (ps.store = :warehouse) and  ps.active = 1      ").setParameter("warehouse",warehouse);
    Collection<RCProductWarehouseStorageSummary> _list = query.list();
    final Procedure1<RCProductWarehouseStorageSummary> _function = new Procedure1<RCProductWarehouseStorageSummary>() {
        public void apply(final RCProductWarehouseStorageSummary storage) {
          RCStockTakingItem _createAndAddtoItems = RCStockTakingListImpl.this.createAndAddtoItems();
          final Procedure1<RCStockTakingItem> _function = new Procedure1<RCStockTakingItem>() {
              public void apply(final RCStockTakingItem item) {
                RCProductSpecification _productSpec = storage.getProductSpec();
                item.setProductSpec(_productSpec);
                Integer _quantity = storage.getQuantity();
                item.setQuantity(_quantity);
                Integer _quantity_1 = storage.getQuantity();
                item.setRealQuantity(_quantity_1);
              }
            };
          ObjectExtensions.<RCStockTakingItem>operator_doubleArrow(_createAndAddtoItems, _function);
        }
      };
    IterableExtensions.<RCProductWarehouseStorageSummary>forEach(_list, _function);
  }
  
  public Boolean allDataCollected() {
    final Function1<RCStockTakingItem,Boolean> _function = new Function1<RCStockTakingItem,Boolean>() {
        public Boolean apply(final RCStockTakingItem it) {
          Integer _quantity = it.getQuantity();
          boolean _notEquals = (!Objects.equal(_quantity, null));
          return Boolean.valueOf(_notEquals);
        }
      };
    boolean _forall = IterableExtensions.<RCStockTakingItem>forall(this.items, _function);
    return Boolean.valueOf(_forall);
  }
  
  public Boolean getIsCommited() {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(this.stockTakingRecord, null));
    if (!_notEquals) {
      _and = false;
    } else {
      Boolean _committed = this.stockTakingRecord.getCommitted();
      _and = (_notEquals && (_committed).booleanValue());
    }
    return Boolean.valueOf(_and);
  }
  
  public RCStockTakingRecord createStockTakingRecord() {
    RCStockTakingRecord _xblockexpression = null;
    {
      BeanFactory _beanFactory = this.getBeanFactory();
      final RCWarehouseService ss = _beanFactory.<RCWarehouseService>getBean(RCWarehouseService.class);
      BeanFactory _beanFactory_1 = this.getBeanFactory();
      final RCSequenceService seq = _beanFactory_1.<RCSequenceService>getBean(RCSequenceService.class);RCStockTakingRecord rCStockTakingRecord=RCStockTakingRecordImpl.create(getObjectFactory());
      final Procedure1<RCStockTakingRecord> _function = new Procedure1<RCStockTakingRecord>() {
          public void apply(final RCStockTakingRecord takingRecord) {
            takingRecord.setSourceStore(RCStockTakingListImpl.this.warehouse);
            Date _day = DateUtil.today();
            takingRecord.setDate(_day);
            String _nextStockTakingSequence = seq.getNextStockTakingSequence();
            takingRecord.setSid(_nextStockTakingSequence);
            final Procedure1<RCStockTakingItem> _function = new Procedure1<RCStockTakingItem>() {
                public void apply(final RCStockTakingItem item) {
                  RCProductSpecification _productSpec = item.getProductSpec();
                  final RCProductWarehouseStorageSummary productSpedSummary = ss.findOrCreateSummaryData(RCStockTakingListImpl.this.warehouse, _productSpec);
                  Integer _quantity = productSpedSummary.getQuantity();
                  Integer _quantity_1 = item.getQuantity();
                  boolean _notEquals = (!Objects.equal(_quantity, _quantity_1));
                  if (_notEquals) {
                    Integer _quantity_2 = item.getQuantity();
                    Integer _quantity_3 = productSpedSummary.getQuantity();
                    final int balance = ((_quantity_2).intValue() - (_quantity_3).intValue());
                    boolean _lessThan = (balance < 0);
                    if (_lessThan) {
                      RCProductSpecification _productSpec_1 = item.getProductSpec();
                      int _minus = (-balance);
                      Collection<RCRecordItem> _outStockCalculate = RCStockTakingListImpl.this.warehouse.outStockCalculate(_productSpec_1, Integer.valueOf(_minus), Boolean.valueOf(false));
                      final Procedure1<RCRecordItem> _function = new Procedure1<RCRecordItem>() {
                          public void apply(final RCRecordItem resultItem) {
                            RCStockTakingRecordItem _createAndAddtoItems = takingRecord.createAndAddtoItems();
                            final Procedure1<RCStockTakingRecordItem> _function = new Procedure1<RCStockTakingRecordItem>() {
                                public void apply(final RCStockTakingRecordItem it) {
                                  RCRecordItem _recordItem = it.getRecordItem();
                                  RCProductEntry _productEntry = resultItem.getProductEntry();
                                  _recordItem.setProductEntry(_productEntry);
                                  RCRecordItem _recordItem_1 = it.getRecordItem();
                                  Integer _quantity = resultItem.getQuantity();
                                  int _minus = (-_quantity);
                                  _recordItem_1.setQuantity(Integer.valueOf(_minus));
                                }
                              };
                            ObjectExtensions.<RCStockTakingRecordItem>operator_doubleArrow(_createAndAddtoItems, _function);
                          }
                        };
                      IterableExtensions.<RCRecordItem>forEach(_outStockCalculate, _function);
                    } else {
                      RCStockTakingRecordItem _createAndAddtoItems = takingRecord.createAndAddtoItems();
                      final Procedure1<RCStockTakingRecordItem> _function_1 = new Procedure1<RCStockTakingRecordItem>() {
                          public void apply(final RCStockTakingRecordItem it) {
                            RCRecordItem _recordItem = it.getRecordItem();
                            RCProductSpecification _productSpec = item.getProductSpec();
                            RCProductWarehouseStorage _lastProductStorage = RCStockTakingListImpl.this.warehouse.getlastProductStorage(_productSpec);
                            RCProductEntry _productEntry = _lastProductStorage.getProductEntry();
                            _recordItem.setProductEntry(_productEntry);
                            RCRecordItem _recordItem_1 = it.getRecordItem();
                            _recordItem_1.setQuantity(Integer.valueOf(balance));
                          }
                        };
                      ObjectExtensions.<RCStockTakingRecordItem>operator_doubleArrow(_createAndAddtoItems, _function_1);
                    }
                  }
                }
              };
            IterableExtensions.<RCStockTakingItem>forEach(RCStockTakingListImpl.this.items, _function);
          }
        };
      RCStockTakingRecord _doubleArrow = ObjectExtensions.<RCStockTakingRecord>operator_doubleArrow(rCStockTakingRecord, _function);
      final Procedure1<RCStockTakingRecord> _function_1 = new Procedure1<RCStockTakingRecord>() {
          public void apply(final RCStockTakingRecord it) {
            RCStockTakingListImpl.this.stockTakingRecord = it;
          }
        };
      RCStockTakingRecord _doubleArrow_1 = ObjectExtensions.<RCStockTakingRecord>operator_doubleArrow(_doubleArrow, _function_1);
      _xblockexpression = (_doubleArrow_1);
    }
    return _xblockexpression;
  }
  
  public static RCStockTakingList create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCStockTakingList rCStockTakingList = new com.fudanmed.platform.core.warehouse.impl.RCStockTakingListImpl(
    );
    objectFactory.create(rCStockTakingList);
    return rCStockTakingList;			
    
  }
  
  public RCStockTakingListProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
