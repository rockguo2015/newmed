package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.web.client.project.GroupTaskFinishReportPresenterService;
import com.fudanmed.platform.core.web.server.service.project.GroupTaskFinishReportDataValidator;
import com.fudanmed.platform.core.web.shared.project.GroupTaskFinishReportData;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.GroupTaskFinishReportPresenterService")
@Transactional
public class GroupTaskFinishReportPresenterServiceImpl extends BaseService implements GroupTaskFinishReportPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private GroupTaskFinishReportDataValidator validator;
  
  public void commit(final RCGroupTaskProxy context, final GroupTaskFinishReportData data) throws SessionTimeOutException, ValidationException {
    Validates.<GroupTaskFinishReportData>validateWith(data, this.validator);
    RCGroupTask _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.domain.RCGroupTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    final RCGroupTask value =  _resolved;
    Date _finishDate = data.getFinishDate();
    value.setFinishDate(_finishDate);
    Date _finishTime = data.getFinishTime();
    value.setFinishTime(_finishTime);
    String _comment = data.getComment();
    value.setComment(_comment);
    value.reportFinish();
  }
}
