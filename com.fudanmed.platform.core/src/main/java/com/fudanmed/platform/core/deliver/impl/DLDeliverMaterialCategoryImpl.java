package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.deliver.DLDeliverMaterialType;
import com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialTypeImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
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
@DiscriminatorValue("DLDELIVERMATERIALCATEGORY_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dldelivermaterialcategory")
public class DLDeliverMaterialCategoryImpl extends BaseModelObject implements DLDeliverMaterialCategory {
  public DLDeliverMaterialCategoryImpl() {
    super();
  }
  
  public DLDeliverMaterialCategoryImpl(final DLDeliverMaterialCategory parentCategory) {
    super();
    this.parentCategory = parentCategory;
  }
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public DLDeliverMaterialCategory setCode(final String code) {
    this.code = code;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public DLDeliverMaterialCategory setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  @JoinColumn(name = "parentCategory_id")
  @ManyToOne(targetEntity = DLDeliverMaterialCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLDeliverMaterialCategory parentCategory;
  
  public DLDeliverMaterialCategory getParentCategory() {
    return this.parentCategory;
  }
  
  public DLDeliverMaterialCategory setParentCategory(final DLDeliverMaterialCategory parentCategory) {
    this.parentCategory = parentCategory;
    return this;			
    
  }
  
  @OneToMany(targetEntity = DLDeliverMaterialCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "parentCategory")
  private Collection<DLDeliverMaterialCategory> subCategories = new java.util.ArrayList<com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory>();;
  
  public Collection<DLDeliverMaterialCategory> getSubCategories() {
    return this.subCategories;
  }
  
  public DLDeliverMaterialCategory createAndAddtoSubCategories() {
    getSubCategories().size();
    com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory dLDeliverMaterialCategory = new com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialCategoryImpl(this);
    getObjectFactory().create(dLDeliverMaterialCategory);
    getSubCategories().add(dLDeliverMaterialCategory);
    return dLDeliverMaterialCategory;
    
  }
  
  public DLDeliverMaterialCategory removeAllSubCategories() {
    for(DLDeliverMaterialCategory obj : this.subCategories){
    	getObjectFactory().delete(obj);
    }
    this.subCategories.clear();
    return this;	
    
  }
  
  public DLDeliverMaterialCategory removeFromSubCategories(final DLDeliverMaterialCategory dLDeliverMaterialCategory) {
    this.subCategories.remove(dLDeliverMaterialCategory);
    getObjectFactory().delete(dLDeliverMaterialCategory);
    return this;
    
  }
  
  @OneToMany(targetEntity = DLDeliverMaterialTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "category")
  private Collection<DLDeliverMaterialType> materialTypes = new java.util.ArrayList<com.fudanmed.platform.core.deliver.DLDeliverMaterialType>();;
  
  public Collection<DLDeliverMaterialType> getMaterialTypes() {
    return this.materialTypes;
  }
  
  public DLDeliverMaterialType createAndAddtoMaterialTypes() {
    getMaterialTypes().size();
    com.fudanmed.platform.core.deliver.DLDeliverMaterialType dLDeliverMaterialType = new com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialTypeImpl(this);
    getObjectFactory().create(dLDeliverMaterialType);
    getMaterialTypes().add(dLDeliverMaterialType);
    return dLDeliverMaterialType;
    
  }
  
  public DLDeliverMaterialCategory removeAllMaterialTypes() {
    for(DLDeliverMaterialType obj : this.materialTypes){
    	getObjectFactory().delete(obj);
    }
    this.materialTypes.clear();
    return this;	
    
  }
  
  public DLDeliverMaterialCategory removeFromMaterialTypes(final DLDeliverMaterialType dLDeliverMaterialType) {
    this.materialTypes.remove(dLDeliverMaterialType);
    getObjectFactory().delete(dLDeliverMaterialType);
    return this;
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public void update(final Procedure1<? super DLDeliverMaterialCategory> updater) {
    updater.apply(this);
    this.checkValid();
  }
  
  public void createMaterialType(final Procedure1<? super DLDeliverMaterialType> updater) {
    DLDeliverMaterialType _createAndAddtoMaterialTypes = this.createAndAddtoMaterialTypes();
    final Procedure1<DLDeliverMaterialType> _function = new Procedure1<DLDeliverMaterialType>() {
        public void apply(final DLDeliverMaterialType it) {
          /*it;*/
          updater.apply(it);
          it.checkValid();
        }
      };
    ObjectExtensions.<DLDeliverMaterialType>operator_doubleArrow(_createAndAddtoMaterialTypes, _function);
  }
  
  public void deleteMaterialType(final DLDeliverMaterialType materialType) {
    this.removeFromMaterialTypes(materialType);
  }
  
  public void checkValid() {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.code);
    boolean _not = (!_isNullOrEmpty);
    Validates.Assert(_not, "\u5FC5\u987B\u8BBE\u7F6E\u7F16\u7801");
    boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(this.name);
    boolean _not_1 = (!_isNullOrEmpty_1);
    Validates.Assert(_not_1, "\u5FC5\u987B\u8BBE\u7F6E\u540D\u79F0");
    IGenericQuery<DLDeliverMaterialCategory> query=getObjectFactory().createGenericQuery(DLDeliverMaterialCategory.class,"select e from com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialCategoryImpl as e   where (e.code = :code) and  e.active = 1      ").setParameter("code",code);
    Collection<DLDeliverMaterialCategory> _list = query.list();
    int _size = _list.size();
    boolean _equals = (_size == 1);
    Validates.Assert(_equals, "\u7F16\u7801\u4E0D\u80FD\u91CD\u590D");
  }
  
  private String fullIdPath;
  
  public String getFullIdPath() {
    return this.fullIdPath;
  }
  
  public DLDeliverMaterialCategory setFullIdPath(final String fullIdPath) {
    this.fullIdPath = fullIdPath;
    return this;			
    
  }
  
  public String getFullPath() {
    final Function1<IHasHierarchy,String> _function = new Function1<IHasHierarchy,String>() {
        public String apply(final IHasHierarchy it) {
          return DLDeliverMaterialCategoryImpl.this.name;
        }
      };
    String _fullNamePath = HierarchyExtensions.getFullNamePath(this, _function);
    return _fullNamePath;
  }
  
  public void moveTo(final DLDeliverMaterialCategory newParent) {
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
    this.parentCategory = ((DLDeliverMaterialCategory) parent);
  }
  
  public static DLDeliverMaterialCategory create(final DLDeliverMaterialCategory parentCategory, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory dLDeliverMaterialCategory = new com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialCategoryImpl(
    	parentCategory
    );
    objectFactory.create(dLDeliverMaterialCategory);
    return dLDeliverMaterialCategory;			
    
  }
  
  public DLDeliverMaterialCategoryProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
