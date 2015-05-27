package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.domain.impl.RCMaintenanceTeamImpl;
import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCStockTakingService;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseService;
import com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageImpl;
import com.fudanmed.platform.core.warehouse.impl.RCRCProductStorageContainerImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.google.common.collect.Iterables;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.common.ObjectExtensions2;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.beans.factory.BeanFactory;

@Entity
@DiscriminatorValue("RCWAREHOUSE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcwarehouse")
public class RCWarehouseImpl extends RCRCProductStorageContainerImpl implements RCWarehouse {
  public RCWarehouseImpl() {
    super();
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCWarehouse setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private String location;
  
  public String getLocation() {
    return this.location;
  }
  
  public RCWarehouse setLocation(final String location) {
    this.location = location;
    return this;			
    
  }
  
  private Boolean isMajor;
  
  public Boolean getIsMajor() {
    return this.isMajor;
  }
  
  public RCWarehouse setIsMajor(final Boolean isMajor) {
    this.isMajor = isMajor;
    return this;			
    
  }
  
  @ManyToMany(targetEntity = RCEmployeeImpl.class)
  @JoinTable(name = "m2m_rcwarehouse_storemanager", joinColumns = @JoinColumn(name = "rcwarehouse_id") , inverseJoinColumns = @JoinColumn(name = "rCEmployee_inv_id") )
  private Collection<RCEmployee> storeManager = new java.util.ArrayList<com.fudanmed.platform.core.domain.RCEmployee>();;
  
  public Collection<RCEmployee> getStoreManager() {
    return this.storeManager;
  }
  
  public RCWarehouse setStoreManager(final Iterable<RCEmployee> storeManager) {
    removeAllStoreManager();
    for(RCEmployee ca : storeManager){
    	addtoStoreManager(ca);
    }
    return this;		
    
  }
  
  public RCWarehouse addtoStoreManager(final RCEmployee rCEmployee) {
    this.storeManager.add(rCEmployee);
    return this;
    
  }
  
  public RCWarehouse removeAllStoreManager() {
    this.storeManager.clear();
    return this;	
    
  }
  
  public RCWarehouse removeFromStoreManager(final RCEmployee rCEmployee) {
    this.storeManager.remove(rCEmployee);
    return this;
    
  }
  
  @ManyToMany(targetEntity = RCMaintenanceTeamImpl.class)
  @JoinTable(name = "m2m_rcwarehouse_relatedteams", joinColumns = @JoinColumn(name = "rcwarehouse_id") , inverseJoinColumns = @JoinColumn(name = "rCMaintenanceTeam_inv_id") )
  private Collection<RCMaintenanceTeam> relatedTeams = new java.util.ArrayList<com.fudanmed.platform.core.domain.RCMaintenanceTeam>();;
  
  public Collection<RCMaintenanceTeam> getRelatedTeams() {
    return this.relatedTeams;
  }
  
  public RCWarehouse setRelatedTeams(final Iterable<RCMaintenanceTeam> relatedTeams) {
    removeAllRelatedTeams();
    for(RCMaintenanceTeam ca : relatedTeams){
    	addtoRelatedTeams(ca);
    }
    return this;		
    
  }
  
  public RCWarehouse addtoRelatedTeams(final RCMaintenanceTeam rCMaintenanceTeam) {
    this.relatedTeams.add(rCMaintenanceTeam);
    return this;
    
  }
  
  public RCWarehouse removeAllRelatedTeams() {
    this.relatedTeams.clear();
    return this;	
    
  }
  
  public RCWarehouse removeFromRelatedTeams(final RCMaintenanceTeam rCMaintenanceTeam) {
    this.relatedTeams.remove(rCMaintenanceTeam);
    return this;
    
  }
  
  public RCProductStorage inStock(final RCProductEntry productEntry, final Integer quantity) {
    RCProductStorage _xblockexpression = null;
    {
      BeanFactory _beanFactory = this.getBeanFactory();
      RCStockTakingService _bean = _beanFactory.<RCStockTakingService>getBean(RCStockTakingService.class);
      Boolean _canPerformStockOperation = _bean.canPerformStockOperation(this);
      Validates.Assert((_canPerformStockOperation).booleanValue(), "\u6B63\u5728\u76D8\u70B9\u4E2D");
      final RCProductStorage result = super.inStock(productEntry, quantity);
      BeanFactory _beanFactory_1 = this.getBeanFactory();
      RCWarehouseService _bean_1 = _beanFactory_1.<RCWarehouseService>getBean(RCWarehouseService.class);
      RCProductSpecification _productSpec = productEntry.getProductSpec();
      final RCProductWarehouseStorageSummary ss = _bean_1.findOrCreateSummaryData(this, _productSpec);
      Integer _quantity = ss.getQuantity();
      int _plus = ((_quantity).intValue() + (quantity).intValue());
      ss.setQuantity(Integer.valueOf(_plus));
      Integer _quantity_1 = ss.getQuantity();
      boolean _greaterEqualsThan = ((_quantity_1).intValue() >= 0);
      RCProductSpecification _productSpec_1 = productEntry.getProductSpec();
      String _name = _productSpec_1.getName();
      String _plus_1 = ("\u64CD\u4F5C\u5C06\u5BFC\u81F4" + _name);
      String _plus_2 = (_plus_1 + "\u5E93\u5B58\u6570\u91CF\u5C0F\u4E8E0");
      Validates.Assert(_greaterEqualsThan, _plus_2);
      Double _amount = ss.getAmount();
      Double _price = productEntry.getPrice();
      double _multiply = DoubleExtensions.operator_multiply(_price, quantity);
      double _plus_3 = ((_amount).doubleValue() + _multiply);
      ss.setAmount(Double.valueOf(_plus_3));
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public RCProductWarehouseStorage getlastProductStorage(final RCProductSpecification productSpec) {
    IGenericQuery<RCProductWarehouseStorage> query=getObjectFactory().createGenericQuery(RCProductWarehouseStorage.class,"select ps from com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageImpl as ps   where ((ps.productEntry.productSpec = :productSpec) and (ps.store = :this)) and  ps.active = 1  order by ps.productEntry.inStockRecord.date DESC    ").setParameter("productSpec",productSpec).setParameter("this",this);
    IGenericQuery<RCProductWarehouseStorage> _setMaxResults = query.setMaxResults(1);
    RCProductWarehouseStorage _uniqueResult = _setMaxResults.uniqueResult();
    return _uniqueResult;
  }
  
  public Collection<RCProductStorage> getAllProductStorage(final RCProductSpecification productSpec) {
    IGenericQuery<RCProductWarehouseStorage> query=getObjectFactory().createGenericQuery(RCProductWarehouseStorage.class,"select ps from com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageImpl as ps   where (((ps.productEntry.productSpec = :productSpec) and (ps.store = :this)) and (ps.quantity <> 0)) and  ps.active = 1  order by ps.productEntry.inStockRecord.date ASC    ").setParameter("productSpec",productSpec).setParameter("this",this);
    Collection<RCProductWarehouseStorage> _list = query.list();
    Iterable<RCProductStorage> _filter = Iterables.<RCProductStorage>filter(_list, RCProductStorage.class);
    List<RCProductStorage> _list_1 = IterableExtensions.<RCProductStorage>toList(_filter);
    return _list_1;
  }
  
  public RCProductStorage getOrCreateProductStorage(final RCProductEntry productEntry) {
    IGenericQuery<RCProductWarehouseStorage> query=getObjectFactory().createGenericQuery(RCProductWarehouseStorage.class,"select ps from com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageImpl as ps   where ((ps.productEntry = :productEntry) and (ps.store = :this)) and  ps.active = 1      ").setParameter("productEntry",productEntry).setParameter("this",this);
    RCProductWarehouseStorage _uniqueResult = query.uniqueResult();
    final Function1<Void,RCProductWarehouseStorage> _function = new Function1<Void,RCProductWarehouseStorage>() {
        public RCProductWarehouseStorage apply(final Void it) {RCProductWarehouseStorage rCProductWarehouseStorage=RCProductWarehouseStorageImpl.create(getObjectFactory());
          final Procedure1<RCProductWarehouseStorage> _function = new Procedure1<RCProductWarehouseStorage>() {
              public void apply(final RCProductWarehouseStorage it) {
                it.setStore(RCWarehouseImpl.this);
                it.setQuantity(Integer.valueOf(0));
                it.setProductEntry(productEntry);
              }
            };
          RCProductWarehouseStorage _doubleArrow = ObjectExtensions.<RCProductWarehouseStorage>operator_doubleArrow(rCProductWarehouseStorage, _function);
          return _doubleArrow;
        }
      };
    RCProductWarehouseStorage _withDefault = ObjectExtensions2.<RCProductWarehouseStorage>withDefault(_uniqueResult, _function);
    return _withDefault;
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public static RCWarehouse create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCWarehouse rCWarehouse = new com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl(
    );
    objectFactory.create(rCWarehouse);
    return rCWarehouse;			
    
  }
  
  public RCWarehouseProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
