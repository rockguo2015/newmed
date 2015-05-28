package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemCriteria;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemDAO;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.client.device.PMTeamWorkItemManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemMapper;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.PMTeamWorkItemManagementPresenterService")
@Transactional
public class PMTeamWorkItemManagementPresenterServiceImpl extends BaseService implements PMTeamWorkItemManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PMWorkItemCriteriaMapper criteriaMapper;
  
  @Autowired
  private PMWorkItemMapper mapper;
  
  @Autowired
  private RCPMWorkItemDAO dao;
  
  public IPagedResult<UIPMWorkItem> filter(final UIPMWorkItemCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIPMWorkItem> _xblockexpression = null;
    {
      RCPMWorkItemCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCPMWorkItemCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCPMWorkItem,UIPMWorkItem> _function = new Function1<RCPMWorkItem,UIPMWorkItem>() {
          public UIPMWorkItem apply(final RCPMWorkItem it) {
            UIPMWorkItem _apply = PMTeamWorkItemManagementPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIPMWorkItem> _listAndTransform = PagedQueries.<UIPMWorkItem, RCPMWorkItem>listAndTransform(c, new Function<RCPMWorkItem,UIPMWorkItem>() {
          public UIPMWorkItem apply(RCPMWorkItem input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public void delete(final RCPMWorkItemProxy value) throws SessionTimeOutException, ValidationException {
    RCPMWorkItem _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    final Procedure1<RCPMWorkItem> _function = new Procedure1<RCPMWorkItem>() {
        public void apply(final RCPMWorkItem it) {
        }
      };
    this.dao.delete( _resolved, _function);
  }
}
