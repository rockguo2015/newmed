package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCSettlement;
import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import com.fudanmed.platform.core.web.client.project.WorkItemStorage4SettlementListPresenterService;
import com.fudanmed.platform.core.web.server.service.project.WorkItemStorage4SettlementCSVMapper;
import com.fudanmed.platform.core.web.server.service.project.WorkItemStorage4SettlementMapper;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStorage4Settlement;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.csv.server.CSVExtensions;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.WorkItemStorage4SettlementListPresenterService")
@Transactional
public class WorkItemStorage4SettlementListPresenterServiceImpl extends BaseService implements WorkItemStorage4SettlementListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemStorage4SettlementMapper mapper;
  
  public Collection<UIWorkItemStorage4Settlement> loadWorkItemStorageList4Settlement(final RCSettlementProxy context) throws SessionTimeOutException, ValidationException {
    RCSettlement _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.domain.RCSettlement)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCWorkItemStorage> _allMaterialItems =  _resolved.getAllMaterialItems();
    final Function1<RCWorkItemStorage,UIWorkItemStorage4Settlement> _function = new Function1<RCWorkItemStorage,UIWorkItemStorage4Settlement>() {
        public UIWorkItemStorage4Settlement apply(final RCWorkItemStorage it) {
          UIWorkItemStorage4Settlement _transform = WorkItemStorage4SettlementListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIWorkItemStorage4Settlement> _map = IterableExtensions.<RCWorkItemStorage, UIWorkItemStorage4Settlement>map(_allMaterialItems, _function);
    Collection<UIWorkItemStorage4Settlement> _unlazy = IterableExtensions2.<UIWorkItemStorage4Settlement>unlazy(_map);
    return _unlazy;
  }
  
  public String prepareExport(final RCSettlementProxy context) throws SessionTimeOutException, ValidationException {
    RCSettlement _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.domain.RCSettlement)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCWorkItemStorage> _allMaterialItems =  _resolved.getAllMaterialItems();
    final Function1<RCWorkItemStorage,UIWorkItemStorage4Settlement> _function = new Function1<RCWorkItemStorage,UIWorkItemStorage4Settlement>() {
        public UIWorkItemStorage4Settlement apply(final RCWorkItemStorage it) {
          UIWorkItemStorage4Settlement _transform = WorkItemStorage4SettlementListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIWorkItemStorage4Settlement> _map = IterableExtensions.<RCWorkItemStorage, UIWorkItemStorage4Settlement>map(_allMaterialItems, _function);
    Collection<UIWorkItemStorage4Settlement> _unlazy = IterableExtensions2.<UIWorkItemStorage4Settlement>unlazy(_map);
    String _csvPrepare = CSVExtensions.<UIWorkItemStorage4Settlement>csvPrepare(this, "settlement", WorkItemStorage4SettlementCSVMapper.class, _unlazy);
    return _csvPrepare;
  }
}
