package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.deliver.DLDeliverMaterialType;
import com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialCategoryImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialTypeProxy;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLDELIVERMATERIALTYPE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dldelivermaterialtype")
public class DLDeliverMaterialTypeImpl extends BaseModelObject implements DLDeliverMaterialType {
  public DLDeliverMaterialTypeImpl() {
    super();
  }
  
  public DLDeliverMaterialTypeImpl(final DLDeliverMaterialCategory category) {
    super();
    this.category = category;
  }
  
  @JoinColumn(name = "category_id")
  @ManyToOne(targetEntity = DLDeliverMaterialCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLDeliverMaterialCategory category;
  
  public DLDeliverMaterialCategory getCategory() {
    return this.category;
  }
  
  public DLDeliverMaterialType setCategory(final DLDeliverMaterialCategory category) {
    this.category = category;
    return this;			
    
  }
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public DLDeliverMaterialType setCode(final String code) {
    this.code = code;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public DLDeliverMaterialType setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public DLDeliverMaterialType setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  private String unit;
  
  public String getUnit() {
    return this.unit;
  }
  
  public DLDeliverMaterialType setUnit(final String unit) {
    this.unit = unit;
    return this;			
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  private String simplePy;
  
  public String getSimplePy() {
    return this.simplePy;
  }
  
  public DLDeliverMaterialType setSimplePy(final String simplePy) {
    this.simplePy = simplePy;
    return this;			
    
  }
  
  public String getNameField() {
    return "name";
  }
  
  public void update(final Procedure1<? super DLDeliverMaterialType> updater) {
    updater.apply(this);
    this.checkValid();
  }
  
  public void checkValid() {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.code);
    boolean _not = (!_isNullOrEmpty);
    Validates.Assert(_not, "\u5FC5\u987B\u8BBE\u7F6E\u7F16\u7801");
    boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(this.name);
    boolean _not_1 = (!_isNullOrEmpty_1);
    Validates.Assert(_not_1, "\u5FC5\u987B\u8BBE\u7F6E\u540D\u79F0");
    IGenericQuery<DLDeliverMaterialType> query=getObjectFactory().createGenericQuery(DLDeliverMaterialType.class,"select e from com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialTypeImpl as e   where (e.code = :code) and  e.active = 1      ").setParameter("code",code);
    Collection<DLDeliverMaterialType> _list = query.list();
    int _size = _list.size();
    boolean _equals = (_size == 1);
    Validates.Assert(_equals, "\u7F16\u7801\u4E0D\u80FD\u91CD\u590D");
  }
  
  public static DLDeliverMaterialType create(final DLDeliverMaterialCategory category, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLDeliverMaterialType dLDeliverMaterialType = new com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialTypeImpl(
    	category
    );
    objectFactory.create(dLDeliverMaterialType);
    return dLDeliverMaterialType;			
    
  }
  
  public DLDeliverMaterialTypeProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialTypeProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
