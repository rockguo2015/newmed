package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlanCriteria;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlanStatus;
import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanSelectorPresenterService;
import com.fudanmed.platform.core.web.server.service.device.DevicePMPlanCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.device.DevicePMPlanMapper;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.extensions.ModelObjects;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.DevicePMPlanSelectorPresenterService")
@Transactional
public class DevicePMPlanSelectorPresenterServiceImpl extends BaseService implements DevicePMPlanSelectorPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DevicePMPlanCriteriaMapper criteriaMapper;
  
  @Autowired
  private DevicePMPlanMapper mapper;
  
  public IPagedResult<UIDevicePMPlan> filter(final UIDevicePMPlanCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIDevicePMPlan> _xblockexpression = null;
    {
      RCDevicePMPlanCriteria _createPagedCriteria = PagedQueries.createPagedCriteria(uicriteria, RCDevicePMPlanCriteria.class, this.criteriaMapper, this.entities);
      final Procedure1<RCDevicePMPlanCriteria> _function = new Procedure1<RCDevicePMPlanCriteria>() {
          public void apply(final RCDevicePMPlanCriteria it) {
            it.setStatus(RCDevicePMPlanStatus.planed);
          }
        };
      RCDevicePMPlanCriteria c = ObjectExtensions.<RCDevicePMPlanCriteria>operator_doubleArrow(_createPagedCriteria, _function);
      c.setLimit(Integer.valueOf(1000));
      final Function1<RCDevicePMPlan,UIDevicePMPlan> _function_1 = new Function1<RCDevicePMPlan,UIDevicePMPlan>() {
          public UIDevicePMPlan apply(final RCDevicePMPlan it) {
            UIDevicePMPlan _apply = DevicePMPlanSelectorPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIDevicePMPlan> _listAndTransform = PagedQueries.<UIDevicePMPlan, RCDevicePMPlan>listAndTransform(c, new Function<RCDevicePMPlan,UIDevicePMPlan>() {
          public UIDevicePMPlan apply(RCDevicePMPlan input) {
            return _function_1.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public void assignPlansToWorkItem(final RCPMWorkItemProxy workItem, final Collection<RCDevicePMPlanProxy> selectedPlans) throws SessionTimeOutException, ValidationException {
    final Procedure1<RCDevicePMPlanProxy> _function = new Procedure1<RCDevicePMPlanProxy>() {
        public void apply(final RCDevicePMPlanProxy it) {
          RCPMWorkItem _resolved= null;
          if(workItem!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(workItem, entities);
          
          RCDevicePMPlan _resolve = ModelObjects.<RCDevicePMPlan>resolve(DevicePMPlanSelectorPresenterServiceImpl.this.entities, it, RCDevicePMPlan.class);
           _resolved.assignPlan(_resolve);
        }
      };
    IterableExtensions.<RCDevicePMPlanProxy>forEach(selectedPlans, _function);
  }
}
