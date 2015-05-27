package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCSettlement;
import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import edu.fudan.mylang.common.NumberExtensions;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCSETTLEMENT_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcsettlement")
public class RCSettlementImpl extends BaseModelObject implements RCSettlement {
  public RCSettlementImpl() {
    super();
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCSettlement setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public RCSettlement setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  private Date fromDate;
  
  public Date getFromDate() {
    return this.fromDate;
  }
  
  public RCSettlement setFromDate(final Date fromDate) {
    this.fromDate = fromDate;
    return this;			
    
  }
  
  private Date toDate;
  
  public Date getToDate() {
    return this.toDate;
  }
  
  public RCSettlement setToDate(final Date toDate) {
    this.toDate = toDate;
    return this;			
    
  }
  
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public RCSettlement setDescription(final String description) {
    this.description = description;
    return this;			
    
  }
  
  private Double totalAmount;
  
  public Double getTotalAmount() {
    return this.totalAmount;
  }
  
  public RCSettlement setTotalAmount(final Double totalAmount) {
    this.totalAmount = totalAmount;
    return this;			
    
  }
  
  public Collection<RCRepairTask> getAllItems() {
    IGenericQuery<RCRepairTask> query=getObjectFactory().createGenericQuery(RCRepairTask.class,"select rk from com.fudanmed.platform.core.domain.impl.RCRepairTaskImpl as rk   where (rk.settlement = :this) and  rk.active = 1      ").setParameter("this",this);
    Collection<RCRepairTask> _list = query.list();
    return _list;
  }
  
  public Collection<RCWorkItemStorage> getAllMaterialItems() {
    IGenericQuery<RCWorkItemStorage> query=getObjectFactory().createGenericQuery(RCWorkItemStorage.class,"select s from com.fudanmed.platform.core.warehouse.impl.RCWorkItemStorageImpl as s   where (s.workItem.groupTask.repairTask.settlement = :this) and  s.active = 1      ").setParameter("this",this);
    Collection<RCWorkItemStorage> _list = query.list();
    return _list;
  }
  
  public void calculate() {
    Collection<RCRepairTask> _allItems = this.getAllItems();
    final Function1<RCRepairTask,Double> _function = new Function1<RCRepairTask,Double>() {
        public Double apply(final RCRepairTask it) {
          Double _amount = it.getAmount();
          return _amount;
        }
      };
    Iterable<Double> _map = IterableExtensions.<RCRepairTask, Double>map(_allItems, _function);
    final Function2<Double,Double,Double> _function_1 = new Function2<Double,Double,Double>() {
        public Double apply(final Double d1, final Double d2) {
          double _plus = DoubleExtensions.operator_plus(d1, d2);
          return Double.valueOf(_plus);
        }
      };
    Double _reduce = IterableExtensions.<Double>reduce(_map, _function_1);
    Double _nullsafe = NumberExtensions.nullsafe(_reduce);
    this.totalAmount = _nullsafe;
  }
  
  public static RCSettlement create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCSettlement rCSettlement = new com.fudanmed.platform.core.domain.impl.RCSettlementImpl(
    );
    objectFactory.create(rCSettlement);
    return rCSettlement;			
    
  }
  
  public RCSettlementProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCSettlementProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCSettlementProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
