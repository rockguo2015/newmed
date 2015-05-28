package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.WorkItemStorageMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStorage;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenterService")
@Transactional
public class WorkItemStorageListPresenterServiceImpl extends BaseService implements WorkItemStorageListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemStorageMapper mapper;
  
  public Collection<UIWorkItemStorage> loadWorkItemStorageList4GroupTask(final RCGroupTaskProxy context) throws SessionTimeOutException, ValidationException {
    RCGroupTask _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.domain.RCGroupTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCWorkItemStorage> _storage =  _resolved.getStorage();
    final Function1<RCWorkItemStorage,UIWorkItemStorage> _function = new Function1<RCWorkItemStorage,UIWorkItemStorage>() {
        public UIWorkItemStorage apply(final RCWorkItemStorage it) {
          UIWorkItemStorage _transform = WorkItemStorageListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIWorkItemStorage> _map = IterableExtensions.<RCWorkItemStorage, UIWorkItemStorage>map(_storage, _function);
    Collection<UIWorkItemStorage> _unlazy = IterableExtensions2.<UIWorkItemStorage>unlazy(_map);
    return _unlazy;
  }
  
  public Collection<UIWorkItemStorage> loadWorkItemStorageList4RepairTask(final RCRepairTaskProxy context) throws SessionTimeOutException, ValidationException {
    RCRepairTask _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCWorkItemStorage> _storage =  _resolved.getStorage();
    final Function1<RCWorkItemStorage,UIWorkItemStorage> _function = new Function1<RCWorkItemStorage,UIWorkItemStorage>() {
        public UIWorkItemStorage apply(final RCWorkItemStorage it) {
          UIWorkItemStorage _transform = WorkItemStorageListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIWorkItemStorage> _map = IterableExtensions.<RCWorkItemStorage, UIWorkItemStorage>map(_storage, _function);
    Collection<UIWorkItemStorage> _unlazy = IterableExtensions2.<UIWorkItemStorage>unlazy(_map);
    return _unlazy;
  }
  
  public Collection<UIWorkItemStorage> loadWorkItemStorageList4WorkItemTask(final RCWorkItemTaskProxy context) throws SessionTimeOutException, ValidationException {
    RCWorkItemTask _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.domain.RCWorkItemTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCWorkItemStorage> _storage =  _resolved.getStorage();
    final Function1<RCWorkItemStorage,UIWorkItemStorage> _function = new Function1<RCWorkItemStorage,UIWorkItemStorage>() {
        public UIWorkItemStorage apply(final RCWorkItemStorage it) {
          UIWorkItemStorage _transform = WorkItemStorageListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIWorkItemStorage> _map = IterableExtensions.<RCWorkItemStorage, UIWorkItemStorage>map(_storage, _function);
    Collection<UIWorkItemStorage> _unlazy = IterableExtensions2.<UIWorkItemStorage>unlazy(_map);
    return _unlazy;
  }
}
