package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.web.client.project.GroupTaskMisDispatchReportPresenterService;
import com.fudanmed.platform.core.web.server.service.project.GroupTaskMisDispatchReportDataValidator;
import com.fudanmed.platform.core.web.shared.project.GroupTaskMisDispatchReportData;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.GroupTaskMisDispatchReportPresenterService")
@Transactional
public class GroupTaskMisDispatchReportPresenterServiceImpl extends BaseService implements GroupTaskMisDispatchReportPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private GroupTaskMisDispatchReportDataValidator validator;
  
  public void commit(final RCGroupTaskProxy context, final GroupTaskMisDispatchReportData data) throws SessionTimeOutException, ValidationException {
    Validates.<GroupTaskMisDispatchReportData>validateWith(data, this.validator);
    RCGroupTask _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.domain.RCGroupTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    final Procedure1<RCGroupTask> _function = new Procedure1<RCGroupTask>() {
        public void apply(final RCGroupTask it) {
          Date _finishDate = data.getFinishDate();
          it.setFinishDate(_finishDate);
          Date _finishTime = data.getFinishTime();
          it.setFinishTime(_finishTime);
          String _comment = data.getComment();
          it.setComment(_comment);
          it.reportMisdispatch();
        }
      };
    ObjectExtensions.<RCGroupTask>operator_doubleArrow( _resolved, _function);
  }
}
