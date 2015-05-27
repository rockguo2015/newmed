package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshot;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshotDAO;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.impl.RCProductStorageImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductStoreTransactionProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.utils.DateUtil;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.beans.factory.BeanFactory;

@Entity
@DiscriminatorValue("RCPRODUCTSTORETRANSACTION_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcproductstoretransaction")
public abstract class RCProductStoreTransactionImpl extends BaseModelObject implements RCProductStoreTransaction {
  public RCProductStoreTransactionImpl() {
    super();
  }
  
  public RCProductStoreTransactionImpl(final RCProductStorage productStorage) {
    super();
    this.productStorage = productStorage;
  }
  
  @JoinColumn(name = "productStorage_id")
  @ManyToOne(targetEntity = RCProductStorageImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCProductStorage productStorage;
  
  public RCProductStorage getProductStorage() {
    return this.productStorage;
  }
  
  public RCProductStoreTransaction setProductStorage(final RCProductStorage productStorage) {
    this.productStorage = productStorage;
    return this;			
    
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public RCProductStoreTransaction setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  private Integer quantity;
  
  public Integer getQuantity() {
    return this.quantity;
  }
  
  public RCProductStoreTransaction setQuantity(final Integer quantity) {
    this.quantity = quantity;
    return this;			
    
  }
  
  @JoinColumn(name = "operator_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee operator;
  
  public RCEmployee getOperator() {
    return this.operator;
  }
  
  public RCProductStoreTransaction setOperator(final RCEmployee operator) {
    this.operator = operator;
    return this;			
    
  }
  
  public void transactionCommitted(final Procedure3<? super RCProductSummarySnapshot,? super Integer,? super Double> init) {
    final RCProductStorage productStorage = this.productStorage;
    boolean _matched = false;
    if (!_matched) {
      if (productStorage instanceof RCProductWarehouseStorage) {
        final RCProductWarehouseStorage _rCProductWarehouseStorage = (RCProductWarehouseStorage)productStorage;
        _matched=true;
        BeanFactory _beanFactory = this.getBeanFactory();
        RCProductSummarySnapshotDAO _bean = _beanFactory.<RCProductSummarySnapshotDAO>getBean(RCProductSummarySnapshotDAO.class);
        Date _trimDate = DateUtil.trimDate(this.date);
        RCProductWarehouseStorageSummary _summary = _rCProductWarehouseStorage.getSummary();
        final Procedure1<RCProductSummarySnapshot> _function = new Procedure1<RCProductSummarySnapshot>() {
            public void apply(final RCProductSummarySnapshot it) {
              Integer _quantity = it.getQuantity();
              int _plus = ((_quantity).intValue() + (RCProductStoreTransactionImpl.this.quantity).intValue());
              it.setQuantity(Integer.valueOf(_plus));
              Double _amount = it.getAmount();
              RCProductEntry _productEntry = RCProductStoreTransactionImpl.this.productStorage.getProductEntry();
              Double _price = _productEntry.getPrice();
              double _multiply = DoubleExtensions.operator_multiply(_price, RCProductStoreTransactionImpl.this.quantity);
              double _plus_1 = ((_amount).doubleValue() + _multiply);
              it.setAmount(Double.valueOf(_plus_1));
              RCProductEntry _productEntry_1 = RCProductStoreTransactionImpl.this.productStorage.getProductEntry();
              Double _price_1 = _productEntry_1.getPrice();
              double _multiply_1 = DoubleExtensions.operator_multiply(_price_1, RCProductStoreTransactionImpl.this.quantity);
              init.apply(it, RCProductStoreTransactionImpl.this.quantity, Double.valueOf(_multiply_1));
            }
          };
        _bean.createOrFindSnapshot(_trimDate, _summary, _function);
      }
    }
  }
  
  public RCProductStoreTransactionProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCProductStoreTransactionProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCProductStoreTransactionProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
