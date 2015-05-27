package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.RCFaultReportSource;
import com.fudanmed.platform.core.common.RCSequenceService;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTaskDAO;
import com.fudanmed.platform.core.domain.impl.RCRepairTaskImpl;
import com.google.common.base.Objects;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.RCRepairTaskDAO")
public class RCRepairTaskDAOImpl extends BaseDAOService<RCRepairTask> implements RCRepairTaskDAO {
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private RCSequenceService sequenceService;
  
  public RCRepairTask createRepairTask4Reporter(final Procedure1<? super RCRepairTask> postCreate) {RCRepairTask rCRepairTask=RCRepairTaskImpl.create(getObjectFactory());
    final Procedure1<RCRepairTask> _function = new Procedure1<RCRepairTask>() {
        public void apply(final RCRepairTask it) {
          postCreate.apply(it);
          String _nextRepairTaskSequence = RCRepairTaskDAOImpl.this.sequenceService.getNextRepairTaskSequence();
          it.setReportSid(_nextRepairTaskSequence);
          Party _currentUserAsParty = RCRepairTaskDAOImpl.this.systemUserService.getCurrentUserAsParty();
          it.setOperator(_currentUserAsParty);IGenericQuery<RCFaultReportSource> query=getObjectFactory().createGenericQuery(RCFaultReportSource.class,"select e from com.fudanmed.platform.core.common.impl.RCFaultReportSourceImpl as e   where  e.active = 1      ");
          Collection<RCFaultReportSource> _list = query.list();
          final Function1<RCFaultReportSource,Boolean> _function = new Function1<RCFaultReportSource,Boolean>() {
              public Boolean apply(final RCFaultReportSource it) {
                String _codeid = it.getCodeid();
                boolean _equals = Objects.equal(_codeid, "_01");
                return Boolean.valueOf(_equals);
              }
            };
          Iterable<RCFaultReportSource> _filter = IterableExtensions.<RCFaultReportSource>filter(_list, _function);
          RCFaultReportSource _head = IterableExtensions.<RCFaultReportSource>head(_filter);
          it.setFaultReportSource(_head);IGenericQuery<RCFaultLevel> query_1=getObjectFactory().createGenericQuery(RCFaultLevel.class,"select e from com.fudanmed.platform.core.common.impl.RCFaultLevelImpl as e   where  e.active = 1  order by e.codeid ASC    ");
          Collection<RCFaultLevel> _list_1 = query_1.list();
          RCFaultLevel _head_1 = IterableExtensions.<RCFaultLevel>head(_list_1);
          it.setFaultLevel(_head_1);
        }
      };
    RCRepairTask _doubleArrow = ObjectExtensions.<RCRepairTask>operator_doubleArrow(rCRepairTask, _function);
    return _doubleArrow;
  }
}
