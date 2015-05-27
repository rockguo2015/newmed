package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckTypeImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.google.common.collect.Iterables;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.common.HierarchyExtensions;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IHasHierarchy;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLDELIVERPATIENTCHECKCATEGORY_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dldeliverpatientcheckcategory")
public class DLDeliverPatientCheckCategoryImpl extends BaseModelObject implements DLDeliverPatientCheckCategory {
  public DLDeliverPatientCheckCategoryImpl() {
    super();
  }
  
  public DLDeliverPatientCheckCategoryImpl(final DLDeliverPatientCheckCategory parentCategory) {
    super();
    this.parentCategory = parentCategory;
  }
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public DLDeliverPatientCheckCategory setCode(final String code) {
    this.code = code;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public DLDeliverPatientCheckCategory setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  @JoinColumn(name = "parentCategory_id")
  @ManyToOne(targetEntity = DLDeliverPatientCheckCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLDeliverPatientCheckCategory parentCategory;
  
  public DLDeliverPatientCheckCategory getParentCategory() {
    return this.parentCategory;
  }
  
  public DLDeliverPatientCheckCategory setParentCategory(final DLDeliverPatientCheckCategory parentCategory) {
    this.parentCategory = parentCategory;
    return this;			
    
  }
  
  @OneToMany(targetEntity = DLDeliverPatientCheckCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "parentCategory")
  private Collection<DLDeliverPatientCheckCategory> subCategories = new java.util.ArrayList<com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory>();;
  
  public Collection<DLDeliverPatientCheckCategory> getSubCategories() {
    return this.subCategories;
  }
  
  public DLDeliverPatientCheckCategory createAndAddtoSubCategories() {
    getSubCategories().size();
    com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory dLDeliverPatientCheckCategory = new com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckCategoryImpl(this);
    getObjectFactory().create(dLDeliverPatientCheckCategory);
    getSubCategories().add(dLDeliverPatientCheckCategory);
    return dLDeliverPatientCheckCategory;
    
  }
  
  public DLDeliverPatientCheckCategory removeAllSubCategories() {
    for(DLDeliverPatientCheckCategory obj : this.subCategories){
    	getObjectFactory().delete(obj);
    }
    this.subCategories.clear();
    return this;	
    
  }
  
  public DLDeliverPatientCheckCategory removeFromSubCategories(final DLDeliverPatientCheckCategory dLDeliverPatientCheckCategory) {
    this.subCategories.remove(dLDeliverPatientCheckCategory);
    getObjectFactory().delete(dLDeliverPatientCheckCategory);
    return this;
    
  }
  
  @OneToMany(targetEntity = DLDeliverPatientCheckTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "category")
  private Collection<DLDeliverPatientCheckType> types = new java.util.ArrayList<com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType>();;
  
  public Collection<DLDeliverPatientCheckType> getTypes() {
    return this.types;
  }
  
  public DLDeliverPatientCheckType createAndAddtoTypes() {
    getTypes().size();
    com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType dLDeliverPatientCheckType = new com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckTypeImpl(this);
    getObjectFactory().create(dLDeliverPatientCheckType);
    getTypes().add(dLDeliverPatientCheckType);
    return dLDeliverPatientCheckType;
    
  }
  
  public DLDeliverPatientCheckCategory removeAllTypes() {
    for(DLDeliverPatientCheckType obj : this.types){
    	getObjectFactory().delete(obj);
    }
    this.types.clear();
    return this;	
    
  }
  
  public DLDeliverPatientCheckCategory removeFromTypes(final DLDeliverPatientCheckType dLDeliverPatientCheckType) {
    this.types.remove(dLDeliverPatientCheckType);
    getObjectFactory().delete(dLDeliverPatientCheckType);
    return this;
    
  }
  
  public void update(final Procedure1<? super DLDeliverPatientCheckCategory> updater) {
    updater.apply(this);
    this.checkValid();
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public void checkValid() {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.code);
    boolean _not = (!_isNullOrEmpty);
    Validates.Assert(_not, "\u5FC5\u987B\u8BBE\u7F6E\u7F16\u7801");
    boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(this.name);
    boolean _not_1 = (!_isNullOrEmpty_1);
    Validates.Assert(_not_1, "\u5FC5\u987B\u8BBE\u7F6E\u540D\u79F0");
    IGenericQuery<DLDeliverPatientCheckCategory> query=getObjectFactory().createGenericQuery(DLDeliverPatientCheckCategory.class,"select e from com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckCategoryImpl as e   where (e.code = :code) and  e.active = 1      ").setParameter("code",code);
    Collection<DLDeliverPatientCheckCategory> _list = query.list();
    int _size = _list.size();
    boolean _equals = (_size == 1);
    Validates.Assert(_equals, "\u7F16\u7801\u4E0D\u80FD\u91CD\u590D");
  }
  
  public DLDeliverPatientCheckType createCheckType(final Procedure1<? super DLDeliverPatientCheckType> init) {
    DLDeliverPatientCheckType _createAndAddtoTypes = this.createAndAddtoTypes();
    final Procedure1<DLDeliverPatientCheckType> _function = new Procedure1<DLDeliverPatientCheckType>() {
        public void apply(final DLDeliverPatientCheckType it) {
          init.apply(it);
          it.checkValid();
        }
      };
    DLDeliverPatientCheckType _doubleArrow = ObjectExtensions.<DLDeliverPatientCheckType>operator_doubleArrow(_createAndAddtoTypes, _function);
    return _doubleArrow;
  }
  
  public void deleteCheckType(final DLDeliverPatientCheckType checkType) {
    this.removeFromTypes(checkType);
  }
  
  private String fullIdPath;
  
  public String getFullIdPath() {
    return this.fullIdPath;
  }
  
  public DLDeliverPatientCheckCategory setFullIdPath(final String fullIdPath) {
    this.fullIdPath = fullIdPath;
    return this;			
    
  }
  
  public String getFullPath() {
    final Function1<IHasHierarchy,String> _function = new Function1<IHasHierarchy,String>() {
        public String apply(final IHasHierarchy it) {
          return DLDeliverPatientCheckCategoryImpl.this.name;
        }
      };
    String _fullNamePath = HierarchyExtensions.getFullNamePath(this, _function);
    return _fullNamePath;
  }
  
  public void moveTo(final DLDeliverPatientCheckCategory newParent) {
    HierarchyExtensions.changeParent(this, newParent);
  }
  
  public Iterable<IHasHierarchy> getHierarchyChildren() {
    Iterable<IHasHierarchy> _filter = Iterables.<IHasHierarchy>filter(this.subCategories, IHasHierarchy.class);
    return _filter;
  }
  
  public IHasHierarchy getHierarchyParent() {
    return this.parentCategory;
  }
  
  public void setHierarchyParent(final IHasHierarchy parent) {
    this.parentCategory = ((DLDeliverPatientCheckCategory) parent);
  }
  
  public static DLDeliverPatientCheckCategory create(final DLDeliverPatientCheckCategory parentCategory, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory dLDeliverPatientCheckCategory = new com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckCategoryImpl(
    	parentCategory
    );
    objectFactory.create(dLDeliverPatientCheckCategory);
    return dLDeliverPatientCheckCategory;			
    
  }
  
  public DLDeliverPatientCheckCategoryProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
