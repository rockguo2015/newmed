package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.impl.RCRCProductStorageContainerImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCRCProductStorageContainerProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = RCRCProductStorageContainerImpl.class)
public interface RCRCProductStorageContainer extends IModelObject {
  /**
   * 按照批次先入先出的原则，计算从库存中取出指定数量的产品的集合（仅仅计算）
   */
  public abstract Collection<RCRecordItem> outStockCalculate(final RCProductSpecification productSpec, final Integer quantity, final Boolean isReturnOp);
  
  public abstract RCProductStorage inStock(final RCProductEntry productEntry, final Integer quantity);
  
  public abstract Collection<RCProductStorage> getAllProductStorage(final RCProductSpecification productSpec);
  
  public abstract RCProductStorage getOrCreateProductStorage(final RCProductEntry productEntry);
  
  public abstract RCRCProductStorageContainerProxy toProxy();
}
