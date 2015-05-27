package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.events.RCEmployeeEventsListener;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.event.BaseEntityEventsListener;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.RCEmployeeListener")
public class RCEmployeeListener extends BaseEntityEventsListener<RCEmployee> implements RCEmployeeEventsListener {
  public void entityCreated(final RCEmployee entity) {
  }
  
  public void leaveJob(final RCEmployee entity) {IGenericQuery<RCWarehouse> query=getObjectFactory().createGenericQuery(RCWarehouse.class,"select e from com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl as e   where  e.active = 1      ");
    Collection<RCWarehouse> _list = query.list();
    final Function1<RCWarehouse,Boolean> _function = new Function1<RCWarehouse,Boolean>() {
        public Boolean apply(final RCWarehouse it) {
          Collection<RCEmployee> _storeManager = it.getStoreManager();
          boolean _contains = _storeManager.contains(entity);
          return Boolean.valueOf(_contains);
        }
      };
    Iterable<RCWarehouse> _filter = IterableExtensions.<RCWarehouse>filter(_list, _function);
    final Procedure1<RCWarehouse> _function_1 = new Procedure1<RCWarehouse>() {
        public void apply(final RCWarehouse it) {
          it.removeFromStoreManager(entity);
        }
      };
    IterableExtensions.<RCWarehouse>forEach(_filter, _function_1);
  }
  
  public void returnJob(final RCEmployee entity) {
  }
}
