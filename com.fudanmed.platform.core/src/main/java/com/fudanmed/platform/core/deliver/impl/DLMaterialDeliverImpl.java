package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialType;
import com.fudanmed.platform.core.deliver.DLMaterialDeliver;
import com.fudanmed.platform.core.deliver.DLMaterialDeliverDetail;
import com.fudanmed.platform.core.deliver.impl.DLDeliverSubjectImpl;
import com.fudanmed.platform.core.deliver.impl.DLMaterialDeliverDetailImpl;
import com.fudanmed.platform.core.deliver.proxy.DLMaterialDeliverProxy;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.impl.RCOnsitePositionImpl;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Entity
@DiscriminatorValue("DLMATERIALDELIVER_TYPE")
public class DLMaterialDeliverImpl extends DLDeliverSubjectImpl implements DLMaterialDeliver {
  public DLMaterialDeliverImpl() {
    super();
  }
  
  @OneToMany(targetEntity = DLMaterialDeliverDetailImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "materialDeliver")
  private Collection<DLMaterialDeliverDetail> materialDetails = new java.util.ArrayList<com.fudanmed.platform.core.deliver.DLMaterialDeliverDetail>();;
  
  public Collection<DLMaterialDeliverDetail> getMaterialDetails() {
    return this.materialDetails;
  }
  
  public DLMaterialDeliverDetail createAndAddtoMaterialDetails() {
    getMaterialDetails().size();
    com.fudanmed.platform.core.deliver.DLMaterialDeliverDetail dLMaterialDeliverDetail = new com.fudanmed.platform.core.deliver.impl.DLMaterialDeliverDetailImpl(this);
    getObjectFactory().create(dLMaterialDeliverDetail);
    getMaterialDetails().add(dLMaterialDeliverDetail);
    return dLMaterialDeliverDetail;
    
  }
  
  public DLMaterialDeliver removeAllMaterialDetails() {
    for(DLMaterialDeliverDetail obj : this.materialDetails){
    	getObjectFactory().delete(obj);
    }
    this.materialDetails.clear();
    return this;	
    
  }
  
  public DLMaterialDeliver removeFromMaterialDetails(final DLMaterialDeliverDetail dLMaterialDeliverDetail) {
    this.materialDetails.remove(dLMaterialDeliverDetail);
    getObjectFactory().delete(dLMaterialDeliverDetail);
    return this;
    
  }
  
  @JoinColumn(name = "fromLocation_id")
  @ManyToOne(targetEntity = RCOnsitePositionImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOnsitePosition fromLocation;
  
  public RCOnsitePosition getFromLocation() {
    return this.fromLocation;
  }
  
  public DLMaterialDeliver setFromLocation(final RCOnsitePosition fromLocation) {
    this.fromLocation = fromLocation;
    return this;			
    
  }
  
  @JoinColumn(name = "toLocation_id")
  @ManyToOne(targetEntity = RCOnsitePositionImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOnsitePosition toLocation;
  
  public RCOnsitePosition getToLocation() {
    return this.toLocation;
  }
  
  public DLMaterialDeliver setToLocation(final RCOnsitePosition toLocation) {
    this.toLocation = toLocation;
    return this;			
    
  }
  
  public void checkValid() {
    super.checkValid();
    boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(this.materialDetails);
    boolean _not = (!_isNullOrEmpty);
    Validates.Assert(_not, "\u7269\u54C1\u4FE1\u606F\u5FC5\u987B\u8F93\u5165");
  }
  
  public String getEntityName() {
    final Function1<DLMaterialDeliverDetail,String> _function = new Function1<DLMaterialDeliverDetail,String>() {
        public String apply(final DLMaterialDeliverDetail it) {
          DLDeliverMaterialType _materialType = it.getMaterialType();
          String _entityName = _materialType.getEntityName();
          String _plus = (_entityName + "(");
          Double _quantity = it.getQuantity();
          String _plus_1 = (_plus + _quantity);
          String _plus_2 = (_plus_1 + ")");
          return _plus_2;
        }
      };
    Iterable<String> _map = IterableExtensions.<DLMaterialDeliverDetail, String>map(this.materialDetails, _function);
    String _join = IterableExtensions.join(_map, ",");
    return _join;
  }
  
  public static DLMaterialDeliver create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLMaterialDeliver dLMaterialDeliver = new com.fudanmed.platform.core.deliver.impl.DLMaterialDeliverImpl(
    );
    objectFactory.create(dLMaterialDeliver);
    return dLMaterialDeliver;			
    
  }
  
  public DLMaterialDeliverProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLMaterialDeliverProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLMaterialDeliverProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
