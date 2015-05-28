package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.RCEBoardMessageService;
import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTaskCriteria;
import com.fudanmed.platform.core.web.client.project.EBoardPresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskMapper;
import com.fudanmed.platform.core.web.server.service.template.EBoardTemplate;
import com.fudanmed.platform.core.web.shared.project.EBoardResult;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.EBoardPresenterService")
@Transactional
public class EBoardPresenterServiceImpl extends BaseService implements EBoardPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RepairTaskCriteriaMapper criteriaMapper;
  
  @Autowired
  private RepairTaskMapper mapper;
  
  @Autowired
  private RCEBoardMessageService eboardMessageService;
  
  @Autowired
  private RCSystemParameterService systemParameterService;
  
  public Integer loadRefreshInterval() throws SessionTimeOutException, ValidationException {
    RCSystemParameter _systemParameter = this.systemParameterService.getSystemParameter();
    Integer _eboardRefreshInterval = _systemParameter.getEboardRefreshInterval();
    return _eboardRefreshInterval;
  }
  
  public EBoardResult loadActiveTasks(final Integer requestPage) throws SessionTimeOutException, ValidationException {
    EBoardResult _xblockexpression = null;
    {
      UIRepairTaskCriteria _uIRepairTaskCriteria = new UIRepairTaskCriteria();
      final Procedure1<UIRepairTaskCriteria> _function = new Procedure1<UIRepairTaskCriteria>() {
          public void apply(final UIRepairTaskCriteria it) {
            it.setPage(requestPage);
            it.setPageSize(Integer.valueOf(7));
            it.setIncludeFinishedTask(Boolean.valueOf(false));
          }
        };
      final UIRepairTaskCriteria uicriteria = ObjectExtensions.<UIRepairTaskCriteria>operator_doubleArrow(_uIRepairTaskCriteria, _function);
      final RCRepairTaskCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCRepairTaskCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCRepairTask,UIRepairTask> _function_1 = new Function1<RCRepairTask,UIRepairTask>() {
          public UIRepairTask apply(final RCRepairTask it) {
            UIRepairTask _apply = EBoardPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      final IPagedResult<UIRepairTask> tempPagedResult = PagedQueries.<UIRepairTask, RCRepairTask>listAndTransform(c, new Function<RCRepairTask,UIRepairTask>() {
          public UIRepairTask apply(RCRepairTask input) {
            return _function_1.apply(input);
          }
      });
      IPagedResult<UIRepairTask> _xifexpression = null;
      boolean _and = false;
      Collection<UIRepairTask> _result = tempPagedResult.getResult();
      int _size = _result.size();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        long _totalRecords = tempPagedResult.getTotalRecords();
        boolean _notEquals = (_totalRecords != 0);
        _and = (_equals && _notEquals);
      }
      if (_and) {
        final Procedure1<RCRepairTaskCriteria> _function_2 = new Procedure1<RCRepairTaskCriteria>() {
            public void apply(final RCRepairTaskCriteria it) {
              it.setStart(Integer.valueOf(0));
            }
          };
        RCRepairTaskCriteria _doubleArrow = ObjectExtensions.<RCRepairTaskCriteria>operator_doubleArrow(c, _function_2);
        final Function1<RCRepairTask,UIRepairTask> _function_3 = new Function1<RCRepairTask,UIRepairTask>() {
            public UIRepairTask apply(final RCRepairTask it) {
              UIRepairTask _apply = EBoardPresenterServiceImpl.this.mapper.apply(it);
              return _apply;
            }
          };
        IPagedResult<UIRepairTask> _listAndTransform = PagedQueries.<UIRepairTask, RCRepairTask>listAndTransform(_doubleArrow, new Function<RCRepairTask,UIRepairTask>() {
            public UIRepairTask apply(RCRepairTask input) {
              return _function_3.apply(input);
            }
        });
        _xifexpression = _listAndTransform;
      } else {
        _xifexpression = tempPagedResult;
      }
      final IPagedResult pagedResult = ((IPagedResult) _xifexpression);
      EBoardResult _eBoardResult = new EBoardResult();
      final Procedure1<EBoardResult> _function_4 = new Procedure1<EBoardResult>() {
          public void apply(final EBoardResult it) {
            int _page = pagedResult.getPage();
            it.setCurPage(Integer.valueOf(_page));
            long _totalRecords = pagedResult.getTotalRecords();
            double _divide = (_totalRecords / 7d);
            double _ceil = Math.ceil(_divide);
            int _intValue = Double.valueOf(_ceil).intValue();
            it.setTotalPage(Integer.valueOf(_intValue));
            Integer _curPage = it.getCurPage();
            Integer _totalPage = it.getTotalPage();
            String _message = EBoardPresenterServiceImpl.this.eboardMessageService.getMessage();
            Collection _result = pagedResult.getResult();
            String _template = EBoardTemplate.template(_curPage, _totalPage, _message, _result);
            it.setContents(_template);
          }
        };
      EBoardResult _doubleArrow_1 = ObjectExtensions.<EBoardResult>operator_doubleArrow(_eBoardResult, _function_4);
      _xblockexpression = (_doubleArrow_1);
    }
    return _xblockexpression;
  }
}
