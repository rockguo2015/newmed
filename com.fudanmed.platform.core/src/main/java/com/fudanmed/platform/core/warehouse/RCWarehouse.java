package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage;
import com.fudanmed.platform.core.warehouse.RCRCProductStorageContainer;
import com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.INamedModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = RCWarehouseImpl.class)
public interface RCWarehouse extends RCRCProductStorageContainer, INamedModelObject {
  public abstract String getName();
  
  public abstract RCWarehouse setName(final String name);
  
  public abstract String getLocation();
  
  public abstract RCWarehouse setLocation(final String location);
  
  public abstract Boolean getIsMajor();
  
  public abstract RCWarehouse setIsMajor(final Boolean isMajor);
  
  public abstract Collection<RCEmployee> getStoreManager();
  
  public abstract RCWarehouse addtoStoreManager(final RCEmployee rCEmployee);
  
  public abstract RCWarehouse setStoreManager(final Iterable<RCEmployee> storeManager);
  
  public abstract RCWarehouse removeFromStoreManager(final RCEmployee rCEmployee);
  
  public abstract RCWarehouse removeAllStoreManager();
  
  public abstract Collection<RCMaintenanceTeam> getRelatedTeams();
  
  public abstract RCWarehouse addtoRelatedTeams(final RCMaintenanceTeam rCMaintenanceTeam);
  
  public abstract RCWarehouse setRelatedTeams(final Iterable<RCMaintenanceTeam> relatedTeams);
  
  public abstract RCWarehouse removeFromRelatedTeams(final RCMaintenanceTeam rCMaintenanceTeam);
  
  public abstract RCWarehouse removeAllRelatedTeams();
  
  public abstract RCProductStorage inStock(final RCProductEntry productEntry, final Integer quantity);
  
  public abstract RCProductWarehouseStorage getlastProductStorage(final RCProductSpecification productSpec);
  
  public abstract Collection<RCProductStorage> getAllProductStorage(final RCProductSpecification productSpec);
  
  public abstract RCProductStorage getOrCreateProductStorage(final RCProductEntry productEntry);
  
  public abstract String getEntityName();
  
  public abstract RCWarehouseProxy toProxy();
}
